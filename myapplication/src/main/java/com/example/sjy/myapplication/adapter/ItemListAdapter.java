package com.example.sjy.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.ganhuo.Network.bean.Item;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sjy_1993 on 2017/3/11.
 */
public class ItemListAdapter extends RecyclerView.Adapter{
    List<Item> images;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new  DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//  声明这个ViewHolder
        DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
        Item image = images.get(position);
        //加载图片
        Glide.with(holder.itemView.getContext()).load(image.imageUrl).into(debounceViewHolder.imageView);
        //图片描述
        debounceViewHolder.textView.setText(image.description);
    }
//点击的小图片
    public void setItems(List<Item> images) {
        this.images = images;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return images == null ? 0:images.size();
    }
    static class   DebounceViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageIv)
        ImageView imageView;
        @BindView(R.id.descriptionTv)
        TextView textView;
        public  DebounceViewHolder(View item){
            super(item);
            ButterKnife.bind(this,item);
        }
    }
}
