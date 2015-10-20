package com.example.juan.ukmouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private ImageButton b1,b2,b3;
    private WebView gif1;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);---单个去掉LABEL
        setContentView(R.layout.activity_main);
        LinearLayout main = (LinearLayout) findViewById(R.id.root);

        gif1 = (WebView)this.findViewById(R.id.webView);
        gif1.setBackgroundColor(0);
        gif1.loadDataWithBaseURL(null,"<img src='file:///android_asset/easy.gif'>","text/html","utf-8",null);

        b1= (ImageButton) findViewById(R.id.easybutton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent1);
            }
        });

        b2= (ImageButton) findViewById(R.id.hardbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,HardActivity.class);
                startActivity(intent2);
            }
        });

        b3= (ImageButton) findViewById(R.id.entertainbutton);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this,EntertainActivity.class);
                startActivity(intent3);
            }
        });
    }


}
