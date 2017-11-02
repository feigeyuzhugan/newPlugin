package com.lzb.viewpagedome;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/10/31.
 */

public class TransformerT implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {
        Log.e("transformPage: ", position+"---");

    }
}
