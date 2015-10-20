package com.example.juan.ukmouse;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Administrator on 2015/10/12.
 */
public class VideoplayActivity extends Activity {
    VideoView videoView;
    MediaController mController;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);//窗口支持透明度
        setContentView(R.layout.videoplay);
        //获取界面上的VideoView组件
        videoView = (VideoView) findViewById(R.id.video);
        String uri="android.resource://" + getPackageName() + "/" +R.raw.p1;

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
