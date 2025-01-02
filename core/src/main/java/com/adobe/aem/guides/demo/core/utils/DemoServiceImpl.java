package com.adobe.aem.guides.demo.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service =DemoService.class)
public class DemoServiceImpl implements DemoService{

@Reference
ResourceResolverFactory factory;
  @Override
  public ResourceResolver getResourceResolver() {
     
    ResourceResolver resolver=null;
		try {
			Map<String,Object>props=new HashMap<>();
			props.put(ResourceResolverFactory.SUBSERVICE, "venkatuser");
			resolver=factory.getServiceResourceResolver(props);
		} catch (LoginException e) {
			e.printStackTrace();
		}
		return resolver;
	}
  }
