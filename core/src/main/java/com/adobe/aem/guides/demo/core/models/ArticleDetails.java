package com.adobe.aem.guides.demo.core.models;

import java.util.Date;
import java.util.List;

public interface ArticleDetails {

public String getArticleTitle();
public String getArticleDecs();
public String getrAticleImg();
public Date getArticleDate();
public List<String> getLinks();
public String getCurrentPageTitle();
public String getPageCreatedBy();

}
