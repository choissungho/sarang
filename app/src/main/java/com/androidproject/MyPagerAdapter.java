package com.androidproject;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mData;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);

        mData = new ArrayList<>();

        mData.add(new HomeFragment());
        mData.add(new ReviewFragment());
        mData.add(new MyPageFragment());
        mData.add(new BlankFragment());
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        ArrayList<String> mTitleData = new ArrayList<>();
        mTitleData.add("Home");
        mTitleData.add("Test");
        mTitleData.add("Memo");
        mTitleData.add("MY");
        return mTitleData.get(position);
    }
}
