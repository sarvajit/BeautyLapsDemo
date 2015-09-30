package com.beautylapsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Aditri_Kinnu on 9/23/2015.
 */
public class HomeFeedMainFrag extends Fragment{

    LinearLayout lin_feed;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_feed_main_frag, null);

        lin_feed = (LinearLayout) view.findViewById(R.id.lin_feed_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fm.beginTransaction();
        Fragment fragTwo = new FeedFragment();
        Bundle arguments = new Bundle();
        arguments.putBoolean("shouldYouCreateAChildFragment", false);
        fragTwo.setArguments(arguments);
        ft.add(R.id.lin_feed_main, fragTwo);

        ft.commit();

        return view;
    }
}
