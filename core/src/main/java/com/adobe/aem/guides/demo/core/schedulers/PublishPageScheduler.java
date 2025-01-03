package com.adobe.aem.guides.demo.core.schedulers;

import com.day.cq.replication.Replicator;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component(immediate = true, service = Runnable.class)
@Designate(ocd = PublishPagesConfig.class)
public class PublishPageScheduler implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(PublishPageScheduler.class);

    @Reference
    private Scheduler scheduler;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Reference
    private Replicator replicator;

    private String cronExpression;
    private String pagePath;
    private boolean isSchedulerEnabled;

    @Activate
    @Modified
    protected void activate(PublishPagesConfig config) {
        this.cronExpression = config.scheduler_expression();
        this.pagePath = config.page_path();
        this.isSchedulerEnabled = config.scheduler_enabled();

        if (isSchedulerEnabled) {
            ScheduleOptions options = scheduler.EXPR(cronExpression);
            options.name("PagePublishingScheduler").canRunConcurrently(false);
            scheduler.schedule(this, options);
            LOG.info("Scheduler activated with cron expression: {}", cronExpression);
        } else {
            LOG.info("Page Publishing Scheduler is disabled.");
        }
    }

     @Override
    public void run() {
        LOG.info("Scheduler triggered. Attempting to list child pages under: {}", pagePath);

        try (ResourceResolver resourceResolver = getServiceResourceResolver()) {
            Resource rootResource = resourceResolver.getResource(pagePath);
            if (rootResource == null) {
                LOG.error("Page path {} does not exist or is inaccessible.", pagePath);
                return;
            }

            listChildPagesRecursively(rootResource);
            LOG.info("Completed listing child pages under: {}", pagePath);
        } catch (Exception e) {
            LOG.error("Error occurred while listing child pages under {}: {}", pagePath, e.getMessage(), e);
        }
    }

    private void listChildPagesRecursively(Resource resource) {
        try {
            // Log the current page
            LOG.info("Found page: {}", resource.getPath());

            // Iterate through child pages
            Iterator<Resource> children = resource.listChildren();
            while (children.hasNext()) {
                Resource child = children.next();
                listChildPagesRecursively(child);  // Recursively list child pages
            }
        } catch (Exception e) {
            LOG.error("Error listing children for page: {}", resource.getPath(), e);
        }
    }

    private ResourceResolver getServiceResourceResolver() throws Exception {
        Map<String, Object> authInfo = new HashMap<>();
        authInfo.put(ResourceResolverFactory.SUBSERVICE, "venkat"); // Subservice name
        return resourceResolverFactory.getServiceResourceResolver(authInfo);
    }
}
