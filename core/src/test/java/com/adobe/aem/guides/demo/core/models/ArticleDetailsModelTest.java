package com.adobe.aem.guides.demo.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class ArticleDetailsModelTest {
    AemContext aemContext = new AemContext();
    ArticleDetailsModel articleDetailsModel;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(ArticleDetailsModel.class);
        Map<String,Object> props = new HashMap<>();
        props.put("articleTitle","KALKI-2898");
        props.put("articleDecs","KALKI-2898 Description");
        props.put("articleImg","/content/dam/demo/asset.jpg");
        props.put("articleDate","04/06/2000");
//        props.put("jcr:createdBy","admin");
//        props.put("currentPage","KALKI");
      Resource resource = aemContext.create().resource("/content/demo/article-details",props);
        articleDetailsModel =  resource.adaptTo(ArticleDetailsModel.class);
    }
    @Test
    void articlePropsTest(){
        assertEquals("KALKI-2898",articleDetailsModel.getArticleTitle());
        assertEquals("KALKI-2898 Description",articleDetailsModel.getArticleDecs());
        assertEquals("/content/dam/demo/asset.jpg",articleDetailsModel.getrAticleImg());
//        assertEquals("admin",articleDetailsModel.getPageCreatedBy());
//        assertEquals("KALKI",articleDetailsModel.getCurrentPageTitle());
    }
}