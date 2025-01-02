package com.adobe.aem.guides.demo.core.schedulers;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
@ObjectClassDefinition(name="PagePublishConfig",description = "PagePublishConfig for scheduler")
public @interface PublishPagesConfig {
     @AttributeDefinition(name = "CRON Expression",
                description = "CRON expression for scheduling the page publishing task")
        String scheduler_expression(); 

        @AttributeDefinition(name = "Page Path",
                description = "Path of the page under which all pages will be published")
        String page_path() default "/content/example";

        @AttributeDefinition(name = "Enable Scheduler",
                description = "Enable or disable the scheduler")
        boolean scheduler_enabled() default true;
    }

