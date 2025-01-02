package com.adobe.aem.guides.demo.core.models;

import java.util.Date;
import java.util.List;
import javax.inject.Named;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.day.cq.wcm.api.Page;
@Model(adaptables ={Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL )
public class ArticleDetailsModel implements ArticleDetails{

  @ValueMapValue
  public String articleTitle;
  
  @ValueMapValue
  public String articleDecs;

  @ValueMapValue
  public String articleImg;
  
  @ValueMapValue
  public Date articleDate;

  @ValueMapValue
  public List<String> links;

  @ScriptVariable
  Page currentPage;

    @ValueMapValue
    @Named(value="jcr:createdBy")
    public String createdBy;

  @Override
  public Date getArticleDate() {
    
    return articleDate;
  }

  @Override
  public String getArticleDecs() {
    
    return articleDecs;
  }

  @Override
  public String getArticleTitle() {
    
    return articleTitle;
  }

  @Override
  public List<String> getLinks() {
    
    return links;
  }

  @Override
  public String getrAticleImg() {
    return articleImg;
  }

  @Override
  public String getCurrentPageTitle() {
    
    return currentPage.getTitle();
  }

  @Override
  public String getPageCreatedBy() {
    
    return createdBy;
  }

}
