package com.adobe.aem.guides.demo.core.models;

import java.util.List;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.api.resource.Resource;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Surgemodel {
  
  @ChildResource
  private List<Dell>carouselDetails;

  public List<Dell> getCarouselDetails() {
    return carouselDetails;
  }
  

}
