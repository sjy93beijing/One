package com.example.sjy.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecycleView;
    private List<String> mDatas;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();
        //进行adapter的设置           Context,数据
        mAdapter = new SimpleAdapter(mDatas, this);
        mRecycleView.setAdapter(mAdapter);
        //设置布局
        mRecycleView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        //设置添加删除动画
        mRecycleView.setItemAnimator(new DefaultItemAnimator());

        //设置分割线
        mRecycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //设置监听
        mAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"您点击的位置是"+position,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,"您点击的位置是"+position,Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);//为什么前面加“”
        }

    }

    private void initViews() {
        //绑定视图
        mRecycleView = (RecyclerView) findViewById(R.id.recyclerview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.pubuView: //瀑布流就是每个item不一样
                Intent intent = new Intent(MainActivity.this,StaggeredGridActivity.class);
                startActivity(intent);
//
//                mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(5,
//                        StaggeredGridLayoutManager.HORIZONTAL));//水平瀑布流
                break;
            case R.id.gridView:                  //3列相册布局
                mRecycleView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.lineView:                  //仿照ListView
                mRecycleView.setLayoutManager(new LinearLayoutManager(this));
                break;

            case R.id.action_add:
            mAdapter.addData(1);
                break;
            case R.id.action_delete:
           mAdapter.deleteData(1);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}