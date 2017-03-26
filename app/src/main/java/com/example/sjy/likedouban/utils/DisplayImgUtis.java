package com.example.sjy.likedouban.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;




/**
 *   
 * Created by forezp on 16/8/10.
 */
public class DisplayImgUtis {
    private static DisplayImgUtis instance;
    private DisplayImgUtis(){}
    public static DisplayImgUtis getInstance(){
        if(instance==null){
            instance =new DisplayImgUtis();
        }
        return  instance;
    }

    //图片缓存框架
    public void display(Context context,String url,ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }

}
