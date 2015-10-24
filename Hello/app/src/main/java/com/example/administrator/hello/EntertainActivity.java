package com.example.administrator.hello;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.AdapterView.OnItemClickListener;
/**
 * Created by Administrator on 2015/10/2.
 */

public class EntertainActivity extends Activity {
    ListView mylist;
    //设置图片
    private int[] imageIds=new int[]
            {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.f,R.drawable.e,R.drawable.aa,R.drawable.bb,
            R.drawable.easy,R.drawable.entertain};
    //设置视频信息
    private String[] names=new String[]
            {
                    "三只小猪要独立生活","三只小猪要盖房子","小猪盖房子","","","","","","",""
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertain);

        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItem.put("title", names[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
                new String[]{"image", "title"}, new int[]{R.id.images, R.id.titles});
        ListView mylist = (ListView) findViewById(R.id.mylist);
        mylist.setAdapter(simpleAdapter);
         //为ListView的列表项的单击事件绑定事件监听器
            mylist.setOnItemClickListener(new OnItemClickListener() {
        @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //利用intent传递影片的路径
                Intent intent =new Intent();
                String data;
            //选择不同的position的情况
                switch(position){
                    case 0:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p1;
                        //把传递的东西放进去
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p2;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });


    }

    }




