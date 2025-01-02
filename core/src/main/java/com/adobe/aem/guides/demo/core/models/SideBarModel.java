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

@Model(adaptables = {SlingHttpServletRequest.class,Resource.class},
         adapters = SideBar.class,
         defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SideBarModel implements SideBar{


  @ValueMapValue
  private String logoPath;

  @ValueMapValue
  private String logoMobileImage;

  @ValueMapValue
  private String logoLink;

   @ValueMapValue
   private boolean enableSwitch;

   @ValueMapValue
   private String country;

   @ValueMapValue
   List<Map<String,String>>headerLinks;

   @SlingObject
   Resource componentResource;
  
  @Override
  public String getLogoPath() {
   
    return logoPath;
  }

  @Override
  public String getLogoMobileImage() {
    
    return logoMobileImage;
  }

  @Override
  public String getLogoLink() {
    
    return logoLink;
  }

   @Override
    public boolean isEnableSwitch() {
      
      return enableSwitch;
    }

    @Override
    public List<Map<String, String>> getHeaderLinks() {
       List<Map<String, String>> headerLinksMaps=new ArrayList<>();
        try {
            Resource headerLink=componentResource.getChild("headerLinks");
            if(headerLink!=null){
                for (Resource link : headerLink.getChildren()) {
                    Map<String,String> linkMap=new HashMap<>();
                    linkMap.put("name",link.getValueMap().get("name",String.class));
                    linkMap.put("image",link.getValueMap().get("image",String.class));
                    headerLinksMaps.add(linkMap);
                }
            }
        }catch (Exception e){

        }  
        return headerLinksMaps;
    }

    @Override
    public String getCountry() {
      
      return country;
    }
  }
