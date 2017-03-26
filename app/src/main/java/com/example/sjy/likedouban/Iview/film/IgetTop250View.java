package com.example.sjy.likedouban.Iview.film;

import com.example.sjy.likedouban.base.IBaseView;

import com.example.sjy.likedouban.bean.top250.Root;




/**
 * Created by sjy_1993 on 2017/3/3.
 */
public interface IgetTop250View extends IBaseView {
    void getTop250Success(Root root,boolean isLoadMore);

    /**
     * 网络请求失败
     */
    void getDataFail();

}