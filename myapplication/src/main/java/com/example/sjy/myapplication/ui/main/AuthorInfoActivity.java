package com.example.sjy.myapplication.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;

import com.example.sjy.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sjy_1993 on 2017/3/24.
 */
public class AuthorInfoActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.rootLayout)
    CoordinatorLayout rootLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorinfo);
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar() {
        collapsingToolbarLayout.setTitle("崖山之内无中国，明朝之后无华夏");
//        ViewUtils.setTextViewUnderline(tvGithub,github);

    }

    public String setActName() {
        return null;
    }
    @Override
    protected void initActionBar() {

    }
}
