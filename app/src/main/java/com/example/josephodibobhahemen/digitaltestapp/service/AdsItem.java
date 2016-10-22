package com.example.josephodibobhahemen.digitaltestapp.service;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by josephodibobhahemen on 10/22/16.
 */

@Root(name = "ad", strict = false)
public class AdsItem {
    @Element(name = "appId")
    private String applicationId;

    @Element(name = "averageRatingImageURL")
    private String averageRatingImageURL;

    @Element(name = "bidRate")
    private String bidRate;

    @Element(name = "campaignDisplayOrder")
    private int campaignDisplayOrder;

    @Element(name = "campaignId")
    private int campaignId;

    @Element(name="campaignTypeId")
    private String campaignTypeId;

    @Element(name = "categoryName")
    private String categoryName;

    @Element(name = "clickProxyURL")
    private String clickProxyURL;

    @Element(name = "creativeId")
    private long creativeId;

    @Element(name = "homeScreen")
    private boolean homeScreen;

    @Element(name ="impressionTrackingURL")
    private String impressionTrackingURL;

    @Element(name = "isRandomPick")
    private boolean isRandomPick;

    @Element(name = "minOSVersion", required = false)
    private String minOSVersion;

    @Element(name = "numberOfRatings")
    private String numberOfRatings;

    @Element(name = "productDescription")
    private String productDescription;

    @Element(name = "productId")
    private String productId;

    @Element(name = "productName")
    private String productName;

    @Element(name = "productThumbnail")
    private String productThumbnail;

    @Element(name ="rating")
    private float rating;

    public AdsItem() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getAverageRatingImageURL() {
        return averageRatingImageURL;
    }

    public String getBidRate() {
        return bidRate;
    }

    public int getCampaignDisplayOrder() {
        return campaignDisplayOrder;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public String getCampaignTypeId() {
        return campaignTypeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getClickProxyURL() {
        return clickProxyURL;
    }

    public long getCreativeId() {
        return creativeId;
    }

    public boolean isHomeScreen() {
        return homeScreen;
    }

    public String getImpressionTrackingURL() {
        return impressionTrackingURL;
    }

    public boolean isRandomPick() {
        return isRandomPick;
    }

    public String getMinOSVersion() {
        return minOSVersion;
    }

    public String getNumberOfRatings() {
        return numberOfRatings;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public float getRating() {
        return rating;
    }
}
