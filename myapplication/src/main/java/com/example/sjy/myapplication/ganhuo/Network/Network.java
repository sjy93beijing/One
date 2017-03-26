package com.example.sjy.myapplication.ganhuo.Network;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sjy_1993 on 2017/3/11.
 */
public class Network {
//    private static ZhuangbiApi zhuangbiApi;
    private static GankApi gankApi;
//    private static FakeApi fakeApi;
    private static TheOneApi theoneApi;
    private static ReadinglistApi readinglistApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
//
//    public static ZhuangbiApi getZhuangbiApi() {
//        if (zhuangbiApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(okHttpClient)
//                    .baseUrl("http://www.zhuangbi.info/")
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            zhuangbiApi = retrofit.create(ZhuangbiApi.class);
//        }
//        return zhuangbiApi;
//    }



    public static GankApi getGankApi() {
        if (gankApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            gankApi = retrofit.create(GankApi.class);
        }
        return gankApi;
    }

//    public static FakeApi getFakeApi() {
//        if (fakeApi == null) {
//            fakeApi = new FakeApi();
//        }
//        return fakeApi;
//    }

    //首页
//    public static TheOneApi  getTheOneidlist(){
//        if(theoneApi == null){
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl("http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
//                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//             theoneApi = retrofit.create(TheOneApi.class);
//        }
//        return theoneApi;
//    }
//    //阅读列表页  先用这个来实现
//    public static ReadinglistApi  getreadinglist(){
//        if(readinglistApi == null){
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl("http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
//                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//            readinglistApi = retrofit.create(ReadinglistApi.class);
//        }
//        return getreadinglist();
    }



