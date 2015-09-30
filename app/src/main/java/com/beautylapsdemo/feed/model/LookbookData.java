package com.beautylapsdemo.feed.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Aditri_Kinnu on 9/24/2015.
 */
public class LookbookData {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("lookbookcomment_count")
    private String lookbookcomment_count;

    @SerializedName("lookbooklike_count")
    private String lookbooklike_count;

    ArrayList<LookbookCards> cards;
    User user;
    LookbookCoverImage cover_img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLookbookcomment_count() {
        return lookbookcomment_count;
    }

    public void setLookbookcomment_count(String lookbookcomment_count) {
        this.lookbookcomment_count = lookbookcomment_count;
    }

    public String getLookbooklike_count() {
        return lookbooklike_count;
    }

    public void setLookbooklike_count(String lookbooklike_count) {
        this.lookbooklike_count = lookbooklike_count;
    }

    public ArrayList<LookbookCards> getCards() {
        return cards;
    }

    public void setCards(ArrayList<LookbookCards> cards) {
        this.cards = cards;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LookbookCoverImage getCover_img() {
        return cover_img;
    }

    public void setCover_img(LookbookCoverImage cover_img) {
        this.cover_img = cover_img;
    }
}
