package com.beautylapsdemo.feed.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Aditri_Kinnu on 9/24/2015.
 */
public class ArticleData {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("summary")
    private String summary;

    @SerializedName("created")
    private String created;

    @SerializedName("is_new")
    private String is_new;

    @SerializedName("likes_count")
    private String likes_count;

    @SerializedName("article_comment_count")
    private String article_comment_count;

    ArrayList<ArticleImages> article_images;
    ArticleCoverImag cover_img;
    User user;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getArticle_comment_count() {
        return article_comment_count;
    }

    public void setArticle_comment_count(String article_comment_count) {
        this.article_comment_count = article_comment_count;
    }

    public ArrayList<ArticleImages> getArticle_images() {
        return article_images;
    }

    public void setArticle_images(ArrayList<ArticleImages> article_images) {
        this.article_images = article_images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArticleCoverImag getCover_img() {
        return cover_img;
    }

    public void setCover_img(ArticleCoverImag cover_img) {
        this.cover_img = cover_img;
    }
}
