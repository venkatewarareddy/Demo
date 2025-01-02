package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service = ArticleService.class,immediate = true)
public class ArticleService {

  private static Logger Log =LoggerFactory.getLogger(ArticleService.class);

  @Activate
	public void active( ) {
		
		Log.info("ArticleService is Activated()");
	}
  public String articles(){
    Log.info("Data from ArticlesMethod");
    return "This is data from ArticleService";
  }
}
