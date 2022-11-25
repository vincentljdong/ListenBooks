package com.jaydon.listenbooks.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.listenbooks.R;
import com.jaydon.listenbooks.bean.DataBean;
import com.jaydon.listenbooks.utils.StaticValue;
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
    private Banner banner;


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
//        jisuan_bt.setOnClickListener(this);
//        xiangqing_bt.setOnClickListener(this);
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

        banner = view.findViewById(R.id.banner);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.jisuan_bt:
//                if (chengbenjia.getText().length() != 0 && chigushu.getText().length() != 0 && bucangjia.getText().length() != 0 && bucangshu.getText().length() != 0) {
//                    Double bucangchenben = ((Double.parseDouble(chengbenjia.getText().toString()) * Double.parseDouble(chigushu.getText().toString())) + (Double.parseDouble(bucangjia.getText().toString())) * (Double.parseDouble(bucangshu.getText().toString()))) / (Double.parseDouble(chigushu.getText().toString()) + (Double.parseDouble(bucangshu.getText().toString())));
//                    zuizhongchengben.setText(bucangchenben.toString());
//                    Double zuizhongchigushu = (Double.parseDouble(chigushu.getText().toString()) + (Double.parseDouble(bucangshu.getText().toString())));
//                    zuizhongshuliang.setText(zuizhongchigushu.toString());
//                } else {
//                    Toast.makeText(v.getContext(), "不能为空哦！", Toast.LENGTH_LONG).show();
//                }
//                break;
//            case R.id.xiangqing_bt:
//                setTextViewJiaCang();
//                break;
//            default:
//                break;
//        }

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
