package com.example.sjy.rxjavatest.net.api;

import com.example.sjy.rxjavatest.moudle.ZhuangbiImage;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sjy_1993 on 2017/3/11.
 */
public interface ZhuangbiApi {
    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q")String query);


}
