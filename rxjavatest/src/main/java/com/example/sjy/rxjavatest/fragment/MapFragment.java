package com.example.sjy.rxjavatest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sjy.rxjavatest.R;
import com.example.sjy.rxjavatest.adapter.ItemListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sjy_1993 on 2017/3/10.
 */
public class MapFragment extends BaseFragment {


    @BindView(R.id.previousPageBt)
    Button previousPageBt;
    @BindView(R.id.nextPageBt)
    Button nextPageBt;
    @BindView(R.id.gridRvr)
    RecyclerView gridRvr;
    @BindView(R.id.swipeRefreshlayout)
    SwipeRefreshLayout swipeRefreshlayout;
    @BindView(R.id.pageTv)
    TextView pageTv;
    ItemListAdapter adapter = new ItemListAdapter();
//    Observable<List<Item>> observable = new Observable<List<Item>>(){
//
//        @Override
//        public void onCompleted() {
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            swipeRefreshlayout.setRefreshing(false);
//            Toast.makeText(getActivity(), "加载失败", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onNext(List<Item> images) {
//           swipeRefreshlayout.setRefreshing(false);
//            pageTv.setText(getString(R.string.page_with_number, page));
//            adapter.setItems(images);
//        }
//    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
        gridRvr.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
       gridRvr.setAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getDialogRes() {
        return 0;
    }

    @Override
    protected int getTitleRes() {
        return 0;
    }

    @OnClick({R.id.previousPageBt, R.id.nextPageBt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.previousPageBt:
                break;
            case R.id.nextPageBt:
                break;
        }
    }
}
