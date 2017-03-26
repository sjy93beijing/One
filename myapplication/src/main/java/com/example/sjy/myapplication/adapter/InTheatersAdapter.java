package com.example.sjy.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.bean.TheatersMoive;
import com.example.sjy.myapplication.ui.main.MovieDetailActivity;
import com.udaye.library.pullloadlibrary.CommonViewHolder;

import java.util.List;

/**
 * Created by sjy_1993 on 2017/3/5.
 */
public class InTheatersAdapter extends com.udaye.library.pullloadlibrary.RecyclerViewCommonAdapter<TheatersMoive.SubjectsEntity> {

    public InTheatersAdapter(List<TheatersMoive.SubjectsEntity> list, Context context) {
        super(context, list, R.layout.view_list_home);
    }

    public void update(List<TheatersMoive.SubjectsEntity> list) {
        mList = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
    @Override
    public void onListBindViewHolder(CommonViewHolder holder, int position) {
        final TheatersMoive.SubjectsEntity entity = mList.get(position);
        Glide.with(mContext)
                .load(mList.get(position).getImages().getLarge())
                .placeholder(android.R.color.white)
                .into((ImageView) holder.getView(R.id.photo));
        holder.setText(R.id.tv_movie_name, entity.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mContext.startActivity(MovieDetailActivity.getCalling(mContext, entity.getId()));
            }
        });

    }
}
