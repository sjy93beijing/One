package com.example.sjy.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sjy.myapplication.One.Bean.IdListBean;
import com.example.sjy.myapplication.One.Bean.ReadingList;
import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.adapter.OneReadingAdapter;
import com.example.sjy.myapplication.utils.RecycleView.GridMarginDecoration;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sjy_1993 on 2017/3/23.
 */
public class OneReadingFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "OneReadingFragment";

    private SwipeRefreshLayout swiprefresh;
    private RecyclerView recycleView;
    private OneReadingAdapter oneReadingAdapter;
//    List<String> mdata = new ArrayList<String>();
    List<ReadingList.DataEntity.EssayEntity> essayEntities ;
//初始化
    public static OneReadingFragment newInstance() {
        Bundle args = new Bundle();
        OneReadingFragment fragment = new OneReadingFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onereading, null);
        //下拉框
        swiprefresh = (SwipeRefreshLayout) view.findViewById(R.id.read_refresh_layout);
        recycleView = (RecyclerView) view.findViewById(R.id.recyclerview);
        swiprefresh.setColorSchemeResources(R.color.colorPrimary);
        swiprefresh.setOnRefreshListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager mLinearManager = new LinearLayoutManager(getActivity());
        //设置
        recycleView.setLayoutManager(mLinearManager);
        recycleView.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        recycleView.setHasFixedSize(true);
        requestReadingData();
    }
//

    private void setPreLoadData() {
        //下拉刷新
       swiprefresh.post(new Runnable() {
            @Override
            public void run() {
                swiprefresh.setRefreshing(true);
                onRefresh();
            }
        });
    //刷新前面的数据

//        recycleView.addItemDecoration(new GridMarginDecoration(
//                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
//        recycleView.setHasFixedSize(true);
//        requestDefaultData();

    }

    private void requestReadingData(){
        mOneReposity.getReadingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ReadingList>() {
                    @Override
                    public void onCompleted() {

                       swiprefresh.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: "+"网络出错");
                        swiprefresh.setRefreshing(false);
                    }

                    @Override
                    public void onNext(ReadingList readingList) {
                if(readingList!=null){
                    Log.i(TAG, "onNext: 数据不为空");
                List<ReadingList.DataEntity.EssayEntity> essayEntities =  readingList.getData().getEssay();

                      Log.i(TAG, "onNext: "+"正在请求中");
//                    for (int i=0;i<essayEntities.size();i++) {
//                        String content_id = essayEntities.get(i).getContent_id();
//
//                        System.out.print(essayEntities.get(i).getHp_title()+essayEntities.get(i).getGuide_word());
//                        System.out.print(content_id);
//                        Log.i(TAG, "onNext: "+content_id+essayEntities.get(i).getGuide_word());
//                    }
                    if(oneReadingAdapter == null){
                        oneReadingAdapter = new OneReadingAdapter(getContext(),essayEntities);
                        recycleView.setAdapter(oneReadingAdapter);
                    }else{
                        oneReadingAdapter.update((ArrayList< ReadingList.DataEntity.EssayEntity>) essayEntities);
                        Toast.makeText(getContext(),"数据同步",Toast.LENGTH_LONG).show();
                    }

                }

                    }
                });

    }

    private void requestDefaultData() {
        mOneReposity.getDoubanIdList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<IdListBean>() {
                    @Override
                    public void onCompleted() {
                        
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: 数据未获取到");
                    }

                    @Override
                    public void onNext(IdListBean idListBean) {
                        if(idListBean!= null){

//                          mdata = idListBean.getData();
////                            for(int i=0;i<mdata.size();i++){
////
////                            }
//
//                            Log.i(TAG, "onNext: "+mdata);

                        }
                    }
                });
        
        
    }

    @Override
    public void onRefresh() {
        if(oneReadingAdapter!=null){
            oneReadingAdapter.clear();
            requestReadingData();
        }

    }
}

