package com.zhongzi.anim5;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2017/10/26.
 */

public class ScaleAnim extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix=t.getMatrix();
        matrix.setScale(15,15,500,500);
    }
}
