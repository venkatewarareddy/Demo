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
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables ={Resource.class,SlingHttpServletRequest.class},
adapters = Header.class,
defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL)

public class HeaderModel implements Header{
private static final Logger LOG = LoggerFactory.getLogger(HeaderModel.class);

@ValueMapValue
public String title;

@ValueMapValue
public String image;

@ValueMapValue
boolean isActive;

@SlingObject
Resource componentResource;

@Override
public String getTitle() {
  
  return title;
}
@Override
public String getImg() {
  
  return image;
}

@Override
public boolean isActive() {
  
  return isActive;
}
@Override
public List<Map<String, String>> getLinksMaps() {
  
  List<Map<String, String>> techs=new ArrayList<>();
        try {
            Resource techResource = componentResource.getChild("techs");
            if(techResource!=null){
                for (Resource tech : techResource.getChildren()) {
                    Map<String,String> techMap=new HashMap<>();
                    techMap.put("text",tech.getValueMap().get("text",String.class));
                    techMap.put("booksubject",tech.getValueMap().get("booksubject",String.class));
                    techs.add(techMap);               
                }
            }
        }catch (Exception e){
          LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
        }
        LOG.info("\n SIZE {} ",techs.size());
        return techs;
   }
}
