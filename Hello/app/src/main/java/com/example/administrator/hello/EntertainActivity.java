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
            {R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8,
                    R.drawable.i9,R.drawable.i10};
    //设置视频信息
    private String[] names=new String[]
            {
                    "三只小猪要独立生活","三只小猪要盖房子","大灰狼吹倒两座房子","大灰狼的尾巴着火了","大灰狼的大弟弟鼻子破了",
                    "大灰狼的小弟弟上当了","大灰狼装绵羊","第一只小猪拜牛为师","第三只小猪办食物加工厂","三只小猪看望妈妈"
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

                    case 2:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p3;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 3:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p4;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 4:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p5;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 5:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p6;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 6:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p7;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 7:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p8;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 8:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p9;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;

                    case 9:
                        data="android.resource://" + getPackageName() + "/" +R.raw.p10;
                        intent.putExtra("vaddress", data);
                        intent.setClass(EntertainActivity.this, VideoplayActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });


    }

}




