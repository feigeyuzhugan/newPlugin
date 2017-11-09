package com.zhongzi.httputils.net;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/9.
 */

public class HttpUtils {
    private Context mContext;
    private Map<String ,String> pararmsMap;//用于存储参数
    private boolean mCache=false;
    private String url;
    public final static int HTTP_GET=1;
    public final static int HTTP_POST=2;
    private int mRequestMethod =HTTP_GET;
    private HttpEngine mEngine=new OkHttpEngine();

//    private HttpCallback mCallback;

    private HttpUtils(Context context){
        this.mContext=context;
        pararmsMap=new HashMap<>();
    }

    /**
     * 更换引擎
     * @param engine
     * @return
     */
    public HttpUtils exchangeEngine(HttpEngine engine){
        this.mEngine=engine;
        return this;
    }

    public static HttpUtils with(Context context){
        return new HttpUtils(context);
    }

//    /**
//     * 添加回调
//     * @param callback
//     * @return
//     */
//    public HttpUtils addHttpCallback(HttpCallback callback){
//        this.mCallback=callback;
//        return this;
//    }

    public HttpUtils setUrl(String url) {
        this.url = url;
        return this;
    }

    public HttpUtils setCache(boolean cache) {
        this.mCache = cache;
        return this;
    }

    protected HttpUtils setRequestMethod(int requestMethod){
        this.mRequestMethod=requestMethod;
        return this;
    }

    public void execute(HttpCallback callback){
        if (this.mRequestMethod==1){
            this.mEngine.get(mContext,url,pararmsMap,callback,mCache);
        }else if (this.mRequestMethod==2){
            this.mEngine.post(mContext,url,pararmsMap,callback,mCache);
        }else {
            //
        }
    }

    public HttpUtils addParams(String name,String valus){
        pararmsMap.put(name,valus);
        return this;
    }

    public HttpUtils addParamsMap(Map<String,String> map){
        this.pararmsMap=map;
        return this;
    }

}
