package com.beautylapsdemo.feed.model;

/**
 * Created by Aditri_Kinnu on 9/24/2015.
 */
public class HomeFeedPojo {

    String mode;
    String user_name;
    String user_image;
    String user_id;
    String home_image;
    String likes_count;
    String title;
    String review;
    String image_count;
    String idd;
    String description;
    String is_new;
    String comment_count;
    String img_width;
    String img_height;

    public HomeFeedPojo(String mode, String user_name, String user_image, String user_id, String home_image, String likes_count,
                        String title, String review, String image_count, String idd,
                        String description, String is_new, String comment_count,
                        String img_width, String img_height) {
        this.mode = mode;
        this.user_name = user_name;
        this.user_image = user_image;
        this.user_id = user_id;
        this.home_image = home_image;
        this.likes_count = likes_count;
        this.title = title;
        this.review = review;
        this.image_count = image_count;
        this.idd = idd;
        this.description = description;
        this.is_new = is_new;
        this.comment_count = comment_count;
        this.img_width = img_width;
        this.img_height = img_height;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public String getHome_image() {
        return home_image;
    }

    public void setHome_image(String home_image) {
        this.home_image = home_image;
    }

    public String getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getImage_count() {
        return image_count;
    }

    public void setImage_count(String image_count) {
        this.image_count = image_count;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getImg_width() {
        return img_width;
    }

    public void setImg_width(String img_width) {
        this.img_width = img_width;
    }

    public String getImg_height() {
        return img_height;
    }

    public void setImg_height(String img_height) {
        this.img_height = img_height;
    }


}
