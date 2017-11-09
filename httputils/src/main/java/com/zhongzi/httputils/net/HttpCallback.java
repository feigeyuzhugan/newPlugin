package com.zhongzi.httputils.net;

/**
 * Created by Administrator on 2017/11/9.
 */

public interface HttpCallback<T> {
    void onSuccess(String str);
    void onFail();
}
