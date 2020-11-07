package com.weselleverything.realsell;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.weselleverything.realsell.util.SectionsPagerAdapter;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

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
            getVerifyPermissions();
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        getVerifyPermissions();
    }

    public void getVerifyPermissions() {
        Log.d(TAG, "verifyPermission: ask user for permission");
        String[] Permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Permissions[0]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Permissions[1]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Permissions[2]) == PackageManager.PERMISSION_GRANTED) {
            setupViewPager();
        }else {
            ActivityCompat.requestPermissions(SearchActivity.this,Permissions,1) ;
        }
    }

    private void verifyPermissions() {
    }
}