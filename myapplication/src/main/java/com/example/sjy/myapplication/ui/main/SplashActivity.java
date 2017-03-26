package com.example.sjy.myapplication.ui.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ImageView;

import com.example.sjy.myapplication.MainActivity;
import com.example.sjy.myapplication.R;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by sjy_1993 on 2017/3/3.
 */
public class SplashActivity extends BaseActivity {

//    @BindView(R.id.image_change)
//    ImageView mSplash;
    ImageView mSplash;
    private static final int ANIMATION_TIME = 2000;

    private static final float SCALE_END = 1.13F;
    private static final int[] IMAGES ={
            R.mipmap.ic_screen_default,
            R.mipmap.splash0,
            R.mipmap.splash1,
            R.mipmap.splash2,
            R.mipmap.splash3,
            R.mipmap.splash4,
            R.mipmap.splash5,
            R.mipmap.splash6,
            R.mipmap.splash7,

    };

    @Override
    protected void initActionBar() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_main);
        setTranslucentStatus(true);//设置这个威震
        mSplash =(ImageView) findViewById(R.id.image_change);
        ButterKnife.bind(this);
        Random random = new Random(SystemClock.elapsedRealtime());
//

        mSplash.setImageResource(IMAGES[ random.nextInt(IMAGES.length)]);

        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>()
                {

                    @Override
                    public void call(Long aLong)
                    {
                        startAnim();//开启动画模式
                    }
                });

    }


    public String setActName() {
        return null;
    }
    private void startAnim(){

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplash, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplash, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();//
        set.setDuration(ANIMATION_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {
//                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
//                startActivity(intent);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));//跳转到MainActivity里面去
                  SplashActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }


}

