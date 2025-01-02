package com.adobe.aem.guides.demo.core.helper;

import java.util.Date;

import org.apache.sling.api.resource.Resource;

public class NastedHalper {
    private int bookEditon;
    private Date editonDate;
    public NastedHalper(Resource resource){
        if(resource.getValueMap().get("bookediton", Integer.class)!=null) {
            this.bookEditon = resource.getValueMap().get("bookediton", Integer.class);
        }
        if(resource.getValueMap().get("editondate",Date.class)!=null){
            this.editonDate=resource.getValueMap().get("editondate",Date.class);
        }

    }
    public int getBookEditon() {
        return bookEditon;
    }

    public Date getEditonDate() {
        return editonDate;
    }
}

