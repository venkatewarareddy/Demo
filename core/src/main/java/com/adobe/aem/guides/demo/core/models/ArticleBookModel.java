package com.adobe.aem.guides.demo.core.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.aem.guides.demo.core.helper.MultifieldHelper;

@Model( adaptables = {Resource.class,SlingHttpServletRequest.class},
        adapters = ArticleBook.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ArticleBookModel implements ArticleBook{

  @ValueMapValue
  public String articlename;

  @SlingObject
  Resource componentResource;

  @Override
  public String getArticleName() {
    
    return articlename;
  }

   @Override
    public List<MultifieldHelper> getBookDetailsWithMap() {
        List<MultifieldHelper> bookDetails=new ArrayList<>();
        try {
            Resource bookDetail=componentResource.getChild("bookdetailswithmap");
            if(bookDetail!=null){
                for (Resource book : bookDetail.getChildren()) {
                    book.getValueMap().get("bookname",String.class);
                    book.getValueMap().get("copies",String.class);
                    book.getValueMap().get("publishdate",Date.class);
                    bookDetails.add(new MultifieldHelper(book));
                }
            }
        }catch (Exception e){
            
        }      
        return bookDetails;
    }


}