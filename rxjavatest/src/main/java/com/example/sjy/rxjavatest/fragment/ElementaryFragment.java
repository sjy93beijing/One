package com.example.sjy.rxjavatest.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sjy.rxjavatest.R;
import com.example.sjy.rxjavatest.adapter.ZhuangbiListAdapter;
import com.example.sjy.rxjavatest.moudle.ZhuangbiImage;
import com.example.sjy.rxjavatest.net.Network;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sjy_1993 on 2017/3/10.
 */
public class ElementaryFragment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swipeRefreshlayout)
    SwipeRefreshLayout swipeRefreshlayout;

    @Override
    protected int getDialogRes() {
        return R.layout.dialog_elementary;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_ele;
    }

    ZhuangbiListAdapter adapter = new ZhuangbiListAdapter();
    //观察者
    Observer<List<ZhuangbiImage>> observer = new Observer<List<ZhuangbiImage>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshlayout.setRefreshing(false);
            Toast.makeText(getActivity(), "数据加载失败", Toast.LENGTH_SHORT).show();

        }

        //执行过程 ，把图片加载进入
        @Override
        public void onNext(List<ZhuangbiImage> zhuangbiImages) {
            swipeRefreshlayout.setRefreshing(false);
            adapter.setImages(zhuangbiImages);
        }

    };


    @Nullable

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elementary, container, false);
        ButterKnife.bind(this, view);
        recycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recycler.setAdapter(adapter);
        swipeRefreshlayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshlayout.setEnabled(false);
        return view;

    }
//初始化控件

    @OnCheckedChanged({R.id.search1, R.id.search2, R.id.search3, R.id.search4})
    void onTagChecked(RadioButton searchRb, boolean checked) {
        if (checked) {
            unsubscribe();//取消订阅
            adapter.setImages(null);
            swipeRefreshlayout.setRefreshing(true);
            search(searchRb.getText().toString());//得到输入的内容

        }
    }

    private void search(String key) {
        subscription = Network.getZhuangbiApi()
                .search(key)
                .subscribeOn(Schedulers.io())//开启io线程
                .observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 的回调发生在主线程
                .subscribe(observer);

    }

    @OnClick({R.id.recycler, R.id.swipeRefreshlayout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recycler:
                break;
            case R.id.swipeRefreshlayout:
                break;
        }
    }

}
