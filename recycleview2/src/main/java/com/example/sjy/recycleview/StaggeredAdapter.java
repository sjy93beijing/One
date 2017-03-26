package com.example.sjy.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class StaggeredAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private LayoutInflater mInflater; //inflate      item的布局
    private List<String> mDatas;
    private Context mContext;

    private List<Integer> mHeights;

        //构造方法  自己创建的
    public StaggeredAdapter(List<String> datas, Context context ) {

        this.mDatas = datas;
        this.mContext = context;
       mInflater = LayoutInflater.from(context);

        //初始化这个item布局
        mHeights = new ArrayList<Integer>();
        for (int i=0;i<mDatas.size();i++){
            mHeights.add((int) (100+Math.random()*300));
        }

    }
    //实现未实现的方法

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    //绑定ViewHolder里的数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            //绑定数据显示在item里
        holder.tv.setText(mDatas.get(position));
     LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);



    }
    //创建一个VIewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //得到上一层的View
        View view = mInflater.inflate(R.layout.simple_item,parent,false);
            //内容提供者
        MyViewHolder viewHolder = new MyViewHolder(view); //  得到上一层的View里

        return viewHolder;
    }
}
