package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = ArticleDetailsService.class,immediate = true)
public class ArticleDetailsService {
  private static Logger Log =LoggerFactory.getLogger(ArticleDetailsService.class);
	
	@Reference
  ArticleService articleService;
	@Activate
	public void active( ) {
		Log.info("ArticleDetailsService is Activated()");
		Log.info("Result[]:"+ articleService.articles());
	}
	@Deactivate
	public void deactive() {
		
		Log.info("ArticleDetailsService is Deactivate()");
		
	}
	@Modified
	public void update() {
		
		Log.info("ArticleDetailsService is update()");
		
	}
	
}

