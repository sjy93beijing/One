package com.example.sjy.recycleview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
//GridView的活动
public class MainActivity extends AppCompatActivity {
    private static RecyclerView recyclerview;
    private CoordinatorLayout coordinatorLayout;
    private GridAdapter mAdapter;
    private List<Meizi> meizis;
    private GridLayoutManager mLayoutManager;
    private int lastVisibleItem ;
    private int page=1;

    private SwipeRefreshLayout swipeRefreshLayout;
    private String str= "http://gank.io/api/data/福利/10/1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initView();//初始化布局
        setListener();//设置监听事件
    //设置字符串
      String   temp = str.substring(0,29);
        for(int i=0;i<10;i++){
            str = temp+i;
        }
        //执行加载数据
        new GetData().execute(str);

    }

    private void initView(){
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.grid_coordinatorLayout);

        recyclerview=(RecyclerView)findViewById(R.id.grid_recycler);
        mLayoutManager=new GridLayoutManager(MainActivity.this,3,GridLayoutManager.VERTICAL,false);//设置为一个3列的纵向网格布局
        recyclerview.setLayoutManager(mLayoutManager);

        swipeRefreshLayout=(SwipeRefreshLayout) findViewById(R.id.grid_swipe_refresh) ;
        //调整SwipeRefreshLayout的位置
        swipeRefreshLayout.setProgressViewOffset(false, 0,  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
    }

    private void setListener(){
        //swipeRefreshLayout刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page=1;


                String   temp = str.substring(0,29);
                for(int i=0;i<10;i++){
                    str = temp+i;
                    new GetData().execute(str);
                }

            }
        });
    }


    private class GetData extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //设置swipeRefreshLayout为刷新状态
            swipeRefreshLayout.setRefreshing(true);
        }

        @Override
        protected String doInBackground(String... params) {

            return MyOkhttp.get(params[0]);
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(!TextUtils.isEmpty(result)){

                JSONObject jsonObject;
                Gson gson=new Gson();
                String jsonData=null;

                try {
                    jsonObject = new JSONObject(result);
                    jsonData = jsonObject.getString("results");//得到解析结果
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(meizis==null||meizis.size()==0){
                    meizis= gson.fromJson(jsonData, new TypeToken<List<Meizi>>() {}.getType());

                    Meizi pages=new Meizi();
                    pages.setPage(page);
                    meizis.add(pages);//在数据链表中加入一个用于显示页数的item
                }else{
                    List<Meizi>  more= gson.fromJson(jsonData, new TypeToken<List<Meizi>>() {}.getType());
                    meizis.addAll(more);

                    Meizi pages=new Meizi();
                    pages.setPage(page);
                    meizis.add(pages);//在数据链表中加入一个用于显示页数的item
                }

                if(mAdapter==null){
                    recyclerview.setAdapter(mAdapter = new GridAdapter( MainActivity.this,meizis));//recyclerview设置适配器

                    //实现适配器自定义的点击监听
                    mAdapter.setOnItemClickListener(new GridAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view) {
                            int position=recyclerview.getChildAdapterPosition(view);
//                            SnackbarUtil.ShortSnackbar(coordinatorLayout,"点击第"+position+"个",SnackbarUtil.Info).show();
                            //彩色Snackbar工具类，请看我之前的文章《没时间解释了，快使用Snackbar!——Android Snackbar花式使用指南》http://www.jianshu.com/p/cd1e80e64311
                        }
                        @Override
                        public void onItemLongClick(View view) {

                        }
                    });
                }else{
                    //让适配器刷新数据
                    mAdapter.notifyDataSetChanged();
                }
            }
            //停止swipeRefreshLayout加载动画
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}