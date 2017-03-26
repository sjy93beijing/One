package com.example.sjy.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.sjy.myapplication.One.Bean.ReadingList;
import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.ui.main.DoubanReadingDetailActivity;
import com.udaye.library.pullloadlibrary.CommonViewHolder;
import com.udaye.library.pullloadlibrary.RecyclerViewCommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjy_1993 on 2017/3/23.
 */
public class OneReadingAdapter extends RecyclerViewCommonAdapter<ReadingList.DataEntity.EssayEntity> {
    private static final String TAG = "OneReadingAdapter";

    public OneReadingAdapter(Context mContext, List<ReadingList.DataEntity.EssayEntity> list) {
        super(mContext, list, R.layout.one_readlist);
    }
    public void update(List<ReadingList.DataEntity.EssayEntity> list) {
        addList((ArrayList<ReadingList.DataEntity.EssayEntity>) list);
    }

    @Override
    public void onListBindViewHolder(CommonViewHolder holder, int position) {
//        final mTop250Bean.mSubjectsBean subjectsBean = getItem(position);
        //文章
        final ReadingList.DataEntity.EssayEntity dataEssyEntity = getItem(position);
       List<ReadingList.DataEntity.EssayEntity.AuthorEntity> author =  dataEssyEntity.getAuthor();
        //作者的姓息
       String str= author.get(0).getUser_name();
        final ReadingList.DataEntity.QuestionEntity questionEntity;
        Log.i(TAG, "onListBindViewHolder: "+"当前id"+dataEssyEntity.getContent_id()+"\n"+"当前内容"+dataEssyEntity.getHp_title());
     //标题   有了
        Log.i(TAG, "onListBindViewHolder: "+"当前时间"+ dataEssyEntity.getHp_title()+"作者"+str);
       holder.setText(R.id.re_hp_title,dataEssyEntity.getHp_title());

       //文章导读     有了
        holder.setText(R.id.re_guide_word,dataEssyEntity.getGuide_word());
        //时间
     holder.setText(R.id.re_timelist,String.format(mContext.getString(R.string.tip_essag_data),dataEssyEntity.getHp_makettime()));
       //作者姓名
        holder.setText(R.id.re_author_name,String.format(mContext.getString(R.string.tip_essag_author),author.get(0).getUser_name()));
//        holder.setText(R.i)
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //电影的主体类的
               mContext.startActivity(DoubanReadingDetailActivity.getCalling(mContext,dataEssyEntity.getContent_id()));

            }
        });

    }
}

