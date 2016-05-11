package com.kevin.model;

import org.springframework.stereotype.Component;

/**
 * Created by spirit on 2015/11/13.
 */
@Component
public class LivePicInfo {
    private String picStoreUrl;
    private String picInfoUrl;

    public String getPicStoreUrl() {
        return picStoreUrl;
    }

    public void setPicStoreUrl(String picStoreUrl) {
        this.picStoreUrl = picStoreUrl;
    }

    public String getPicInfoUrl() {
        return picInfoUrl;
    }

    public void setPicInfoUrl(String picInfoUrl) {
        this.picInfoUrl = picInfoUrl;
    }
}
