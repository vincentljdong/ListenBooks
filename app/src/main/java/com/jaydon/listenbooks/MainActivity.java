package com.jaydon.listenbooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.listenbooks.R;
import com.jaydon.listenbooks.adapter.MyViewPageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    BottomNavigationView navigation;
    ViewPager viewPager;
    TextView mtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();


    }

    private void initListener() {
        navigation.setOnNavigationItemSelectedListener(this);
        //指定默认加载首页
        navigation.setSelectedItemId(R.id.action_search);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(new MyViewPageAdapter(getSupportFragmentManager()));
    }

    private void initData() {
    }

    public void initView() {
        navigation = this.findViewById(R.id.navigation);
        viewPager = this.findViewById(R.id.viewPage);
        mtitle = this.findViewById(R.id.title);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_search:
                viewPager.setCurrentItem(0, false);
//                mtitle.setText("第一页");
                return true;
            case R.id.action_settings:
                viewPager.setCurrentItem(1, false);
//                mtitle.setText("第二页");
                return true;
            case R.id.action_navigation:
                viewPager.setCurrentItem(2, false);
//                mtitle.setText("第三页");
                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                navigation.setSelectedItemId(R.id.action_search);
                break;
            case 1:
                navigation.setSelectedItemId(R.id.action_settings);
                break;
            case 2:
                navigation.setSelectedItemId(R.id.action_navigation);
                break;
            default:
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
