package com.example.sjy.likedouban;

import android.app.Application;
import android.content.Context;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class MyApp extends Application{
    private static final String DB_NAME ="weibo.db";//数据库
    public static Context mContext;//上下文对象

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();//获取上下文
    }
}
