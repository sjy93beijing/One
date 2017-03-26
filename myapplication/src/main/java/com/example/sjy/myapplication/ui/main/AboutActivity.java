package com.example.sjy.myapplication.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sjy.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sjy_1993 on 2017/3/24.
 */
public class AboutActivity extends BaseActivity{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private CollapsingToolbarLayout tablayout;
    @Override
    protected void initActionBar() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);     ButterKnife.bind(this);

        toolbar.setTitle("长残了的某人");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backThActivity();
            }
        });
    }
}
