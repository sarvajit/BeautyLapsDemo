package com.beautylapsdemo.feed.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aditri_Kinnu on 9/24/2015.
 */
public class feedClass  {

    @SerializedName("id")
    private  String id;

    @SerializedName("key")
    private  String key;

    @SerializedName("model")
    private  String model;

    @SerializedName("order")
    private String order;

    ArticleData articleData;
    LookbookData lookbookData;
    StoreReviewData storeReviewData;

    /**
     * Get-Set Method
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


    public ArticleData getArticleData() {
        return articleData;
    }

    public void setArticleData(ArticleData articleData) {
        this.articleData = articleData;
    }

    public LookbookData getLookbookData() {
        return lookbookData;
    }

    public void setLookbookData(LookbookData lookbookData) {
        this.lookbookData = lookbookData;
    }

    public StoreReviewData getStoreReviewData() {
        return storeReviewData;
    }

    public void setStoreReviewData(StoreReviewData storeReviewData) {
        this.storeReviewData = storeReviewData;
    }
}
