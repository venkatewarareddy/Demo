package com.adobe.aem.guides.demo.core.models;
import java.util.List;
import java.util.Map;
public interface Header {

public String getTitle();
public String getImg();
public boolean isActive();
 List<Map<String,String>>getLinksMaps();


}
