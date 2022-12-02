package com.jaydon.listenbooks.bean;


import android.util.Log;

import com.jaydon.listenbooks.utils.StaticValue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataBean {
    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public DataBean(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public DataBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public static List<DataBean> getTestData() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("http://img.6yueting.com:20001/20200903/2f65ddb3.jpg", "都市言情", 1));
        list.add(new DataBean("http://img.6yueting.com:20001/20200903/2f65ddb3.jpg", "玄幻科幻", 3));
        list.add(new DataBean("http://img.6yueting.com:20001/20200903/2f65ddb3.jpg", "武侠小说", 3));
        list.add(new DataBean("http://img.6yueting.com:20001/20200903/2f65ddb3.jpg", "恐怖惊悚", 1));
        list.add(new DataBean("http://img.6yueting.com:20001/20200903/2f65ddb3.jpg", "绝美风格", 1));
        list.add(new DataBean("http://img.6yueting.com:20001/20200903/2f65ddb3.jpg", "微微一笑", 3));
        return list;
    }

//    public static List<DataBean> getTestData2() {
//        List<DataBean> list = new ArrayList<>();
//        list.add(new DataBean(R.drawable.image7, "听风.赏雨", 3));
//        list.add(new DataBean(R.drawable.image8, "迪丽热巴.迪力木拉提", 1));
//        list.add(new DataBean(R.drawable.image9, "爱美.人间有之", 3));
//        list.add(new DataBean(R.drawable.image10, "洋洋洋.气质篇", 1));
//        list.add(new DataBean(R.drawable.image11, "生活的态度", 3));
//        return list;
//    }

    /**
     * 仿淘宝商品详情第一个是视频
     *
     * @return
     */
//    public static List<DataBean> getTestDataVideo() {
//        List<DataBean> list = new ArrayList<>();
//        list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/09/mp4/190309153658147087.mp4", "第一个放视频", 2));
//        list.add(new DataBean(R.drawable.image7, "听风.赏雨", 1));
//        list.add(new DataBean(R.drawable.image8, "迪丽热巴.迪力木拉提", 1));
//        list.add(new DataBean(R.drawable.image9, "爱美.人间有之", 1));
//        list.add(new DataBean(R.drawable.image10, "洋洋洋.气质篇", 1));
//        list.add(new DataBean(R.drawable.image11, "生活的态度", 1));
//        return list;
//    }
    public static List<DataBean> getBannerData() {
        List<DataBean> list = new ArrayList<>();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Document doc = Jsoup.connect(StaticValue.HOME_URL_LIUYUETINGSHU).get();
//                    Log.d(StaticValue.TAGS, "initData: " + doc.body());
//
//                    //获取所有图片
//                    Elements imgs = doc.select("img[src]");
//                    for (Element img :
//                            imgs) {
//                        Log.d(StaticValue.TAGS, img.attr("src"));
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
        list.add(new DataBean("http://www.6yueting.com/img/banner/1.png", null, 1));
        list.add(new DataBean("http://www.6yueting.com/img/banner/2.jpg", null, 1));
        list.add(new DataBean("http://www.6yueting.com/img/banner/4.jpg", null, 1));
        list.add(new DataBean("http://www.6yueting.com/img/banner/5.jpg", null, 1));
        return list;
    }

    public static List<DataBean> getVideos() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/21/mp4/190321153853126488.mp4", null, 0));
        list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/18/mp4/190318231014076505.mp4", null, 0));
        list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/18/mp4/190318214226685784.mp4", null, 0));
        list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/19/mp4/190319125415785691.mp4", null, 0));
        list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995.mp4", null, 0));
        list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/14/mp4/190314102306987969.mp4", null, 0));
        return list;
    }


    public static List<String> getColors(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(getRandColor());
        }
        return list;
    }

    /**
     * 获取十六进制的颜色代码.例如  "#5A6677"
     * 分别取R、G、B的随机值，然后加起来即可
     *
     * @return String
     */
    public static String getRandColor() {
        String R, G, B;
        Random random = new Random();
        R = Integer.toHexString(random.nextInt(256)).toUpperCase();
        G = Integer.toHexString(random.nextInt(256)).toUpperCase();
        B = Integer.toHexString(random.nextInt(256)).toUpperCase();

        R = R.length() == 1 ? "0" + R : R;
        G = G.length() == 1 ? "0" + G : G;
        B = B.length() == 1 ? "0" + B : B;

        return "#" + R + G + B;
    }
}
