package com.example.sjy.rxjavatest.moudle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sjy_1993 on 2017/3/10.
 */
public class GankBeautyResult {
    public  boolean error;
    public @SerializedName("result")
    List<GankBeautyResult> beauties;
}
