
package com.example.administrator.hello;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.ImageButton;

/**
 * Created by Administrator on 2015/10/2.
 */

public class HardActivity extends AppCompatActivity {
    private ImageButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hardmode);

        b1= (ImageButton) findViewById(R.id.v1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HardActivity.this, VideoplayActivity.class);
                startActivity(intent1);
            }
        });

    }
}
