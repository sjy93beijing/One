package com.example.sjy.myapplication.One;

import android.content.Context;
import android.util.Log;

import com.example.sjy.myapplication.One.Bean.IdListBean;
import com.example.sjy.myapplication.One.Bean.PhotoDetail;
import com.example.sjy.myapplication.One.Bean.PhotoList;
import com.example.sjy.myapplication.One.Bean.ReadingDetail;
import com.example.sjy.myapplication.One.Bean.ReadingList;
import com.example.sjy.myapplication.utils.RecycleView.AppConfig;
import com.example.sjy.myapplication.utils.RecycleView.AppUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sjy_1993 on 2017/3/22.
 */
public interface OneApiService {
    String BASEURL = "http://v3.wufazhuce.com:8000/api/";
//http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
   //获取onelist

    @GET("onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Observable<IdListBean> getDoubanIdList();


    //获取详细的
    // http://v3.wufazhuce.com:8000/api/onelist/3528/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
//    @GET("onelist/{id}/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
//    Observable<>

    /**
     * 阅读
     * url:http://v3.wufazhuce.com:8000/api/reading/index/?version=3.5.0&platform=android
     */
    @GET("reading/index/?version=3.5.0&platform=android")
    Observable<ReadingList> getReadingList();
//
//    @GET("v2/movie/subject/{id}")
//    Observable<MovieDetailBean> getMovieDetail(@Path("id") int id);

    //获取详细的阅读信息
    @GET("essay/{content_id}?version=3.5.0&platform=android")
    Observable<ReadingDetail> getReadingDetail(@Path("content_id") int content_id);

    /**
     * 获取最近的图片
     * http://v3.wufazhuce.com:8000/api/hp/idlist/0?version=3.5.0&platform=android
     */

    @GET("hp/idlist/0?version=3.5.0&platform=android")
    Observable<PhotoList> getPhotoList();

    @GET("hp/detail/{id}?version=3.5.0&platform=android")
    Observable<PhotoDetail> getPhotoDetail(@Path("id") int id);

    class Factory {
        private static String TAG = "factory";

        public static OneApiService createService(final Context context) {
            //日志拦截器
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            /**
             * 获取缓存
             */
            Interceptor baseInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!AppUtil.isNetWorkAvailable(context)) {
                        /**
                         * 离线缓存控制  总的缓存时间=在线缓存时间+设置离线缓存时间
                         */
                        int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周,单位:秒
                        CacheControl tempCacheControl = new CacheControl.Builder()
                                .onlyIfCached()
                                .maxStale(maxStale, TimeUnit.SECONDS)
                                .build();
                        request = request.newBuilder()
                                .cacheControl(tempCacheControl)
                                .build();
                        Log.i(TAG, "intercept:no network ");
                    }
                    return chain.proceed(request);
                }
            };
            //只有 网络拦截器环节 才会写入缓存写入缓存,在有网络的时候 设置缓存时间
            Interceptor rewriteCacheControlInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Response originalResponse = chain.proceed(request);
                    int maxAge = 1 * 60; // 在线缓存在1分钟内可读取 单位:秒
                    return originalResponse.newBuilder()
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .removeHeader("Cache-Control")
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                }
            };
            //设置缓存路径 内置存储
            //File httpCacheDirectory = new File(context.getCacheDir(), "responses");
            //外部存储
            File httpCacheDirectory = new File(context.getExternalCacheDir(), "responses");
            //设置缓存 10M
            int cacheSize = 10 * 1024 * 1024;
            Cache cache = new Cache(httpCacheDirectory, cacheSize);

            OkHttpClient client;
            //如果默认为 缓存数据
            if (AppConfig.getIsCache(context)) {
                client = new OkHttpClient.Builder()
                        .cache(cache)
                        .addInterceptor(logging)
                        .addInterceptor(baseInterceptor)
                        .addNetworkInterceptor(rewriteCacheControlInterceptor)
                        .connectTimeout(15, TimeUnit.SECONDS)
                        .build();
            } else {
                client = new OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .connectTimeout(15, TimeUnit.SECONDS)
                        .build();
            }

            return new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BASEURL)
                    .client(client)
                    .build()
                    .create(OneApiService.class);
        }
    }
    //endregion

}

