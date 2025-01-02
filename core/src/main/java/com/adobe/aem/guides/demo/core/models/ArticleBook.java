package com.adobe.aem.guides.demo.core.models;

import java.util.List;
import com.adobe.aem.guides.demo.core.helper.MultifieldHelper;
public interface ArticleBook {

  public String getArticleName();
  
  List<MultifieldHelper>getBookDetailsWithMap();
}
