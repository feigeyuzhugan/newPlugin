package com.zhongzi.anim5;


import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Administrator on 2017/10/26.
 */

public interface ApiService {

    @GET("/openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=car")
    Call<Translation> getCall();
}
