package com.beautylapsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by Aditri_Kinnu on 9/20/2015.
 */
public class MainActivity extends AppCompatActivity implements MaterialTabListener, FragmentDrawer.FragmentDrawerListener{

    MaterialTabHost tabHost;
    ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    int fragment_pos;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        pagerSet();
    }

    public void pagerSet() {

        tabHost = (MaterialTabHost) this.findViewById(R.id.materialTabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);
        mToolbar = (Toolbar) this.findViewById(R.id.toolbar);

        mToolbar.setTitle("BeautyLaps");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(MainActivity.this);
        pager.setOffscreenPageLimit(2);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
                Toast.makeText(getApplicationContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
                fragment_pos = position;
            }
        });

        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(tabHost.newTab().setText(pagerAdapter.getPageTitle(i)).setTabListener(MainActivity.this));

        }
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int num) {
            if (num == 0) {
                HomeFeedMainFrag feed_frag = new HomeFeedMainFrag();
                return feed_frag;
            } else if (num == 1) {
                CollectionFragment collection_frag = new CollectionFragment();
                return collection_frag;
            } else if (num == 2) {
                MyProfileFragment me_frag = new MyProfileFragment();
                return me_frag;
            } else {
                MyProfileFragment me_frag = new MyProfileFragment();
                return me_frag;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Feed";
                case 1:
                    return "Collection's";

                case 2:
                    return "Me";

                default:
                    return null;
            }
        }
    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {

    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }

    public void onDrawerItemSelected(View view, int position) {

    }
}
