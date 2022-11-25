package com.jaydon.listenbooks.http.server;

import androidx.annotation.NonNull;

import com.demo.http.config.IRequestServer;

/**
 * desc   : 正式环境
 */
public class ReleaseServer implements IRequestServer {


    @NonNull
    @Override
    public String getHost() {
        return null;
    }

//    @NonNull
//    @Override
//    public BodyType getBodyType() {
//        return BodyType.FORM;
//    }
//
//    @NonNull
//    @Override
//    public CacheMode getCacheMode() {
//        return null;
//    }
//
//    @Override
//    public long getCacheTime() {
//        return 0;
//    }
//
//    @NonNull
//    @Override
//    public OkHttpClient getOkHttpClient() {
//        return null;
//    }
}