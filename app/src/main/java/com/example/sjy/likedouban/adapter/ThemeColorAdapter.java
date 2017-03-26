package com.example.sjy.likedouban.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sjy.likedouban.R;
import com.example.sjy.likedouban.base.EasyRecyclerViewAdapter;
import com.example.sjy.likedouban.bean.ThemeColor;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 颜色选择的适配器类
 * Created by sjy_1993 on 2017/3/1.
 */
public class ThemeColorAdapter extends EasyRecyclerViewAdapter<ThemeColor>{
       //构造函数

     public ThemeColorAdapter(){

        }
    private int position;



    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
   View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theme_color,parent,false);

        return new ThemeColorViewHolder(view);
    }
    //绑定
    @Override                 //ThemeColor实体类
    public void onBind(final RecyclerView.ViewHolder viewHolder,final int RealPosition, ThemeColor data) {
        ((ThemeColorViewHolder)viewHolder).theme_color.setImageResource(data.getColor());
        if(data.isChosen()) {
            ((ThemeColorViewHolder) viewHolder).chose.setVisibility(View.VISIBLE);
            position = RealPosition;
        }else{
            ((ThemeColorViewHolder) viewHolder).chose.setVisibility(View.GONE);
            }

    }

    class ThemeColorViewHolder extends EasyViewHolder{
       @BindView(R.id.theme_color)
        CircleImageView theme_color;
        @BindView(R.id.choose)
        ImageView chose;
    public ThemeColorViewHolder(View itemView){
        super(itemView);//基础父类
        ButterKnife.bind(this,itemView);
    }

    }
    public int getPosition() {
        return position;
    }
}
