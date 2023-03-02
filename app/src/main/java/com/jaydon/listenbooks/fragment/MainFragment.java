package com.jaydon.listenbooks.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaydon.listenbooks.R;
import com.jaydon.listenbooks.adapter.RecyclerAdapter;
import com.jaydon.listenbooks.bean.DataBean;
import com.jaydon.listenbooks.utils.Tools;
import com.skydoves.transformationlayout.TransformationLayout;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab;
    private TransformationLayout transformationLayout;
    private LinearLayout mMenu_card;

    private List<String> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;

    public static Fragment getInstance(String title) {
        MainFragment fra = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        initView(v);
        initData(v);
        initListenner(v);

        return v;
    }

    private void initListenner(View v) {
//        mFab.setOnClickListener(this);
//        mMenu_card.setOnClickListener(this);
    }

    private void initView(View v) {
        mRecyclerView = v.findViewById(R.id.recyclerview);
//        mFab = v.findViewById(R.id.fab);
//        transformationLayout = v.findViewById(R.id.transformationLayout);
//        mMenu_card = v.findViewById(R.id.menu_card);
    }

    private void initData(View v) {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerAdapter(mRecyclerView.getContext(), DataBean.getTestData()));

    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.fab:
//                //设置开始动画
//                transformationLayout.startTransform();
//                break;
//            case R.id.menu_card:
//                //设置结束动画
//                transformationLayout.finishTransform();
//                Tools.setToastShow(view.getContext(), "Play");
//                break;
//            default:
//                break;
//        }

    }
}