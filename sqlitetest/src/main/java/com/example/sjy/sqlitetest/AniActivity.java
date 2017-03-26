package com.example.sjy.sqlitetest;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by sjy_1993 on 2017/3/13.
 */
public class AniActivity extends Activity{

    private  float curX = 0;
    private  float curY = 30;

    //下一次的位置
    private float nextX = 0;
    private float nextY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ani_main);
        final ImageView imageView = (ImageView) findViewById(R.id.butterfly);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123){
                    //横向向右飞
                if(nextX>320){
                   nextX = 0;
                }else {
                    nextX+= 8;
                }
          //纵向上可以随机上下
                    nextY = curY + (float) (Math.random() *10-5);

                    TranslateAnimation anim = new TranslateAnimation(curX,nextX,curY,nextY);
                    curX = nextX;
                    curY = nextY;
                    anim.setDuration(200);
                    imageView.startAnimation(anim);

                }
            }
        };
        final AnimationDrawable butterfly = (AnimationDrawable) imageView.getBackground();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                butterfly.start();//蝴蝶振翅

            }
        });

    }
}
