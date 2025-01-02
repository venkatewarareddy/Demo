package com.adobe.aem.guides.demo.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoTestModel {
    private static final Logger LOG = LoggerFactory.getLogger(DemoTestModel.class);

    @Inject
    Resource componentResource;

    public List<Map<String,String >> getPrintData()
    {
        List<Map<String,String>> li=new ArrayList<>();
        Resource bookMap=componentResource.getChild("details");
       try
       {
        if(bookMap !=null)
       { 
          for(Resource book : bookMap.getChildren())
          {
                      Map<String,String> hm=new HashMap<>();
                      hm.put("bookname", book.getValueMap().get("bookname", String.class));
                      hm.put("booksubject", book.getValueMap().get("booksubject", String.class));
                      hm.put("bookpublishyear", book.getValueMap().get("bookpublishyear", String.class));
                      li.add(hm);
          }
         
                  
       }
       }
       catch(Exception e)
       {
        LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
       }
       LOG.info("\n SIZE {} ",li.size());

       return li;



    }

}