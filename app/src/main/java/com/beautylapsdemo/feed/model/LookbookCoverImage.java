package com.beautylapsdemo.feed.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aditri_Kinnu on 9/24/2015.
 */
public class LookbookCoverImage {

    @SerializedName("id")
    private String id;

    @SerializedName("medium_img_w")
    private String medium_img_w;

    @SerializedName("medium_img_h")
    private String medium_img_h;

    @SerializedName("medium_img")
    private String medium_img;

   @SerializedName("description")
    private String description;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedium_img_w() {
        return medium_img_w;
    }

    public void setMedium_img_w(String medium_img_w) {
        this.medium_img_w = medium_img_w;
    }

    public String getMedium_img_h() {
        return medium_img_h;
    }

    public void setMedium_img_h(String medium_img_h) {
        this.medium_img_h = medium_img_h;
    }

    public String getMedium_img() {
        return medium_img;
    }

    public void setMedium_img(String medium_img) {
        this.medium_img = medium_img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
