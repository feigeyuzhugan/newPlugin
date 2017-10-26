package com.zhongzi.anim5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button button;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        a= AnimationUtils.loadAnimation(this,R.anim.scale_anim);
        textView= (TextView) findViewById(R.id.textview);
        button= (Button) findViewById(R.id.button);
        image= (ImageView) findViewById(R.id.imageView);
        button.setOnClickListener(this);

        test();
//        textView.setAnimation(a);
    }

    private void test() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       ApiService api= retrofit.create(ApiService.class);
        Call<Translation> call=api.getCall();
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Response<Translation> response, Retrofit retrofit) {
                Log.e( "onResponse: ",response.body().toString() );
            }
            @Override
            public void onFailure(Throwable t) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                loadScaleAnim();
                Log.e("onClick: ","---------" );
                break;
        }
    }
//    Animation a;
    private void loadScaleAnim() {
        Log.e("loadScaleAnim: ","---------" );
        Animation  a = AnimationUtils.loadAnimation(this,R.anim.scale_anim);
        ScaleAnim s=new ScaleAnim();
        textView.startAnimation(s);
    }
}
