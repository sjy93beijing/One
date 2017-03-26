package com.example.sjy.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private LayoutInflater mInflater; //inflate      item的布局
    private List<String> mDatas;
    private Context mContext;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);

    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }
        //构造方法  自己创建的
    public SimpleAdapter(List<String> datas, Context context ) {

        this.mDatas = datas;
        this.mContext = context;
       mInflater = LayoutInflater.from(context);
    }
    //实现未实现的方法

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    //绑定ViewHolder里的数据
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
            //绑定数据显示在item里
        holder.tv.setText(mDatas.get(position));
        //设置监听事件  回调
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(holder.itemView,position);
            }
        });
        //longClick
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mOnItemClickListener.onItemLongClick(holder.itemView,position);
                return false;
            }
        });




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


    public void addData(int pos){
        mDatas.add("Insert one");
        notifyItemChanged(pos);
    }
    public void deleteData(int pos)
    {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }


}
    //自己写的ViewHolder
    class MyViewHolder extends ViewHolder{
        //当前Item所有的控件
    TextView tv;
    //arg0             相当于rootView
    public MyViewHolder(View arg0){
         super(arg0);
        //进行View的初始化
        tv = (TextView) arg0.findViewById(R.id.text_num);
    }

}