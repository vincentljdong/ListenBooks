package com.jaydon.listenbooks.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CoordinatorLayoutPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles;

    public CoordinatorLayoutPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments, String[] mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }


    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

}
