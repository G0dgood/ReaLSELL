package com.weselleverything.realsell;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.weselleverything.realsell.util.SectionsPagerAdapter;

public class SearchActivity extends AppCompatActivity {
    public static final String TAG = "SearchActivity";

    //wadget
    public TabLayout mTablayout;
    public ViewPager mViewPager;

    //vars
    public SectionsPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search);
            mTablayout = (TabLayout) findViewById(R.id.tabs);
            mViewPager = (ViewPager) findViewById(R.id.viewpager_container);
            setupViewPager();
        }


    private void setupViewPager(){
        mPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new SearchFragment());
        mPagerAdapter.addFragment(new WatchListFragment());
        mPagerAdapter.addFragment(new PostFragment());
        mPagerAdapter.addFragment(new AccountFragment());

        mViewPager.setAdapter(mPagerAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        mTablayout.getTabAt(0).setText(getString(R.string.fragment_search));
        mTablayout.getTabAt(1).setText(getString(R.string.fragment_watch_list));
        mTablayout.getTabAt(2).setText(getString(R.string.fragment_post));
        mTablayout.getTabAt(3).setText(getString(R.string.fragment_account));
    }

}