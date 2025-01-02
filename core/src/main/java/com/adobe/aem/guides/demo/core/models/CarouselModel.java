package com.adobe.aem.guides.demo.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables ={Resource.class,SlingHttpServletRequest.class},
      adapters = Carousel.class,
      defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselModel implements Carousel{

   @SlingObject
   Resource componentResource;

  @Override
  public List<String> getcarouselIcon() {
    List<String> carouselIcon =new ArrayList<>();
    return new ArrayList<String>(carouselIcon);
  }

   @Override
  public List<Map<String, String>> getcarouselDetails() {
     List<Map<String, String>> carouselDetailsMap=new ArrayList<>();
     try {
            Resource carouselDetail=componentResource.getChild("carouselDetails");
            if(carouselDetail!=null){
                for (Resource carousel : carouselDetail.getChildren()) {
                    Map<String,String> carouselMap=new HashMap<>();
                    carouselMap.put("carouselTitle",carousel.getValueMap().get("carouselTitle",String.class));
                    carouselMap.put("carouselImage",carousel.getValueMap().get("carouselImage",String.class));
                    carouselDetailsMap.add(carouselMap);
                }
            }
        }catch (Exception e){
          
        }  
        return carouselDetailsMap;
  }
}

