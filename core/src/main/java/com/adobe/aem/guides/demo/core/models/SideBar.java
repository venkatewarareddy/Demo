package com.adobe.aem.guides.demo.core.models;

import java.util.List;
import java.util.Map;

public interface SideBar {

  public String  getLogoPath();

  public String getLogoMobileImage();

  public String getLogoLink();

  public boolean isEnableSwitch();

  List<Map<String,String>>getHeaderLinks();

  public String getCountry();
}
