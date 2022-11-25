package com.jaydon.listenbooks.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jaydon.listenbooks.fragment.OneFragment;
import com.jaydon.listenbooks.fragment.ThreeFragment;
import com.jaydon.listenbooks.fragment.TwoFragment;

public class MyViewPageAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragments = new Fragment[]{new OneFragment(), new TwoFragment(), new ThreeFragment()};

    public MyViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
