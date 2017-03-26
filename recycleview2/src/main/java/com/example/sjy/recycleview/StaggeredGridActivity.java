package com.example.sjy.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class StaggeredGridActivity extends ActionBarActivity {
    private RecyclerView mRecycleView;
    private List<String> mDatas;
    private StaggeredAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();
        //进行adapter的设置           Context,数据
        mAdapter = new StaggeredAdapter(mDatas, this);
        mRecycleView.setAdapter(mAdapter);
        //设置布局
//        方法1）mRecycleView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器
//        方法2）
        mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        //设置动画分割线
        mRecycleView.setItemAnimator(new DefaultItemAnimator());


        //设置分割线
//        mRecycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);//为什么前面加“”
        }


    }

    private void initViews() {
        mRecycleView = (RecyclerView) findViewById(R.id.recyclerview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.pubuView: //瀑布流就是每个item不一样
//                mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(5,
//                        StaggeredGridLayoutManager.HORIZONTAL));//水平瀑布流
//                break;
//            case R.id.gridView:                  //3列相册布局
//                mRecycleView.setLayoutManager(new GridLayoutManager(this, 3));
//                break;
//            case R.id.lineView:                  //3列相册布局
//                mRecycleView.setLayoutManager(new LinearLayoutManager(this));
//                break;
//
//            case R.id.action_add:
////            addData(1);
//                break;
//            case R.id.action_delete:
////              deleteData(1);
//                break;


//        }
        return super.onOptionsItemSelected(item);
    }
}