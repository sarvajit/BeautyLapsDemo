package com.beautylapsdemo;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.beautylapsdemo.adapter.HomeFeedAdapter;
import com.beautylapsdemo.feed.model.ArticleCoverImag;
import com.beautylapsdemo.feed.model.ArticleData;
import com.beautylapsdemo.feed.model.ArticleImages;
import com.beautylapsdemo.feed.model.HomeFeedPojo;
import com.beautylapsdemo.feed.model.LookbookCards;
import com.beautylapsdemo.feed.model.LookbookCoverImage;
import com.beautylapsdemo.feed.model.LookbookData;
import com.beautylapsdemo.feed.model.MainFeed;
import com.beautylapsdemo.feed.model.StoreReviewData;
import com.beautylapsdemo.feed.model.User;
import com.beautylapsdemo.feed.model.feedClass;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Aditri_Kinnu on 9/20/2015.
 */
public class FeedFragment extends Fragment {

    AsyncHttpClient client;
    final static int DEFAULT_TIMEOUT = 40 * 1000;
    String text = "";
    String line = "";
    public int page = 1;
    private static String FEED_REST_URL = " ";
    ArrayList<HomeFeedPojo> feed_pojolist = null;
    HomeFeedAdapter feedAdapter;
    EndlessListView feed_listView;
    private boolean mHaveMoreDataToLoad;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.feed_activity, container, false);

        client = ClientHttp.getInstance(getActivity());
        FEED_REST_URL = "http://www.zakoopi.com/api/feedFeatured.json?page=";

        mHaveMoreDataToLoad = true;
        feed_listView = (EndlessListView) view.findViewById(R.id.endlessListView);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);
        feed_listView.setOnLoadMoreListener(loadMoreListener);

        home_feed(page);
        return view;
    }

    private void loadMoreData(){


    }

    private EndlessListView.OnLoadMoreListener loadMoreListener = new EndlessListView.OnLoadMoreListener() {

        @Override
        public boolean onLoadMore() {
            if (true == mHaveMoreDataToLoad) {

                loadMoreData();
            } else {

            }
            return mHaveMoreDataToLoad;
        }
    };

    public void home_feed(int page) {

        long time = System.currentTimeMillis();
        client.setBasicAuth("sarvajit.singh@zakoopi.com", "867970022256032");


        client.post(FEED_REST_URL + page + "&_=" + time,
                new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                        try {

                            BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(responseBody)));

                            while ((line = br.readLine()) != null) {
                                text = text + line;
                            }

                            Log.e("RES", text);
                            showData(text);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                        Log.e("Fail", " " + statusCode);
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }

    @SuppressWarnings("unchecked")
    public void showData(String data) {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new StringReader(data));
        reader.setLenient(true);
        MainFeed main_feed = gson.fromJson(reader, MainFeed.class);
        List<feedClass> feed = main_feed.getFeedFeatured();

            new FeedApp().execute(feed);

    }

    private class FeedApp extends AsyncTask<List<feedClass>, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(List<feedClass>... params) {

            feed_pojolist = new ArrayList<HomeFeedPojo>();
            feed_pojolist.clear();

            for (int i = 0; i < params[0].size(); i++) {
                feedClass feed_main = params[0].get(i);

                if (feed_main.getModel().equals("Lookbooks")) {

                    LookbookData look = feed_main.getLookbookData();

                    if (look != null) {

                        try {

                            User user = look.getUser();

                            /**
                             * User_Details
                             */
                            String user_id = user.getId();
                            String user_name = user.getFirst_name() + " " + user.getLast_name();
                            String user_image = user.getAndroid_api_img();

                            /**
                             * Lookbook_data
                             */
                            String lookboook_id = look.getId();
                            String title = look.getTitle();
                            String lookbook_like_count = look.getLookbooklike_count();
                            String lookbook_comment_count = look.getLookbookcomment_count();

                            /**
                             * Cover Image
                             */
                            /*LookbookCoverImage cover_img = look.getCover_img();
                            String look_desc = cover_img.getDescription();
                            String img_width = cover_img.getMedium_img_w();
                            String img_hight = cover_img.getMedium_img_h();
                            String home_img = cover_img.getMedium_img();*/

                            /**
                             * Cards
                             */
                            ArrayList<LookbookCards> cards = look.getCards();
                            int cards_size = cards.size();

                            LookbookCards img1 = cards.get(0);
                            String look_desc = img1.getDescription();
                            String img_width = img1.getMedium_img_w();
                            String img_hight = img1.getMedium_img_h();
                            String home_img = img1.getMedium_img();

                            HomeFeedPojo home_feed_pojo = new HomeFeedPojo("Lookbooks", user_name, user_image, user_id,
                                    home_img, lookbook_like_count, title, "na", String.valueOf(cards_size), lookboook_id, look_desc
                                    , "na", lookbook_comment_count, img_width, img_hight);

                            feed_pojolist.add(home_feed_pojo);


                        } catch (Exception e) {

                        }
                    }
                } else if (feed_main.getModel().equals("Articles")) {

                    ArticleData article = feed_main.getArticleData();

                    if (article != null) {

                        try {

                            /**
                             * User_Details
                             */
                            User user = article.getUser();
                            String user_id = user.getId();
                            String user_name = user.getFirst_name() + " " + user.getLast_name();
                            String user_img = user.getAndroid_api_img();

                            /**
                             * Article_Data
                             */
                            String article_id = article.getId();
                            String title = article.getTitle();
                            String article_like_count = article.getLikes_count();
                            String article_comment_count = article.getArticle_comment_count();
                            String article_is_new = article.getIs_new();

                            /**
                             * Cover_image
                             */
                            /*ArticleCoverImag cover_img = article.getCover_img();
                            String article_desc = cover_img.getTitle();
                            String img_width = cover_img.getMedium_img_w();
                            String img_hight = cover_img.getMedium_img_h();
                            String home_img = cover_img.getMedium_img();*/

                            /**
                             * Cards
                             */
                            ArrayList<ArticleImages> cards = article.getArticle_images();
                            int cards_size = cards.size();

                            ArticleImages img1 = cards.get(0);
                            String article_desc = img1.getTitle();
                            String img_width = img1.getMedium_img_w();
                            String img_hight = img1.getMedium_img_h();
                            String home_img = img1.getMedium_img();


                            HomeFeedPojo home_feed_pojo = new HomeFeedPojo("Articles", user_name, user_img, user_id, home_img, article_like_count
                                    , title, "na", String.valueOf(cards), article_id, article_desc, article_is_new, article_comment_count, img_width, img_hight);

                            feed_pojolist.add(home_feed_pojo);

                        } catch (Exception e) {

                        }
                    }
                } else {

                    StoreReviewData review = feed_main.getStoreReviewData();

                    if (review != null){

                        try {

                            /**
                             * User Details
                             */
                            User user = review.getUser();
                            String user_id = user.getId();
                            String user_name = user.getFirst_name()+" "+user.getLast_name();
                            String user_img = user.getAndroid_api_img();

                            /**
                             * Review Data
                             */
                            String review_id = review.getId();
                            String title  = "Review Title Here";
                            String review_desc = review.getReview();
                            String review_like_count = review.getLikes_count();

                            HomeFeedPojo home_feed_pojo = new HomeFeedPojo("StoreReviews", user_name, user_img, user_id,
                                    String.valueOf(R.drawable.subhi),review_like_count
                            ,title,"na","na",review_id,review_desc,"na","na","na","na");

                            feed_pojolist.add(home_feed_pojo);

                        }catch (Exception e){

                        }
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            feedAdapter  = new HomeFeedAdapter(feed_pojolist, getActivity());
            feed_listView.setAdapter(feedAdapter);
            progressBar.setVisibility(View.GONE);
        }
    }
}
