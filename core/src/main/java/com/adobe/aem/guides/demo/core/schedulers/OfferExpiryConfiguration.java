package com.adobe.aem.guides.demo.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="OfferExpiryConfiguration",description = "About OfferExpiryConfiguration")
public @interface OfferExpiryConfiguration {
  
@AttributeDefinition(name = "SchedulerName",description = " About SchedulerName",defaultValue = "OfferExpiryScheduler")
public String schedulerName();

@AttributeDefinition(name="schedulerExpression",description="About schedulerExpression",defaultValue = "*/5 * * * * * ?")
public String schedulerExpression();

@AttributeDefinition(name ="Concurrent Scheduler",description="About concurrent_scheduler")
public boolean concurrent_scheduler() default false;

@AttributeDefinition(name ="Enabled Scheduler",description="About enable_scheduler")
public boolean enable_scheduler() default true;
}
