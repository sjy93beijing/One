package com.example.sjy.recycleview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//mRecyclerView = findView(R.id.id_recyclerview);
////设置布局管理器
//        mRecyclerView.setLayoutManager(layout);
////设置adapter
//        mRecyclerView.setAdapter(adapter)
////设置Item增加、移除动画
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
////添加分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(
//        getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
public class RecycleTestActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_test);
        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        //设置方向
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器
        mRecyclerView.setAdapter(mAdapter = new TestAdapter());//设置adapter

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));//                    为代码添加 分割线
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    //菜单项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }
    //  菜单项监听事件


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
      switch (id){
          case R.id.pubuView: //瀑布流就是每个item不一样
              mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,
                      StaggeredGridLayoutManager.HORIZONTAL));//水平瀑布流
              break;
          case R.id.gridView:                  //3列相册布局
              mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
              break;
          case R.id.action_add:
//            addData(1);
              break;
          case R.id.action_delete:
//              deleteData(1);
              break;


      }

        return super.onOptionsItemSelected(item);
    }


    //给数据赋值
    protected  void initData(){
        mDatas = new ArrayList<String>();//datas是一个ArrayList数组
        for(int i='A';i<'z';i++){
            mDatas.add("" + (char) i);
        }

    }
    //默认是继承ViewHolder                       继承下面手写的              泛型方法
    class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder>{

        //1.创建ViewHolder
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            //绑定这个item
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                   RecycleTestActivity.this).inflate(R.layout.item, parent,
                    false));
            return holder;
        }


        //2.绑定viewHolder
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            //通过holder设定值  完成TextView的赋值
            holder.tv.setText(mDatas.get(position));
        }

    //必须在Adapter类里面写。
        //增加参数的方法
        public void addData(int pos){
            mDatas.add("掺入一个");
            notifyItemInserted(pos);

        }
        public void deleteData(int pos){
            mDatas.remove(pos);
            notifyItemRemoved(pos);

        }
        //数据的大小
        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }


        //自己手写  定义一个的ViewHolder
        class MyViewHolder extends ViewHolder
        {
            //item所有的控件
            TextView tv;
            //创建的一个构造方法
            public MyViewHolder(View view)
            {
                super(view);//构造方法
                tv = (TextView) view.findViewById(R.id.id_num);//进行初始化
            }
        }
    }


    }

