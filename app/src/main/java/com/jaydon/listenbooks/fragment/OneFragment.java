package com.jaydon.listenbooks.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.jaydon.listenbooks.R;
import com.jaydon.listenbooks.activity.GirlActivity;
import com.jaydon.listenbooks.bean.DataBean;
import com.jaydon.listenbooks.utils.StaticValue;
import com.jaydon.listenbooks.utils.Tools;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.RoundLinesIndicator;
import com.youth.banner.util.BannerUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class OneFragment extends Fragment implements View.OnClickListener {
    private LinearLayout searchLl;
    private ImageView homeMore;
    private EditText homeEt;
    private ImageView homeShare;
    private Banner banner;
    private RoundLinesIndicator indicator;
    private LinearLayout llGirlOne;
    private LinearLayout llGirlTwo;
    private LinearLayout llGirlThree;
    private LinearLayout llGirlFore;
    private Button btGirlMore;
    private Button btGirlChange;
    private LinearLayout llBoyOne;
    private LinearLayout llBoyTwo;
    private LinearLayout llBoyThree;
    private LinearLayout llBoyOneFore;
    private Button btBoyMore;
    private Button btBoyChange;
    private LinearLayout llTaoluOne;
    private LinearLayout llTaoluTwo;
    private LinearLayout llTaoluThree;
    private LinearLayout llTaoluFore;
    private Button btTaoluMore;
    private Button btTaoluChange;
    private LinearLayout llFaceOne;
    private LinearLayout llFaceTwo;
    private LinearLayout llFaceThree;
    private LinearLayout llFaceFore;
    private Button btFaceMore;
    private Button btFaceChange;
    private LinearLayout llAOne;
    private LinearLayout llATwo;
    private LinearLayout llAThree;
    private LinearLayout llAFore;
    private Button btAMore;
    private Button btAChange;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onefragment_layout, container, false);
        initView(view);
        initData(view);
        initListener(view);
        return view;
    }

    private void initListener(View view) {
        homeEt.setOnClickListener(this);
        homeShare.setOnClickListener(this);
        btGirlMore.setOnClickListener(this);
        btGirlChange.setOnClickListener(this);
        btBoyMore.setOnClickListener(this);
        btBoyChange.setOnClickListener(this);
        btTaoluMore.setOnClickListener(this);
        btTaoluChange.setOnClickListener(this);
        btFaceMore.setOnClickListener(this);
        btFaceChange.setOnClickListener(this);
        btAMore.setOnClickListener(this);
        btAChange.setOnClickListener(this);
        llGirlOne.setOnClickListener(this);
    }

    private void initData(View view) {
        banner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                Glide.with(holder.itemView)
                        .load(data.imageUrl)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                        .into(holder.imageView);
            }
        });
        banner.setIndicator(new RoundLinesIndicator(view.getContext()));
        banner.setIndicatorSelectedWidth((int) BannerUtils.dp2px(15));

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Document doc = Jsoup.connect(StaticValue.HOME_URL_TINGSHUBA)
                            .ignoreContentType(true)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                            .referrer("https://www.ting8.cc/play/17962-0-2.html")
                            .timeout(3000).followRedirects(true).get();

                    Log.d(StaticValue.TAGS, "听书吧: " + doc.body());
                    //获取所有链接
                    Elements hrefs = doc.select("a[href]");
                    for (Element href : hrefs
                    ) {
                        Log.d(StaticValue.TAGS, href.text() + ":" + href.attr("href"));
                    }

                    //获取所有图片
                    Elements imgs = doc.select("img[src]");
                    for (Element img :
                            imgs) {
                        Log.d(StaticValue.TAGS, "听书吧: " + img.attr("src"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void initView(View view) {
        searchLl = (LinearLayout) view.findViewById(R.id.search_ll);
        homeMore = (ImageView) view.findViewById(R.id.home_more);
        homeEt = (EditText) view.findViewById(R.id.home_et);
        homeShare = (ImageView) view.findViewById(R.id.home_share);
        indicator = (RoundLinesIndicator) view.findViewById(R.id.indicator);
        llGirlOne = (LinearLayout) view.findViewById(R.id.ll_girl_one);
        llGirlTwo = (LinearLayout) view.findViewById(R.id.ll_girl_two);
        llGirlThree = (LinearLayout) view.findViewById(R.id.ll_girl_three);
        llGirlFore = (LinearLayout) view.findViewById(R.id.ll_girl_fore);
        btGirlMore = (Button) view.findViewById(R.id.bt_girl_more);
        btGirlChange = (Button) view.findViewById(R.id.bt_girl_change);
        llBoyOne = (LinearLayout) view.findViewById(R.id.ll_boy_one);
        llBoyTwo = (LinearLayout) view.findViewById(R.id.ll_boy_two);
        llBoyThree = (LinearLayout) view.findViewById(R.id.ll_boy_three);
        llBoyOneFore = (LinearLayout) view.findViewById(R.id.ll_boy_one_fore);
        btBoyMore = (Button) view.findViewById(R.id.bt_boy_more);
        btBoyChange = (Button) view.findViewById(R.id.bt_boy_change);
        llTaoluOne = (LinearLayout) view.findViewById(R.id.ll_taolu_one);
        llTaoluTwo = (LinearLayout) view.findViewById(R.id.ll_taolu_two);
        llTaoluThree = (LinearLayout) view.findViewById(R.id.ll_taolu_three);
        llTaoluFore = (LinearLayout) view.findViewById(R.id.ll_taolu_fore);
        btTaoluMore = (Button) view.findViewById(R.id.bt_taolu_more);
        btTaoluChange = (Button) view.findViewById(R.id.bt_taolu_change);
        llFaceOne = (LinearLayout) view.findViewById(R.id.ll_face_one);
        llFaceTwo = (LinearLayout) view.findViewById(R.id.ll_face_two);
        llFaceThree = (LinearLayout) view.findViewById(R.id.ll_face_three);
        llFaceFore = (LinearLayout) view.findViewById(R.id.ll_face_fore);
        btFaceMore = (Button) view.findViewById(R.id.bt_face_more);
        btFaceChange = (Button) view.findViewById(R.id.bt_face_change);
        llAOne = (LinearLayout) view.findViewById(R.id.ll_A_one);
        llATwo = (LinearLayout) view.findViewById(R.id.ll_A_two);
        llAThree = (LinearLayout) view.findViewById(R.id.ll_A_three);
        llAFore = (LinearLayout) view.findViewById(R.id.ll_A_fore);
        btAMore = (Button) view.findViewById(R.id.bt_A_more);
        btAChange = (Button) view.findViewById(R.id.bt_A_change);
        banner = view.findViewById(R.id.banner);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_et:

                break;
            case R.id.home_share:
                Tools.setToastShow(v.getContext(), "尽情期待！");
                break;
            case R.id.bt_girl_more:
                intent = new Intent(getActivity(), GirlActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_girl_change:
                Tools.setToastShow(v.getContext(), "尽情期待！");
                break;
            case R.id.bt_boy_change:
                Tools.setToastShow(v.getContext(), "尽情期待！");
                break;
            case R.id.bt_boy_more:

                break;
            case R.id.bt_face_change:
                Tools.setToastShow(v.getContext(), "尽情期待！");
                break;
            case R.id.bt_face_more:

                break;
            case R.id.bt_taolu_change:
                Tools.setToastShow(v.getContext(), "尽情期待！");
                break;
            case R.id.bt_taolu_more:

                break;
            case R.id.bt_A_change:
                Tools.setToastShow(v.getContext(), "尽情期待！");
                break;
            case R.id.bt_A_more:

                break;
            case R.id.ll_girl_one:

                break;
            default:
                break;
        }

    }

    //股票加仓成本价计算
//    private void setTextViewJiaCang() {
//        Double bucangchenben = ((Double.parseDouble(chengbenjia.getText().toString()) * Double.parseDouble(chigushu.getText().toString())) + (Double.parseDouble(bucangjia.getText().toString())) * (Double.parseDouble(bucangshu.getText().toString()))) / (Double.parseDouble(chigushu.getText().toString()) + (Double.parseDouble(bucangshu.getText().toString())));
////        String bucangchenben = "(" + chengbenjia.getText().toString() + "*" + chigushu.getText().toString() + "+" + bucangjia.getText().toString() + "*" + bucangshu.getText().toString() + ")" + "/" + "(" +
////                chigushu.getText().toString() + "+" + bucangshu.getText().toString() + ")";
////        xiangqing_tv.setText(bucangchenben);
//        Log.e("加仓后成本-----", "setTextViewJiaCang: " + bucangchenben);
//    }
}
