package com.example.sjy.myapplication.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.sjy.myapplication.One.OneRetrofitRepository;
import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.data.retrofit.RetrofitRepository;

/**
 * Created by sjy_1993 on 2017/3/5.
 */
public abstract class BaseActivity extends AppCompatActivity{
    RetrofitRepository mRepository;
    OneRetrofitRepository mOneRepository;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = RetrofitRepository.getInstance(this);
        mOneRepository = OneRetrofitRepository.getInstance(this);
    }

    protected void startThActivity(Class<?> pClass) {
        Intent _Intent = new Intent();
        _Intent.setClass(this, pClass);//传入这个类
        startActivity(_Intent);

    }

    /**
     * 关闭界面
     **/
    public void backThActivity() {
        finish();
        overridePendingTransition(R.animator.trans_pre_in, R.animator.trans_pre_out);
    }
    protected void startThActivityByIntent(Intent pIntent){
        startActivity(pIntent);
//        overridePendingTransition(R.anim.trans_next_in, R.anim.trans_next_out);
    }

    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

   abstract protected void initActionBar();
}
