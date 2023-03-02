package com.jaydon.listenbooks;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.demo.http.EasyConfig;
import com.demo.http.config.IRequestInterceptor;
import com.demo.http.config.IRequestServer;
import com.demo.http.model.HttpHeaders;
import com.demo.http.model.HttpParams;
import com.demo.http.request.HttpRequest;
import com.jaydon.listenbooks.http.model.RequestHandler;
import com.jaydon.listenbooks.http.server.ReleaseServer;
import com.jaydon.listenbooks.http.server.TestServer;
import com.tencent.mmkv.MMKV;

import okhttp3.OkHttpClient;

/**
 * 应用入口
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MMKV.initialize(this);

        // 网络请求框架初始化
        IRequestServer server;
        if (BuildConfig.DEBUG) {
            server = new TestServer();
            Log.e("测试服", server.getHost());
        } else {
            server = new ReleaseServer();
            Log.e("正式服", server.getHost());
        }

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        EasyConfig.with(okHttpClient)
                // 是否打印日志
                //.setLogEnabled(BuildConfig.DEBUG)
                // 设置服务器配置
                .setServer(server)
                // 设置请求处理策略
                .setHandler(new RequestHandler(this))
                // 设置请求参数拦截器
                .setInterceptor(new IRequestInterceptor() {
                    @Override
                    public void interceptArguments(@NonNull HttpRequest<?> httpRequest,
                                                   @NonNull HttpParams params,
                                                   @NonNull HttpHeaders headers) {
                        headers.put("timestamp", String.valueOf(System.currentTimeMillis()));
                    }
                })
                // 设置请求重试次数
                .setRetryCount(1)
                // 设置请求重试时间
                .setRetryTime(2000)
                // 添加全局请求参数
                .addParam("token", "6666666")
                // 添加全局请求头
                //.addHeader("date", "20191030")
                .into();
    }


    /**
     * 忽略https的证书校验
     */

}
