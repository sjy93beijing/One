package com.example.sjy.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.adapter.InTheatersAdapter;
import com.example.sjy.myapplication.bean.TheatersMoive;
import com.example.sjy.myapplication.utils.RecycleView.GridMarginDecoration;
import com.udaye.library.pullloadlibrary.GridRecyclerView;
import com.udaye.library.pullloadlibrary.OnLoadMoreListener;
import com.udaye.library.pullloadlibrary.SuperRecyclerView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sjy_1993 on 2017/3/5.
 */


/**
 * Created by sjy_1993 on 2017/3/5.
 */
public class InTheaterFragment extends BaseFragment implements
        SwipeRefreshLayout.OnRefreshListener{
//   @BindView(R.id.srl_refresh_layout)
//    SwipeRefreshLayout mSwipeRefreshLayout;
//    @BindView(R.id.recyclerview)
//    GridRecyclerView mRecycleView;

    GridRecyclerView mRecyclerView;
    GridLayoutManager mGridLayoutManager;
    InTheatersAdapter mTheaterAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;

    List<TheatersMoive.SubjectsEntity> mSubjectsEntities;
    public static InTheaterFragment newInstance() {
        Bundle args = new Bundle();
        InTheaterFragment fragment = new InTheaterFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intheater, null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (GridRecyclerView) view.findViewById(R.id.recyclerview);
        return view;
    }

    //View创建 分页
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGridLayoutManager = new GridLayoutManager(getActivity(), 3);//分成三页
//        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                switch (position % 6) {
//                    case 5:
//                        return 3;
//                    case 3:
//                        return 2;
//                    default:
//                        return 1;
//                }
//            }
//        });
        //下拉框的动作
        mRecyclerView.setLayoutManager(mGridLayoutManager);//设置成这种显示
        mRecyclerView.addItemDecoration(new GridMarginDecoration(
                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(SuperRecyclerView recyclerView) {
                // recyclerView.showFootProgress();
            }
        });

        setPreLoadData();
    }

    @Override
    public void onRefresh() {
        requestDefaultData();
    }

    public void setPreLoadData() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                requestDefaultData();
            }
        });
    }

    /**
     * Observable被观察者 发射源
     * Observer 观察者  接收数据
     *
     * Subscriber：“订阅者”，也是接收源Subscriber实现了Observer接口，比Observer多了一个最重要的方法unsubscribe( )，用来取消订阅
     *Subscription ：Observable调用subscribe( )方法返回的对象，同样有unsubscribe( )方法，可以用来取消订阅事件；
     RxJava中的一个接口，它只有一个无参call（）方法，且无返回值
     */
    //监听者
    private void requestDefaultData() {
        mRepository.gettheatersMovie("杭州")//根据城市获取资源
                .subscribeOn(Schedulers.io())//观察它
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<TheatersMoive.SubjectsEntity>>() {
                    //接收数据完成时调用                   调用这个数据
                    @Override
                    public void onCompleted() {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                    //数据接收错误时调用
                    @Override
                    public void onError(Throwable e) {
                        if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                    //正常接收数据调用
                    @Override
                    public void onNext(List<TheatersMoive.SubjectsEntity> subjectsEntities) {
                        //1.取到传回来的数据 用 javaBean对象装着
                        mSubjectsEntities = subjectsEntities;
                        if (mTheaterAdapter == null) {
                            //2;出入Adapter
                            mTheaterAdapter = new InTheatersAdapter(mSubjectsEntities,getActivity());
                            mRecyclerView.setAdapter(mTheaterAdapter);
                        } else {
                            mTheaterAdapter.update(mSubjectsEntities);
                        }

                    }
                });

    }

}




