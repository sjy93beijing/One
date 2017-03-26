package com.example.sjy.myapplication.data.retrofit;

import android.content.Context;

import com.example.sjy.myapplication.bean.MovieDetailBean;
import com.example.sjy.myapplication.bean.TheatersMoive;
import com.example.sjy.myapplication.bean.mTop250Bean;
import com.example.sjy.myapplication.data.Repository;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * 修改历史：
 */
public class RetrofitRepository implements Repository {

    private static RetrofitRepository mRetrofitRepository;
    private Context mContext;
    private MovieApiService mMovieApiService;

    private RetrofitRepository(Context mContext) {
        this.mContext = mContext;
        mMovieApiService = MovieApiService.Factory.createService(mContext);
    }

    public synchronized static RetrofitRepository getInstance(Context context) {
        if (mRetrofitRepository == null) {
            mRetrofitRepository = new RetrofitRepository(context);
        }
        return mRetrofitRepository;
    }


    //观察者模式
    @Override                            //传递一个参数进去了
    public Observable<List<TheatersMoive.SubjectsEntity>> gettheatersMovie(String city) {
        return mMovieApiService.getTheatersMovie(city)
                .map(new Func1<TheatersMoive, List<TheatersMoive.SubjectsEntity>>() {
                    @Override
                    public List<TheatersMoive.SubjectsEntity> call(TheatersMoive theatersMoive) {
                        return theatersMoive.getSubjects();
                    }
                });
    }


//    public Observable<BookRoot> searchBookByTag(String tag){
////        return mMovieApiService.searchBookByTag(tag)
////                .map()
//
//    }

//    @Override
//    public Observable<CommonBean> getCommingSoonMovie(int start, int count) {
//        return mMovieApiService.getCommongSoonMovie(start, count);
//               /* .map(new Func1<CommonBean, List<CommonBean.SubjectsBean>>() {
//                    @Override
//                    public List<CommonBean.SubjectsBean> call(CommonBean commonBean) {
//                        return commonBean.getSubjects();
//                    }
//                });*/
//    }
//

    public Observable<MovieDetailBean> getMovieDetail(int id) {
        return mMovieApiService.getMovieDetail(id);/*map(new Func1<MovieDetailBean, MovieDetailBean>() {
            @Override
            public MovieDetailBean call(MovieDetailBean movieDetailBean) {
                return movieDetailBean;
            }
        });*/
    }
//
//    @Override
//    public Observable<CelebrityBean> getCelebrityDetail(int id) {
//        return mMovieApiService.getCelebrityDetail(id);
//    }
//

    public Observable<mTop250Bean> getTop250Movie(int start, int count) {
        return mMovieApiService.getTop250Movie(start, count);
    }
//

//    @Override
//    public Observable<Books> getBookDetail(String  id) {
//        return mMovieApiService.getBookDetail(id);
//    }
//
//    @Override
//    public Observable<BookRoot> searchBookByTag(String tag) {
//        return null;
//    }


//    @Override
//    public Observable<UsBoxBean> getUsBoxMovie() {
//        return mMovieApiService.getUsBoxMovie();
//    }
//

}