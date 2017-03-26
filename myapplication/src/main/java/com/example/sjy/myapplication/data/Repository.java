package com.example.sjy.myapplication.data;


import com.example.sjy.myapplication.bean.MovieDetailBean;
import com.example.sjy.myapplication.bean.TheatersMoive;
import com.example.sjy.myapplication.bean.mTop250Bean;

import java.util.List;

import rx.Observable;

/**
 * 修改历史：1.写接口
 */
public interface Repository {

    /**
     * 获取正在上映
     *
     * @param city
     * @return
     */
    Observable<List<TheatersMoive.SubjectsEntity>> gettheatersMovie(String city);


    /**
     * 获取即将上映的电影
     *
     * @param start
     * @param count
     * @return
     */
//    Observable<CommonBean> getCommingSoonMovie(int start, int count);

    /**
     * 获取文章详情
     *
     * @param id id
     * @return
     */
    Observable<MovieDetailBean> getMovieDetail(int id);
//
//    /**
//     * 获取演员详情
//     *
//     * @param id
//     * @return
//     */
//    Observable<CelebrityBean> getCelebrityDetail(int id);
//
//
    /**
     * top 250 电影
     *
     * @param start
     * @param count
     * @return
     */
    Observable<mTop250Bean> getTop250Movie(int start, int count);
//
//    /**
//     * 北美排行榜
//     *
//     * @return
//     */
//    Observable<UsBoxBean> getUsBoxMovie();

/**
 * 获取豆瓣图书信息
 */
//   Observable<Books> getBookDetail(String id);
//
//    Observable<BookRoot> searchBookByTag(String tag);
}