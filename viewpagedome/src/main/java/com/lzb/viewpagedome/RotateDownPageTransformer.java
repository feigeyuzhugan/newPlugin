package com.lzb.viewpagedome;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/10/31.
 */

public class RotateDownPageTransformer implements ViewPager.PageTransformer {
    private final static float DEFAULT_ROTATE=15f;
    private final static float mRotate=DEFAULT_ROTATE;

    @Override
    public void transformPage(View view, float position) {
        int width=view.getWidth();
        int heigth=view.getHeight();
        Log.e("transformPage: ",position+"" );
        if (position<-1){
            view.setPivotX(width);
            view.setPivotY(heigth);
            view.setRotation(mRotate*-1);
//            view.setScaleX();
        }else if (position<=0){//-1到0
            view.setPivotX(view.getWidth() * (0.5f + 0.5f * (-position)));
            view.setPivotY(view.getHeight());
            view.setRotation(mRotate * position);
//            view.setScaleX(position);
        }else if (position<=1){//0到1
            view.setPivotX(view.getWidth() * 0.5f * (1 - position));
            view.setPivotY(view.getHeight());
            view.setRotation(mRotate * position);
        }else {
            view.setPivotX(width);
            view.setPivotY(heigth);
            view.setRotation(mRotate);
        }
    }
}
