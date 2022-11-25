package com.jaydon.listenbooks.http.server;

import androidx.annotation.NonNull;

/**
 * desc   : 测试环境
 */
public class TestServer extends ReleaseServer {

    @NonNull
    @Override
    public String getHost() {
        return "https://www.wanandroid.com/";
    }
}