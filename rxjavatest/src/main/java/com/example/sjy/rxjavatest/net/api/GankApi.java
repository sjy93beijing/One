package com.example.sjy.rxjavatest.net.api;

import com.example.sjy.rxjavatest.moudle.GankBeautyResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sjy_1993 on 2017/3/10.
 */
public interface GankApi {
    @GET("data/福利/{number}/{page}")
    Observable<GankBeautyResult> getBeauties(@Path("number") int number, @Path("page")int page);


}
