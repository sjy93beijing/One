package com.example.sjy.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sjy_1993 on 2017/3/13.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{
    final String CREATE_TABLE_SQL =
            "Create table dict(_id integer primary " +
    "key  autoincrement ,word ,detail)";
    //默认的构造函数
    public MyDatabaseHelper(Context context, String name, int version){
        super(context,name,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //第一次使用数据库的时候自动建表
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        System.out.print("-- 升级 --" +i+"---->" +  i1);

    }
}
