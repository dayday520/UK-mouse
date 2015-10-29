package com.example.administrator.hello;

import android.content.Intent;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
   private Button b1,b2,b3;
    private WebView gif1,gif2,gif3;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout main = (RelativeLayout) findViewById(R.id.root);

        gif1 = (WebView)this.findViewById(R.id.webView1);
        gif1.setBackgroundColor(0);
        gif1.loadDataWithBaseURL(null, "<img src='file:///android_asset/easy2.gif'>", "text/html", "utf-8", null);


        gif2 = (WebView)this.findViewById(R.id.webView2);
        gif2.setBackgroundColor(0);
        gif2.loadDataWithBaseURL(null, "<img src='file:///android_asset/hardmode2.gif'>", "text/html", "utf-8", null);

        gif3 = (WebView)this.findViewById(R.id.webView3);
        gif3.setBackgroundColor(0);
        gif3.loadDataWithBaseURL(null, "<img src='file:///android_asset/entertain2.gif'>", "text/html", "utf-8", null);

        b1= (Button) findViewById(R.id.easybutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent1);
            }
        });

        b2= (Button) findViewById(R.id.hardbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,HardActivity.class);
                startActivity(intent2);
            }
        });

        b3= (Button) findViewById(R.id.entertainbutton);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this,EntertainActivity.class);
                startActivity(intent3);
            }
        });



    }




}
