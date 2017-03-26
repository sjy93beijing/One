package com.example.sjy.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.bean.mTop250Bean;
import com.example.sjy.myapplication.ui.main.MovieDetailActivity;
import com.udaye.library.pullloadlibrary.CommonViewHolder;
import com.udaye.library.pullloadlibrary.RecyclerViewCommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * top 250
 * <p/>
 * Created on 16/7/12.
 */
public class Top250Adapter extends RecyclerViewCommonAdapter<mTop250Bean.mSubjectsBean> {
    private static final String TAG = "Top250Adapter";
    /**
     * @param mContext 上下文对象
     * @param list     数据List
     */
    public Top250Adapter(Context mContext, List<mTop250Bean.mSubjectsBean> list) {
        super(mContext, list, R.layout.view_top_250);//父类
    }

    public void update(List<mTop250Bean.mSubjectsBean> list) {
        addList((ArrayList<mTop250Bean.mSubjectsBean>) list);
    }

    @Override
    public void onListBindViewHolder(CommonViewHolder holder, int position) {
        final mTop250Bean.mSubjectsBean subjectsBean = getItem(position);
        holder.setText(R.id.tv_movie_name, subjectsBean.getTitle());

        Log.i(TAG, "Top250  onListBindViewHolder: "+subjectsBean.getTitle()+subjectsBean.getYear());
        //这里要写成取得它的评分  即时平均分
        holder.setText(R.id.tv_movie_score, String.format(mContext.getString(R.string.tip_score), String.valueOf(subjectsBean.getRating().getAverage())));
        holder.setText(R.id.tv_movie_date, String.format(mContext.getString(R.string.tip_movie_date), subjectsBean.getYear()));
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.iv_movie_icon);
        //图片加载
        Glide.with(mContext)
                .load(mList.get(position).getImages().getLarge())
                .placeholder(android.R.color.white)
                .into(imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //电影的主体类的   一个id 比如肖申克的救赎1424124
           mContext.startActivity(MovieDetailActivity.getCalling(mContext, subjectsBean.getId()));
            }
        });

    }
}
