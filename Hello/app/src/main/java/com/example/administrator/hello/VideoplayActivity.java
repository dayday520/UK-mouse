package com.example.administrator.hello;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

/**
 * Created by Administrator on 2015/10/12.
 */
public class VideoplayActivity extends Activity {
    VideoView videoView;
    MediaController mController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉头部title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);//窗口支持透明度
        //设置全屏
       setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.videoplay);
        //获取界面上的VideoView组件
        videoView = (VideoView) findViewById(R.id.video);



        //接收传递的信息
        Intent intent1 = getIntent();
        String uri = intent1.getStringExtra("vaddress");
        videoView.setVideoURI(Uri.parse(uri));
        videoView.requestFocus();//目前锁定的组件
        //设定影片一直播放
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView.start();
        mController = new MediaController(this);
        videoView.setMediaController(mController);
        mController.setMediaPlayer(videoView);
        mController.show();

    }
}

