
package com.example.administrator.hello;

        import android.app.Activity;
        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.webkit.WebView;
        import android.widget.Button;

        import com.ant.liao.GifView;


public class HardActivity extends Activity implements OnClickListener {
    private Button play, pause, stop;
    MediaPlayer mPlayer;
    int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 使用activity_main文件定义的界面布局
        setContentView(R.layout.hardmode);
        GifView aaa = (GifView)findViewById(R.id.gif2);
        aaa.setGifImage(R.drawable.cute);
//        WebView mouse =(WebView)findViewById(R.id.aaa);
//        mouse.setBackgroundColor(0);
//        mouse.loadDataWithBaseURL(null, "<img src='file:///android_asset/aaa.gif'>", "text/html", "utf-8", null);
        //获取界面中的三个按钮
//        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);
        //为三个按钮的单击事件绑定事件监听器
//        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        //创建MediaPlayer并找到音频
        mPlayer = MediaPlayer.create(this, R.raw.abc);
        mPlayer.start();
    }

    public void onClick(View source) {
        try {
            switch (source.getId()) {
                //播放按钮被单击
//                case R.id.play:
//                    if(!mPlayer.isPlaying()){
//                        mPlayer.start();
//                    }
//                    break;
                //暂停按钮被单击
                case R.id.pause:
                    if(mPlayer.isPlaying()){
                        mPlayer.pause();
                        pause.setBackgroundResource(R.drawable.red);
                    }
                    else {
                        mPlayer.start();
                        pause.setBackgroundResource(R.drawable.blue);
                    }
                    break;
                //停止按钮被单击
                case R.id.stop:
                    this.finish();
                    mPlayer.release();
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
