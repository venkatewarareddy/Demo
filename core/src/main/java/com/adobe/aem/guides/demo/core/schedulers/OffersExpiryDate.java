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

@Component(service = Runnable.class,immediate = true)
@Designate(ocd = OfferExpiryConfiguration.class)
public class OffersExpiryDate implements Runnable {

   private static final Logger log = LoggerFactory.getLogger(OffersExpiryDate.class);

   @Reference
   Scheduler scheduler;

    @Activate
  public void activate(OfferExpiryConfiguration configuration){
     log.info("OfferExpiry activate()>>>>>>>");
    updateLatestValues(configuration);
  }  
  @Deactivate
  public void deactivate(OfferExpiryConfiguration configuration){
     log.info("OfferExpiry deactivate()>>>>>>>>");
  }
  @Modified
  public void modify(OfferExpiryConfiguration configuration){
    log.info("OfferExpiry modify()>>>>>>>");
  }
  
  
  public void updateLatestValues(OfferExpiryConfiguration configuration){
if(configuration.enable_scheduler()){
     ScheduleOptions options = scheduler.EXPR(configuration.schedulerExpression());
        options.canRunConcurrently(false);
        options.name(configuration.schedulerName());
        scheduler.schedule(this, options);
      }
  else{
    scheduler.unschedule(configuration.schedulerName());
  }
    }
  
  
  
  @Override
  public void run() {
    
    log.info("offer expiry run()>>>>>>>>>>>>>>>>>>>>>>");
  }

}
