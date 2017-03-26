package com.example.sjy.myapplication.ganhuo.Network;

import com.example.sjy.myapplication.ganhuo.Network.bean.GankBeautyResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sjy_1993 on 2017/3/11.
 */
public interface GankApi {
    @GET("data/福利/{number}/{page}")
    Observable<GankBeautyResult> getBeauties(@Path("number") int number, @Path("page") int page);
}
