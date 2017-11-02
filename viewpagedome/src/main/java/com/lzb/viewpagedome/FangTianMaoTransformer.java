package com.lzb.viewpagedome;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2017/11/2.
 *
 */
public class FangTianMaoTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        int width=page.getWidth()/2;
        int height=page.getHeight()/2;
        if (position<-1){
            page.setScaleX(0f);
        }else if (position<=0){//这个位置就是能够看见的位置,向左滑
            page.setScaleY(Math.max(1 - Math.abs(position), 0.5f));
            page.setScaleX(Math.max(1 - Math.abs(position), 0.5f));
        }else if (position<=1){//这个位置就是能够看见的位置,向右滑
            page.setScaleY(Math.max(1 - Math.abs(position), 0.5f));
            page.setScaleX(Math.max(1 - Math.abs(position), 0.5f));
        }else {
            page.setScaleX(0f);
        }
    }
}
