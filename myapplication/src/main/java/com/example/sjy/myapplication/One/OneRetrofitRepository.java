package com.example.sjy.myapplication.One;

import android.content.Context;

import com.example.sjy.myapplication.One.Bean.IdListBean;
import com.example.sjy.myapplication.One.Bean.PhotoDetail;
import com.example.sjy.myapplication.One.Bean.PhotoList;
import com.example.sjy.myapplication.One.Bean.ReadingDetail;
import com.example.sjy.myapplication.One.Bean.ReadingList;

import rx.Observable;

/**
 * Created by sjy_1993 on 2017/3/22.
 */
public class OneRetrofitRepository implements OneRepository{

    private static OneRetrofitRepository mOneRetrofitRepository;
    private Context mContext;
    private OneApiService oneApiService;


    public OneRetrofitRepository(Context mContext) {
            oneApiService =OneApiService.Factory.createService(mContext);
            this.mContext = mContext;
    }

    public synchronized static OneRetrofitRepository getInstance(Context context) {
        if (mOneRetrofitRepository == null) {
            mOneRetrofitRepository = new OneRetrofitRepository(context);
        }
        return mOneRetrofitRepository;
    }

    @Override
    public Observable<ReadingDetail> getReadingDetail(int content_id) {
        return  oneApiService.getReadingDetail(content_id);
    }

    //获取图片的消息
    @Override
    public Observable<PhotoList> getPhotoList() {
        return oneApiService.getPhotoList();
    }
        //获取图片的详情
    @Override
    public Observable<PhotoDetail> getPhotoDetail(int id) {
        return oneApiService.getPhotoDetail(id);
    }
//查询one 的列表

    public Observable<IdListBean> getDoubanIdList() {
        return oneApiService.getDoubanIdList();
    }

    public Observable<ReadingList> getReadingList(){
        return oneApiService.getReadingList();
    }

    /**
     * public Observable<mTop250Bean> getTop250Movie(int start, int count) {
     return mMovieApiService.getTop250Movie(start, count);
     }
     * @return
     */

}
