package com.jaydon.listenbooks.http.exception;

import androidx.annotation.NonNull;

import com.demo.http.exception.HttpException;
import com.jaydon.listenbooks.http.model.HttpData;


/**
 * desc   : 返回结果异常
 */
public final class ResultException extends HttpException {

    private final HttpData<?> mData;

    public ResultException(String message, HttpData<?> data) {
        super(message);
        mData = data;
    }

    public ResultException(String message, Throwable cause, HttpData<?> data) {
        super(message, cause);
        mData = data;
    }

    @NonNull
    public HttpData<?> getHttpData() {
        return mData;
    }
}