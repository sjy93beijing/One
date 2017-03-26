package com.example.sjy.picasso;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class WebViewActivity extends AppCompatActivity{
    @Bind(R.id.web_iv)
    WebView mwebView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        Intent i = getIntent();
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(i.getStringExtra("title"));//设置标题
        mwebView.loadUrl(i.getStringExtra("url"));//加载资源

        //本地显示
        mwebView.setWebViewClient(new android.webkit.WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }
}
