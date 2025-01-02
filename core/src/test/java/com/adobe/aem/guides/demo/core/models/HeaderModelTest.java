package com.adobe.aem.guides.demo.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HeaderModelTest {
    AemContext aemContext = new AemContext();
    HeaderModel headerModel;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(ArticleDetailsModel.class);
        aemContext.load().json("/com/adobe/aem/guides/demo/core/models/HeaderModel.json","/content");
    Resource headerJsonResource= aemContext.currentResource("/content/basic-header");
      headerModel =  headerJsonResource.adaptTo(HeaderModel.class);
    }
    @Test
    void headerTest(){
        assertEquals("KALKI",headerModel.getTitle());
        assertEquals("/content/dam/Demo/asset.jpg",headerModel.getImg());
        assertEquals(true,headerModel.isActive());
        assertEquals(1,headerModel.getLinksMaps().size());
    }
}