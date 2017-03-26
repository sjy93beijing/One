package com.example.sjy.myapplication.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sjy.myapplication.R;

/**
 * Created by sjy_1993 on 2017/3/5.
 */
public class BookFragment extends Fragment {


    private WebView webview;

    String url = "http://cl.4yt.xyz/index.php";

    public static BookFragment newInstance() {
        Bundle args = new Bundle();
        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        webview = (WebView) (view).findViewById(R.id.webview);
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
        initView();

      return view;

    }


    private void initView(){
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);// 支持JS
        settings.setBuiltInZoomControls(true);// 显示放大缩小按钮
        settings.setUseWideViewPort(true);// 支持双击放大缩
        webview.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


            }

            /**
             * 所有跳转的链接都在此方法中回调
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }

//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//
//                toolbar.setTitle(title);
//                super.onReceivedTitle(view, title);
//            }
        });
        webview.loadUrl(url);
    }


}
