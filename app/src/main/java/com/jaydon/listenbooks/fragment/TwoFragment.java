package com.jaydon.listenbooks.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.jaydon.listenbooks.R;
import com.jaydon.listenbooks.adapter.CoordinatorLayoutPagerAdapter;

import java.util.ArrayList;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;
import cn.hugeterry.coordinatortablayout.listener.LoadHeaderImagesListener;


public class TwoFragment extends Fragment {

    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"Android", "iOS", "Web", "Other"};
    private ViewPager mViewPager;
    private String imgUrl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.twofragment_layout, container, false);
        initFragments(view);
        initViewPager(view);
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        mCoordinatorTabLayout = view.findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTranslucentStatusBar(getActivity())
                .setBackEnable(false)
                .setContentScrimColorArray(mColorArray)
                .setLoadHeaderImagesListener(new LoadHeaderImagesListener() {
                    @Override
                    public void loadHeaderImages(ImageView imageView, TabLayout.Tab tab) {
                        switch (tab.getPosition()) {
                            case 0:
                                loadImages(imageView, "http://www.6yueting.com/img/banner/4.jpg");
                                break;
                            case 1:
                                loadImages(imageView, "https://raw.githubusercontent.com/hugeterry/CoordinatorTabLayout/master/sample/src/main/res/mipmap-hdpi/bg_js.jpg");
                                break;
                            case 2:
                                loadImages(imageView, "https://raw.githubusercontent.com/hugeterry/CoordinatorTabLayout/master/sample/src/main/res/mipmap-hdpi/bg_ios.jpg");
                                break;
                            case 3:
                                loadImages(imageView, "https://raw.githubusercontent.com/hugeterry/CoordinatorTabLayout/master/sample/src/main/res/mipmap-hdpi/bg_other.jpg");
                                break;
                            default:
                                break;
                        }
                    }
                })
                .setupWithViewPager(mViewPager);
        return view;
    }

    private void loadImages(ImageView imageView, String url) {
        Glide.with(getActivity()).load(url.trim()).into(imageView);
    }

    private void initFragments(View view) {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(MainFragment.getInstance(title));
        }
    }

    private void initViewPager(View view) {
        mViewPager = view.findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new CoordinatorLayoutPagerAdapter(getParentFragmentManager(), mFragments, mTitles));
    }
}