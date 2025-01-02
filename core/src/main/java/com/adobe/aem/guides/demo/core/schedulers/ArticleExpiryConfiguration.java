package com.adobe.aem.guides.demo.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="ArticleExpiryConfiguration",description = "About ArticleExpiryConfiguration")
public @interface ArticleExpiryConfiguration {

  @AttributeDefinition(name = "Scheduler name",
            description = " About Scheduler name",
            type = AttributeType.STRING,
            defaultValue = "ArticleExpiryScheduler")
       public String scheduler_name();

  @AttributeDefinition(name = "Scheduler Expression",
            description = " About Cron  Expression",
            type = AttributeType.STRING)
       public String scheduler_expression() default "0 * * * * ?";

  @AttributeDefinition(name = "concurrent scheduler",
            description = "About concurrent_scheduler",
            type = AttributeType.BOOLEAN)
       public boolean concurrent_scheduler() default false;

  @AttributeDefinition(name = "Enabled scheduler",
            description = "About Enabled scheduler",
            type = AttributeType.BOOLEAN)
       public boolean enable_scheduler() default true;
}
