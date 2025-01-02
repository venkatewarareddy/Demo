package com.adobe.aem.guides.demo.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=ArticleExpiry.class,immediate = true)
@Designate(ocd=ArticleExpiryConfiguration.class)
public class ArticleExpiry implements Runnable{

  private  final Logger LOG = LoggerFactory.getLogger(getClass());

  @Reference
  private Scheduler scheduler;

  @Activate
  public void activate(ArticleExpiryConfiguration configuration){

    LOG.info("ArticleExpiry activate()");
    updateData(configuration);
  }
  @Deactivate
  public void deactivate(ArticleExpiryConfiguration configuration){
 LOG.info("ArticleExpiry deactivate()");
  }
  @Modified
  public void modify(ArticleExpiryConfiguration configuration){
 LOG.info("ArticleExpiry modify()");
  }

  public void updateData(ArticleExpiryConfiguration configuration){
     LOG.info("Scheduler added successfully >>>>>>>   ");
    if(configuration.enable_scheduler()){
      ScheduleOptions options = scheduler.EXPR(configuration.scheduler_expression());
                    options.name(configuration.scheduler_name());
                    options.canRunConcurrently(configuration.concurrent_scheduler());
                    scheduler.schedule(this, options);
        LOG.info("Scheduler added successfully name='{}'", configuration.scheduler_name());;
    }
    else{
      scheduler.unschedule(configuration.scheduler_name());
    }

  }
  @Override
  public void run() {
    LOG.info("ArticleExpiry run() >>>>>");
  }

}
