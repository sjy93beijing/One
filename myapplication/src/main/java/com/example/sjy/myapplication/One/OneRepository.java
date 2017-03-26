package com.example.sjy.myapplication.One;

import com.example.sjy.myapplication.One.Bean.IdListBean;
import com.example.sjy.myapplication.One.Bean.PhotoDetail;
import com.example.sjy.myapplication.One.Bean.PhotoList;
import com.example.sjy.myapplication.One.Bean.ReadingDetail;
import com.example.sjy.myapplication.One.Bean.ReadingList;

import rx.Observable;

/**
 * Created by sjy_1993 on 2017/3/22.
 */
public interface OneRepository {

    //获取 一个 的连接
//    Observable<List> getids();
    //获取一个的 连接的下面的全部
    /**
     * 获取 onelist
     将上一个 json 中的 data 字段的值放入 url 中，并拼接好相应的参数
     url：http://v3.wufazhuce.com:8000/api/onelist/ +
     上面获取的data + /0?cchannel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
     *
     */
    Observable<IdListBean> getDoubanIdList();

    //获取文章列表
    Observable<ReadingList> getReadingList();

    //获取文章详情

    Observable<ReadingDetail> getReadingDetail(int content_id);

    //获取图片列表
    Observable<PhotoList> getPhotoList();
    //获取图片详情
    Observable<PhotoDetail> getPhotoDetail(int id);

}
