package com.example.sjy.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sjy_1993 on 2017/3/15.
 */
public class TestActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_test1);

        loadPage();
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);


    }

    private void loadPage(){
       // swipeRefreshLayout.setRefreshing(true);
//        unsubscribe();
//        subscription = Network.getGankApi()
//                .getBeauties(10,page)
//                .map(GankBeautyResultToItemsMapper.getInstance())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
    }
}
