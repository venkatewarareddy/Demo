package com.adobe.aem.guides.demo.core.helper;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultifieldHelper {
    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);
    private String bookname;
    private String booksubject;
    private Date publishdate;
    private int copies;
    private List<NastedHalper> bookEditons;
    public MultifieldHelper(Resource resource){
        try {
            if(StringUtils.isNotBlank(resource.getValueMap().get("bookname", String.class))) {
                this.bookname = resource.getValueMap().get("bookname", String.class);
            }
            if(StringUtils.isNotBlank(resource.getValueMap().get("booksubject", String.class))) {
                this.booksubject=resource.getValueMap().get("booksubject",String.class);
            }
            if(resource.getValueMap().get("publishdate",Date.class)!=null) {
                this.publishdate=resource.getValueMap().get("publishdate",Date.class);
            }
            if(resource.getValueMap().get("copies",Integer.class)!=null) {
                this.copies=resource.getValueMap().get("copies",Integer.class);
            }

        }catch (Exception e){
            LOG.info("\n BEAN ERROR : {}",e.getMessage());
        }

    }

    public String getBookName() {
        return bookname;
    }

    public Date getPublishDate() {
        return publishdate;
    }

    public int getCopies() {
        return copies;
    }

    public String getBookSubject() {
        return booksubject;
    }

    public List<NastedHalper> getBookEditons() {
        return bookEditons;
    }

    public void setBookEditons(List<NastedHalper> bookEditons) {
        this.bookEditons = bookEditons;
    }
}

