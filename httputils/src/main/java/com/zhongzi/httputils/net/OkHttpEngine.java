package com.zhongzi.httputils.net;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/11/9.
 *
 */

public class OkHttpEngine implements HttpEngine {

    OkHttpClient httpClient=new OkHttpClient();


    @Override
    public void post(Context context, String url, Map<String, String> params, HttpCallback callback, boolean cache) {
//        Request request=new Request.Builder().url(url).

    }

    @Override
    public void get(Context context, String url, Map<String, String> params, final HttpCallback callback, boolean cache) {
        final Request request=new Request.Builder().url(url).build();
        Call call=httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e( "onResponse: ",response.body().string()+"" );
                callback.onSuccess(response.body().string().toString());
            }
        });
    }
}
