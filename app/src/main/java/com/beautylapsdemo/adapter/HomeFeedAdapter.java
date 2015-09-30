package com.beautylapsdemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.beautylapsdemo.R;
import com.beautylapsdemo.feed.model.HomeFeedPojo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import ch.halcyon.squareprogressbar.SquareProgressBar;

/**
 * Created by Aditri_Kinnu on 9/27/2015.
 */
public class HomeFeedAdapter extends BaseAdapter {

    public List<HomeFeedPojo> adapter_list;
    Context ctx;
    int displayWidth;
    int mode_position;


    public HomeFeedAdapter(List<HomeFeedPojo> adapter_list, Context ctx) {
        this.adapter_list = adapter_list;
        this.ctx = ctx;

        Point size = new Point();
        ((Activity) ctx).getWindowManager().getDefaultDisplay()
                .getSize(size);
        displayWidth = size.x;


    }

    @Override
    public int getCount() {
        if (null == adapter_list) {
            return 0;
        }
        return adapter_list.size();
    }

    @Override
    public Object getItem(int position) {
        return adapter_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = this.getItemViewType(position);

        try {

            switch (type) {

                case 0:
                    View look_result = convertView;
                    final LookbookHolder look_holder;

                    if (look_result == null) {

                        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        look_result = inflater.inflate(R.layout.feed_item,parent,false);
                        look_holder = new LookbookHolder();

                        look_holder.txt_userName = (TextView) look_result.findViewById(R.id.txt_name);
                        look_holder.txt_title = (TextView) look_result.findViewById(R.id.txt_title);
                        look_holder.txt_comment_count = (TextView) look_result.findViewById(R.id.txt_com_count);
                        look_holder.txt_like_count = (TextView) look_result.findViewById(R.id.txt_like_count);
                        look_holder.txt_pic_count = (TextView) look_result.findViewById(R.id.txt_pic_count);
                        look_holder.img_user = (ImageView) look_result.findViewById(R.id.pro_img);
                        look_holder.img_home = (ImageView) look_result.findViewById(R.id.img_cover);
                        look_holder.progressBar_feed = (ProgressBar) look_result.findViewById(R.id.progressBar_feed);

                        look_result.setTag(look_holder);
                    } else {
                        look_holder = (LookbookHolder) look_result.getTag();
                    }

                    final HomeFeedPojo pojo = adapter_list.get(position);

                        try {
                            final int width1 = displayWidth;
                            final int height1 = Integer.parseInt(pojo.getImg_height());

                            final int set_height = (int) ((width1 * 1.0) / Integer.parseInt(pojo.getImg_height())) * height1;

                            look_holder.img_home.getLayoutParams().height = set_height;
                            look_holder.img_home.getLayoutParams().width = width1;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    look_holder.progressBar_feed.setVisibility(View.VISIBLE);
                   // Picasso.with(ctx).load(pojo.getHome_image()).placeholder(R.color.half_black).into(look_holder.img_home);
                    Picasso.with(ctx).load(pojo.getHome_image()).placeholder(R.color.half_black).error(R.color.half_black).fit()
                            .into(look_holder.img_home, new Callback() {

                                @Override
                                public void onSuccess() {
                                    look_holder.img_home.setVisibility(View.VISIBLE);
                                    look_holder.progressBar_feed.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError() {
                                    look_holder.img_home.setVisibility(View.GONE);
                                    look_holder.progressBar_feed.setVisibility(View.VISIBLE);
                                }
                            });
                    Picasso.with(ctx).load(pojo.getUser_image()).placeholder(R.color.half_black).into(look_holder.img_user);
                    look_holder.txt_userName.setText(pojo.getUser_name());
                    look_holder.txt_title.setText(pojo.getTitle());
                    look_holder.txt_like_count.setText(pojo.getLikes_count());
                    look_holder.txt_comment_count.setText(pojo.getComment_count());
                    look_holder.txt_pic_count.setText(pojo.getImage_count());

                    return look_result;

                case 1:
                    View article_result = convertView;
                    final ArticleHolder article_holder;

                    if (article_result == null) {

                        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        article_result = inflater.inflate(R.layout.feed_item,parent,false);
                        article_holder = new ArticleHolder();

                        article_holder.txt_userName = (TextView) article_result.findViewById(R.id.txt_name);
                        article_holder.txt_title = (TextView) article_result.findViewById(R.id.txt_title);
                        article_holder.txt_comment_count = (TextView) article_result.findViewById(R.id.txt_com_count);
                        article_holder.txt_like_count = (TextView) article_result.findViewById(R.id.txt_like_count);
                        article_holder.txt_pic_count = (TextView) article_result.findViewById(R.id.txt_pic_count);
                        article_holder.img_user = (ImageView) article_result.findViewById(R.id.pro_img);
                        article_holder.img_home = (ImageView) article_result.findViewById(R.id.img_cover);
                        article_holder.progressBar_feed = (ProgressBar) article_result.findViewById(R.id.progressBar_feed);

                        article_result.setTag(article_holder);
                    } else {
                        article_holder = (ArticleHolder) article_result.getTag();
                    }

                    final HomeFeedPojo article_pojo = adapter_list.get(position);

                    try {
                        final int width1 = displayWidth;
                        final int height1 = Integer.parseInt(article_pojo.getImg_height());

                        final int set_height = (int) ((width1 * 1.0) / Integer.parseInt(article_pojo.getImg_height())) * height1;

                        article_holder.img_home.getLayoutParams().height = set_height;
                        article_holder.img_home.getLayoutParams().width = width1;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    article_holder.progressBar_feed.setVisibility(View.VISIBLE);
                   // Picasso.with(ctx).load(article_pojo.getHome_image()).placeholder(R.color.half_black).into(article_holder.img_home);
                    Picasso.with(ctx).load(article_pojo.getHome_image()).placeholder(R.color.half_black).error(R.color.half_black).fit()
                            .into(article_holder.img_home, new Callback() {

                                @Override
                                public void onSuccess() {
                                    article_holder.img_home.setVisibility(View.VISIBLE);
                                    article_holder.progressBar_feed.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError() {
                                    article_holder.img_home.setVisibility(View.GONE);
                                    article_holder.progressBar_feed.setVisibility(View.VISIBLE);
                                }
                            });

                    Picasso.with(ctx).load(article_pojo.getUser_image()).placeholder(R.color.half_black).into(article_holder.img_user);
                    article_holder.txt_userName.setText(article_pojo.getUser_name());
                    article_holder.txt_title.setText(article_pojo.getTitle());
                    article_holder.txt_like_count.setText(article_pojo.getLikes_count());
                    article_holder.txt_comment_count.setText(article_pojo.getComment_count());
                    article_holder.txt_pic_count.setText(article_pojo.getImage_count());

                    return article_result;

                case 2:
                    View review_result = convertView;
                    final ReviewHolder review_holder;

                    if (review_result == null) {

                        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        review_result = inflater.inflate(R.layout.feed_item,parent,false);
                        review_holder = new ReviewHolder();

                        review_holder.txt_userName = (TextView) review_result.findViewById(R.id.txt_name);
                        review_holder.txt_title = (TextView) review_result.findViewById(R.id.txt_title);
                        review_holder.txt_comment_count = (TextView) review_result.findViewById(R.id.txt_com_count);
                        review_holder.txt_like_count = (TextView) review_result.findViewById(R.id.txt_like_count);
                        review_holder.txt_pic_count = (TextView) review_result.findViewById(R.id.txt_pic_count);
                        review_holder.img_user = (ImageView) review_result.findViewById(R.id.pro_img);
                        review_holder.img_home = (ImageView) review_result.findViewById(R.id.img_cover);
                        review_holder.progressBar_feed = (ProgressBar) review_result.findViewById(R.id.progressBar_feed);

                        review_result.setTag(review_holder);
                    } else {
                        review_holder = (ReviewHolder) review_result.getTag();
                    }

                    final HomeFeedPojo review_pojo = adapter_list.get(position);

                    try {
                        final int width1 = displayWidth;
                        final int height1 = Integer.parseInt(review_pojo.getImg_height());

                        final int set_height = (int) ((width1 * 1.0) / Integer.parseInt(review_pojo.getImg_height())) * height1;

                        review_holder.img_home.getLayoutParams().height = set_height;
                        review_holder.img_home.getLayoutParams().width = width1;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    review_holder.progressBar_feed.setVisibility(View.VISIBLE);
                    //Picasso.with(ctx).load(review_pojo.getHome_image()).placeholder(R.color.half_black).into(review_holder.img_home);
                    Picasso.with(ctx).load(review_pojo.getHome_image()).placeholder(R.color.half_black).error(R.color.half_black).fit()
                            .into(review_holder.img_home, new Callback() {

                                @Override
                                public void onSuccess() {
                                    review_holder.img_home.setVisibility(View.VISIBLE);
                                    review_holder.progressBar_feed.setVisibility(View.GONE);
                                }

                                @Override
                                public void onError() {
                                    review_holder.img_home.setVisibility(View.GONE);
                                    review_holder.progressBar_feed.setVisibility(View.VISIBLE);
                                }
                            });

                    Picasso.with(ctx).load(review_pojo.getUser_image()).placeholder(R.color.half_black).into(review_holder.img_user);
                    review_holder.txt_userName.setText(review_pojo.getUser_name());
                    review_holder.txt_title.setText(review_pojo.getTitle());
                    review_holder.txt_like_count.setText(review_pojo.getLikes_count());
                    review_holder.txt_comment_count.setText(review_pojo.getComment_count());
                    review_holder.txt_pic_count.setText(review_pojo.getImage_count());

                    return review_result;

                default:
            }

        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getViewTypeCount() {
        if (getCount() != 0)
        return getCount();
        return 1;
    }

    public static class LookbookHolder {

        ImageView img_user,img_home;
        TextView txt_userName, txt_title, txt_like_count, txt_comment_count,txt_pic_count;
        ProgressBar progressBar_feed;
    }

    public static class ArticleHolder {

        ImageView img_user,img_home;
        TextView txt_userName, txt_title, txt_like_count, txt_comment_count,txt_pic_count;
        ProgressBar progressBar_feed;
    }

    public static class ReviewHolder {

        ImageView img_user,img_home;
        TextView txt_userName, txt_title, txt_like_count, txt_comment_count,txt_pic_count;
        ProgressBar progressBar_feed;
    }

    @Override
    public int getItemViewType(int position) {

        final  HomeFeedPojo feedPojo_view = adapter_list.get(position);

        if (feedPojo_view.getMode().equals("Lookbooks")) {
            mode_position = 0;
        } else if (feedPojo_view.getMode().equals("Articles")) {
            mode_position = 1;
        } else if (feedPojo_view.getMode().equals("StoreReviews")) {
            mode_position = 2;
        }
        return mode_position;
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
