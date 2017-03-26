package com.example.sjy.likedouban.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sjy.likedouban.Iview.film.IGetFilmLiveView;
import com.example.sjy.likedouban.base.BasePresenter;
import com.example.sjy.likedouban.bean.film.FilmLive;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sjy_1993 on 2017/2/26.
 */
public class DoubanFilmPresenter extends BasePresenter{
    public DoubanFilmPresenter(Context context){
        super(context);
    }
    //获取正在热映
    public void getFilmLive(IGetFilmLiveView iGetFilmLiveView){

        doubanApi.getLiveFilm()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(filmLive -> {
                    disPlayFilmLiveList(iGetFilmLiveView,filmLive, mContext);
                },this::loadError);


}

    private void disPlayFilmLiveList(IGetFilmLiveView iGetFilmLiveView, FilmLive filmLive, Context context) {
        //Toast.makeText(context,filmLive.toString(),Toast.LENGTH_SHORT).show();
        if(filmLive==null){
            iGetFilmLiveView.getDataFail();
        }else {
            iGetFilmLiveView.getFilmLiveSuccess(filmLive);
            Log.e("test", filmLive.toString());
        }
    }

//
//    /**
//     * 获取top250
//     * @param start
//     * @param count
//     */
//
//    public void getTop250(IgetTop250View igetTop250View,int start, int count,boolean isLoadMore){
//        doubanApi.getTop250(start,count)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(root -> {
//                    disPlayDoubanTop250List(igetTop250View,root, isLoadMore);
//                },this::loadError);
//
//    }
//
//    private void disPlayDoubanTop250List(IgetTop250View igetTop250View, Root root, boolean isLoadMore) {
//        //Toast.makeText(context,root.toString(),Toast.LENGTH_SHORT).show();
//        Log.e("test",root.toString());
//        igetTop250View.getTop250Success(root, isLoadMore);
//    }
    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(mContext, "网络不见了", Toast.LENGTH_SHORT).show();
    }


}
