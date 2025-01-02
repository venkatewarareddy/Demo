package com.adobe.aem.guides.demo.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SingleArticleModel {

  @ValueMapValue
  private boolean enablePii;

  @ValueMapValue
  private String cssClass;

  public boolean isEnablePii() {
    return enablePii;
  }

  public String getCssClass() {
    return cssClass;
  }

   @PostConstruct
   public void init(){
    if(!enablePii){
      cssClass =null;
    }
   }
}
