package com.zhongzi.httputils.net;

import android.content.Context;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/9.
 * 网络请求引擎的规范
 */

public interface HttpEngine {
    void post(Context context, String url, Map<String,String> params,HttpCallback callback,boolean cache);
    void get(Context context, String url, Map<String,String> params,HttpCallback callback,boolean cache);
}
