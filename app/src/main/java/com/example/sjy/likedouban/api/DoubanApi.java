package com.example.sjy.likedouban.api;

import com.example.sjy.likedouban.Iview.film.filmdetail.FilmDetail;
import com.example.sjy.likedouban.bean.film.FilmLive;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * Created by sjy_1993 on 2017/2/26.
 */
public interface DoubanApi {
    //观察者模式
    @GET("v2/movie/in_theaters")
    Observable<FilmLive> getLiveFilm();
    /**  导入的包要是rx.Observable而不是java.utils.Obersable
     * 获取电影详情
     * @param id
     * @return
     */

    @GET("v2/movie/subject/{id}")
    rx.Observable<FilmDetail> getFilmDetail(@Path("id") String id);

    /**
     * 北美榜单
     * @return
     */
//
//    @GET("v2/movie/us_box")
//    Observable<FilmUsBox> getUsBox();

}
