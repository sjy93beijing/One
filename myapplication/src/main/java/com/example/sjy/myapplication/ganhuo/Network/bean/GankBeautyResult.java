package com.example.sjy.myapplication.ganhuo.Network.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sjy_1993 on 2017/3/11.
 */
public class GankBeautyResult {
    public boolean error;
    public @SerializedName("results")
    List<GankBeauty> beauties;
}
