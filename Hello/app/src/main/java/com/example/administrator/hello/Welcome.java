package com.example.administrator.hello;

import com.example.administrator.hello.util.SystemUiHider;

import android.content.Intent;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;

import com.ant.liao.GifView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class Welcome extends Activity {
    // 播放背景音乐的MediaPlayer
    private MediaPlayer player;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    private static final int SPLASH_DISPLAY_LENGHT = 4000; //延迟秒数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        // 控制欢迎界面的时间和显示
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent mainIntent = new Intent(Welcome.this, MainActivity.class);
                Welcome.this.startActivity(mainIntent);
                Welcome.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

        // gif动画显示
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int mScreenWidth = dm.widthPixels;
        int mScreenHeight = dm.heightPixels;

        GifView gifFont = (GifView) findViewById(R.id.gif_font);
        gifFont.setGifImage(R.drawable.gif_font);
        //设置gif大小
        gifFont.setShowDimension(mScreenWidth, mScreenHeight);
        gifFont.setGifImageType(GifView.GifImageType.COVER);

        GifView gifImg1 = (GifView) findViewById(R.id.gif_img1);
        gifImg1.setGifImage(R.drawable.gif_img1);
        //设置gif大小
        gifImg1.setShowDimension(180, 180);
        gifImg1.setGifImageType(GifView.GifImageType.COVER);

        GifView gifImg2 = (GifView) findViewById(R.id.gif_img2);
        gifImg2.setGifImage(R.drawable.gif_img2);
        //设置gif大小
        gifImg2.setShowDimension(250, 250);
        gifImg2.setGifImageType(GifView.GifImageType.COVER);

        GifView gifImg3 = (GifView) findViewById(R.id.gif_img3);
        gifImg3.setGifImage(R.drawable.gif_img3);
        //设置gif大小
        gifImg3.setShowDimension(gifImg3.getWidth(), gifImg3.getHeight());
        gifImg3.setGifImageType(GifView.GifImageType.COVER);

        GifView gifImg4 = (GifView) findViewById(R.id.gif_img4);
        gifImg4.setGifImage(R.drawable.gif_img4);
        //设置gif大小
        gifImg4.setShowDimension(250, 250);
        gifImg4.setGifImageType(GifView.GifImageType.COVER);

        GifView gifImg5 = (GifView) findViewById(R.id.gif_img5);
        gifImg5.setGifImage(R.drawable.gif_img5);
        //设置gif大小
        gifImg5.setShowDimension(gifImg5.getWidth(), gifImg5.getHeight());
        gifImg5.setGifImageType(GifView.GifImageType.COVER);

        // 播放背景音乐
        player = MediaPlayer.create(this, R.raw.hello);
        //设置背景音乐循环player.setLooping(true);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                //播完了接着播或者关闭mMediaPlayer
                player.stop();
                player.release();
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }


    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {

    }

}
