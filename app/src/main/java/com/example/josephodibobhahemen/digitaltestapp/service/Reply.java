package com.example.josephodibobhahemen.digitaltestapp.service;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by josephodibobhahemen on 10/21/16.
 */
@Root(name ="ads", strict = false)
public class Reply {

    @ElementList(entry = "ad", inline = true, type = AdsItem.class)
    private List<AdsItem> adsItemList;

    @Element(name = "responseTime", required = false)
    private String responseTime;

    @Element(name = "serverId", required = false)
    private String serverId;

    @Element(name = "totalCampaignsRequested", required = false)
    private String totalCampaignsRequested;

    @Element(name = "version", required = false)
    private String version;

    public Reply() {
    }

    public List<AdsItem> getAdsItemList() {
        return adsItemList;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public String getServerId() {
        return serverId;
    }

    public String getTotalCampaignsRequested() {
        return totalCampaignsRequested;
    }

    public String getVersion() {
        return version;
    }
}
