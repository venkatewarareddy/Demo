package com.adobe.aem.guides.demo.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Dell {
  @ValueMapValue
  private String carouselTitle;
  @ValueMapValue
  private String carouselImage;

  @ChildResource
  private String[] carouselIcon;

  public String[] getCarouselIcon() {
    return carouselIcon;
  }
  public String getCarouselTitle() {
    return carouselTitle;
  }
  public String getCarouselImage() {
    return carouselImage;
  }


}
