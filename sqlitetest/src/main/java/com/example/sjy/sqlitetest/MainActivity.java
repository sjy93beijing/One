package com.example.sjy.sqlitetest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.input1)
    EditText input1;  //word
    @BindView(R.id.input2)
    EditText input2; //detail
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.find_text)
    EditText findText;  //用户输入
    @BindView(R.id.search)
    Button search;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private static final String TAG = "MainActivity";
    MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        //数据库的相关操作
        dbHelper = new MyDatabaseHelper(this,"myDict.db3",1);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.insert, R.id.search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insert:
                Toast.makeText(MainActivity.this,"插入数据",Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: "+"insert被点击了");
                String word = input1.getText().toString();
                String detail = input2.getText().toString();
                //插入生词记录
                insertData(dbHelper.getWritableDatabase(),word,detail);
                break;
            case R.id.search:
                Log.i(TAG, "onClick: "+"Search被点击了");
                String key = findText.getText().toString();
                //执行查询
                Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                        "select * from dict where word like ? or detail like ?",
                        new String[] {"%" + key +"%","%" +key + "%"});
                //创建一个Bundle对象
                Bundle data = new Bundle();
                data.putSerializable("data",converCursorToList(cursor));
                //
                Intent intent  = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);
                break;
        }
    }

    protected ArrayList<Map<String,String>> converCursorToList(Cursor cursor){
        ArrayList<Map<String,String>> result = new ArrayList<Map<String,String>>();
        //遍历结果集
        while( cursor.moveToNext()){
            //将结果集中的数据存入到ArrayList中
            Map<String,String> map = new HashMap<>();
            //取出查询记录中的第2,3列
            map.put("word",cursor.getString(1));
            map.put("detail",cursor.getString(2));
            result.add(map);
        }
        return  result;
    }
    private void insertData(SQLiteDatabase db,String word,String detail) {
        //执行插入语句
        db.execSQL("insert into dict values(null,?,?)" , new String[] {word,detail});
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbHelper!=null){
            dbHelper.close();
        }
    }
}
