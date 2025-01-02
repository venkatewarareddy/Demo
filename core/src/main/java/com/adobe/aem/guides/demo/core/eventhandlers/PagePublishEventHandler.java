package com.adobe.aem.guides.demo.core.eventhandlers;

import com.day.cq.replication.ReplicationAction;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;

@Component(
        service = EventHandler.class,
        property = {
               // "event.topics=org/apache/sling/api/resource/ResourceEvent/ADDED",
                EventConstants.EVENT_TOPIC+"="+ ReplicationAction.EVENT_TOPIC
                //"event.filter=(resourceType=cq/Page)"
        }
)
public class PagePublishEventHandler implements EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(PagePublishEventHandler.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public void handleEvent(Event event) {
        String path = (String) event.getProperty("path");

        if (path != null && path.startsWith("/content/Demo/*")) {
            try (ResourceResolver resourceResolver = getServiceResourceResolver()) {
                Resource resource = resourceResolver.getResource(path + "/jcr:content");
                if (resource != null) {
                    ModifiableValueMap properties = resource.adaptTo(ModifiableValueMap.class);
                    if (properties != null) {
                        properties.put("changed", true);
                        resourceResolver.commit();
                        LOG.info("Page published: {}. Property 'changed' set to true.", path);
                    }
                } else {
                    LOG.warn("jcr:content node not found for path: {}", path);
                }
            } catch (Exception e) {
                LOG.error("Error handling page publish event for path: {}", path, e);
            }
        } else {
            LOG.debug("Ignored event for non-content path: {}", path);
        }
    }

    private ResourceResolver getServiceResourceResolver() throws Exception {
        return resourceResolverFactory.getServiceResourceResolver(
                Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, "jenny")
        );
    }
}
