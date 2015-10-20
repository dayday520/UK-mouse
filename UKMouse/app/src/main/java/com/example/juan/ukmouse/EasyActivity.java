package com.example.juan.ukmouse;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by Administrator on 2015/10/2.
 */

    public class EasyActivity extends Activity implements GestureDetector.OnGestureListener {
    ViewFlipper flipper;
    GestureDetector detector;
    Animation [] animations =new Animation[4];
    final int FLIP_DISTANCE =50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easymode);

        //创建手势检测器
        detector = new GestureDetector(this, this);
        flipper=(ViewFlipper) this.findViewById(R.id.flipper);
        //为ViewFlipper添加5个ImageView组件
        flipper.addView(addImageView(R.drawable.a));
        flipper.addView(addImageView(R.drawable.b));
        flipper.addView(addImageView(R.drawable.c));
        flipper.addView(addImageView(R.drawable.d));
        flipper.addView(addImageView(R.drawable.e));
        flipper.addView(addImageView(R.drawable.f));
        //初始化Animation数组
        animations[0]= AnimationUtils.loadAnimation(this,R.anim.left_in);
        animations[1] = AnimationUtils.loadAnimation(this, R.anim.left_out);
        animations[2] = AnimationUtils.loadAnimation(this, R.anim.right_in);
        animations[3] = AnimationUtils.loadAnimation(this, R.anim.right_out);
    }
    //定义添加ImageView的工具方法
    private View addImageView(int resId){
        ImageView imageView =new ImageView(this);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }
    //
    public boolean onFling(MotionEvent event1 ,MotionEvent event2,float velocityX,float velocityY){
        // 如果第一个触点事件的X坐标大于第二个触点事件的X坐标超过FLIP_DISTANCE
        // 也就是手势从右向左滑
        if(event1.getX()-event2.getX() >FLIP_DISTANCE){
            // 为flipper设置切换的的动画效果
            flipper.setInAnimation(animations[0]);
            flipper.setOutAnimation(animations[1]);
            flipper.showPrevious();
            return true;
        }
        // 如果第二个触点事件的X坐标大于第一个触点事件的X坐标超过FLIP_DISTANCE
        // 也就是手势从左向右滑
        else if(event2.getX()-event1.getX()>FLIP_DISTANCE){
            flipper.setInAnimation(animations[2]);
            flipper.setInAnimation(animations[3]);
            flipper.showNext();
            return true;
        }
        return false;
    }
    public boolean onTouchEvent(MotionEvent event){
        // 将该Activity上的触碰事件交给GestureDetector处理
        return detector.onTouchEvent(event);
    }
    public boolean onDown(MotionEvent arg0){
        return false;
    }
    public void onLongPress(MotionEvent event){

    }
    public boolean onScroll(MotionEvent event1,MotionEvent event2,float arg2, float arg3){
        return false;
    }
    public void onShowPress(MotionEvent event){}
    public boolean onSingleTapUp(MotionEvent event){
        return false;
    }
}
