package com.example.sjy.likedouban.service;

import com.example.sjy.likedouban.bean.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sjy_1993 on 2017/2/24.
 */
public interface MovieService {
    //这是一个回调的方法
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

}
