package com.example.sjy.likedouban.Iview.film;

import com.example.sjy.likedouban.base.IBaseView;
import com.example.sjy.likedouban.bean.film.FilmLive;

/**
 * Created by sjy_1993 on 2017/2/26.
 */
public interface IGetFilmLiveView extends IBaseView {

    void getFilmLiveSuccess(FilmLive filmLive);

    /**
     * 网络请求失败
     */
    void getDataFail();
}