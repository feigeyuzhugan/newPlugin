package com.lzb.recyclerviewdome.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/11/3.
 */

public class XiaoMiStepView extends View {

    private int backGroundColor,outerCircleColor,outerDotColor,lineColor,ringColor,stepNumColor,othetTextColor;
    //定义画笔
    private int defSize=300;
    private int bgWidth,bgHeight;
    private Paint bgPaint;
    private Paint outCirclePaint;//最外围的圆圈，红色
    private Paint outPointPaint;//最外围的小圆点，蓝色
    private Paint interCirclePaint;//内部的圆环，白色
    private Paint interPaint;//内部的圆弧，红色
    private Paint textPaint;//画字的笔，黑色
    private int centerWidth,centerHeight;//圆点
    private int outRadius;//外圆的半径
    private int interRadius;//内圆的半径
    private float angle=30;//角度

    private String text="开始记步";

    public XiaoMiStepView(Context context) {
        this(context,null);
    }

    public XiaoMiStepView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        backGroundColor=0x0FA9C1;
        outerCircleColor=0x26B7CA;
        outerDotColor=0xDAF9FC;
        lineColor=0x46BDD3;
        ringColor=0xACDBE5;
        stepNumColor=0xEBFEFF;
        othetTextColor=0x0FA9C1;
        init();
    }

    private void init() {
        bgPaint=new Paint();
        bgPaint.setAntiAlias(true);
        outCirclePaint=new Paint();
        outCirclePaint.setAntiAlias(true);

        outPointPaint=new Paint();
        outPointPaint.setAntiAlias(true);

        interCirclePaint=new Paint();
        interCirclePaint.setAntiAlias(true);

        interPaint=new Paint();
        interCirclePaint.setAntiAlias(true);

        textPaint=new Paint();
        textPaint.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width=measureSize(widthMeasureSpec);
        int height=measureSize(heightMeasureSpec);
        setMeasuredDimension(width,height);
        bgHeight=height;
        bgWidth=width;
        centerWidth=width/2;
        centerHeight=height/2;
        int min=Math.min(centerHeight,centerWidth);
        outRadius=min*2/3;
        interRadius=min/2;
    }

    private int measureSize(int measureSpec) {
        int result=defSize;
        int size=MeasureSpec.getSize(measureSpec);
        int mode=MeasureSpec.getMode(measureSpec);
        if (mode==MeasureSpec.EXACTLY){
            Log.e("measureSize: ",size+"--" );
            return size;
        }else {
            return Math.min(result,size);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w=getWidth()/2;
        int h=getHeight()/2;
        textPaint.setColor(Color.RED);
        canvas.drawText(text,w,h,textPaint);
//        canvas.drawColor(backGroundColor);
//        drawBg(canvas);
//        drawOutCircle(canvas);//外圆和外部的小圆点
//        drawInteCircle(canvas);//内圆环，和圆弧
//        drawText(canvas);//画字
    }

    private void drawText(Canvas canvas) {
        textPaint.setColor(Color.BLACK);
//        textPaint.setTextAlign(Paint.Align.CENTER);
//        textPaint.setTextSize(15);
//        Rect rect=new Rect();
//        textPaint.getTextBounds(text,0,text.length(),rect);
        canvas.drawText(text,centerWidth,centerHeight,textPaint);
//        canvas.drawt
    }

    private void drawInteCircle(Canvas canvas) {
        interCirclePaint.setColor(Color.WHITE);
        interCirclePaint.setStrokeWidth(50);
        interCirclePaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(centerWidth,centerHeight,interRadius,interCirclePaint);

        RectF rect=new RectF(centerWidth-interRadius,centerHeight-interRadius,centerWidth+interRadius,centerHeight+interRadius);
        interPaint.setColor(Color.RED);
        interPaint.setStrokeWidth(50);
        interPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        interPaint.setStrokeCap(Paint.Cap.ROUND);
        interPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawArc(rect,0,angle,false,interPaint);
    }

    private void drawOutCircle(Canvas canvas) {
        outCirclePaint.setColor(Color.RED);
        outCirclePaint.setStyle(Paint.Style.STROKE);
        outCirclePaint.setStrokeWidth(3);
        canvas.drawCircle(centerWidth,centerHeight,outRadius,outCirclePaint);
        //画小圆点
        outPointPaint.setColor(Color.BLUE);
        outPointPaint.setStrokeWidth(15);
        outCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        outCirclePaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawCircle((float) (centerWidth+outRadius*Math.cos((3.14 * angle) / 180)),(float) (centerHeight+outRadius*Math.sin(3.14*angle/180)),10,outPointPaint);
    }

    private void drawBg(Canvas canvas) {
        Log.e( "drawBg: ",bgHeight+"==="+bgWidth );
        bgPaint.setColor(Color.GRAY);
//        bgPaint.setStyle(Paint.Style.FILL);
        Rect rect=new Rect(0,0,bgWidth,bgHeight);
        canvas.drawRect(rect,bgPaint);
    }
}
