package com.example.sjy.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.adapter.Top250Adapter;
import com.example.sjy.myapplication.bean.mTop250Bean;
import com.example.sjy.myapplication.utils.RecycleView.GridMarginDecoration;
import com.udaye.library.pullloadlibrary.LinearRecyclerView;
import com.udaye.library.pullloadlibrary.OnLoadMoreListener;
import com.udaye.library.pullloadlibrary.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sjy_1993 on 2017/3/5.
 */
public class Top250Fragment extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "Top250Fragment";
    //初始化控件 下拉刷新  RecycleView
    LinearRecyclerView recycleView;  //升级版的ListView
    SwipeRefreshLayout mSwipeRefreshLayout; //下拉刷新
    Top250Adapter top250Adapter;

    List<mTop250Bean.mSubjectsBean> mSubjectsBeans;//电影的top250
    mTop250Bean mmTop250Bean;
    public static Top250Fragment newInstance() {
        Bundle args = new Bundle();
        Top250Fragment fragment = new Top250Fragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //引进用viw就不会有错
        View view = inflater.inflate(R.layout.fragment_top250, null);
        recycleView = (LinearRecyclerView) view.findViewById(R.id.recyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    //相当于Activity里面一样  执行逻辑
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //初始化这个Linear  成为竖直List
        LinearLayoutManager mLinearManager = new LinearLayoutManager(getActivity());
        //设置
        recycleView.setLayoutManager(mLinearManager);
        recycleView.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        recycleView.setHasFixedSize(true);
        //设置下拉刷新
        //加载更多
        recycleView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(SuperRecyclerView recyclerView) {
                if (mmTop250Bean != null && mmTop250Bean.isHasNext()) {
                    recyclerView.showFootProgress();
                    requestDefaultData(mmTop250Bean.getNextIndex(), 20);
//                    Log.d(TAG, "onRefresh: "+);
                } else {
                    recyclerView.showFootProgressEnd();
                }
            }
            });
                setPreLoadData();


    }

    private void setPreLoadData() {
        //下拉刷新
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
               onRefresh();
            }
        });

    }
    //刷新前面的数据
    @Override
    public void onRefresh() {
        if(top250Adapter!=null){
            top250Adapter.clear();
        }
        requestDefaultData(0, 20);

    }

    //下拉   观察者
    private void requestDefaultData(int start, int count) {
        mRepository.getTop250Movie(start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<mTop250Bean>() {
                    @Override
                    public void onCompleted() {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onNext(mTop250Bean mTop250Bean) {
                        //1，上面直接是取出的JAVABean对象
                        //  mTop250Bean  就是bean对象的源
                        if (mTop250Bean != null) {
                            Log.i(TAG, "onNext: 进入了Top250");
                            recycleView.showFootProgressEnd();//显示加载完成的View
                            //这个是一个值来表达他 并不是数组List
                            mmTop250Bean = mTop250Bean;
                            Log.d(TAG, "onRefresh: "+recycleView);


                            //2.用对象的源文件取装 mSubjjj是Bean对象   关键  取得Bean里面的   有用属性
                            mSubjectsBeans = mTop250Bean.getSubjects();
                            if (top250Adapter == null) {
                                top250Adapter = new Top250Adapter(getContext(), mSubjectsBeans);
                                recycleView.setAdapter(top250Adapter);

                            } else {
                                //3.用数组传过去。
                                top250Adapter.update((ArrayList<mTop250Bean.mSubjectsBean>) mSubjectsBeans);
                            }
                        }
                    }
                });

    }
}