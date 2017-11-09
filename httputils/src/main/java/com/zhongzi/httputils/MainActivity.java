package com.zhongzi.httputils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhongzi.httputils.net.HttpCallback;
import com.zhongzi.httputils.net.HttpUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils.with(this).setUrl("http://hyu3451540001.my3w.com/Api/getIndexTopBannerInfo").setCache(false).execute(new HttpCallback() {
            @Override
            public void onSuccess(String str) {
                Log.e("onSuccess: ",str );
            }

            @Override
            public void onFail() {

            }
        });
    }
}
