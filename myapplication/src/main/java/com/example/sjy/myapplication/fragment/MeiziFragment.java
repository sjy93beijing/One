package com.example.sjy.myapplication.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.adapter.ItemListAdapter;
import com.example.sjy.myapplication.ganhuo.Network.Network;
import com.example.sjy.myapplication.ganhuo.Network.bean.Item;
import com.example.sjy.myapplication.ganhuo.Network.bean.mBaseFragment;
import com.example.sjy.myapplication.utils.RecycleView.GankBeautyResultToItemsMapper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sjy_1993 on 2017/3/11.
 */
public class MeiziFragment extends mBaseFragment {

private int page =0;
    @BindView(R.id.pageTv)
    TextView pageTv;
    @BindView(R.id.previousPageBt)
    AppCompatButton previousPageBt;
    @BindView(R.id.nextPageBt)
    AppCompatButton nextPageBt;
    @BindView(R.id.tipBt)
    Button tipBt;
    @BindView(R.id.gridRv)
    RecyclerView gridRv;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
ItemListAdapter adapter = new ItemListAdapter();



    public static MeiziFragment newInstance() {
        Bundle args = new Bundle();
        MeiziFragment fragment = new MeiziFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getDialogRes() {
        return R.layout.dialog_map;
    }

    @Override
    protected int getTitleRes() {
        return R.string.tab_title_meizi;
    }
//图片
    Observer<List<Item>> observer = new Observer<List<Item>>()
    {
        @Override

        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(getActivity(), "数据记载失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(List<Item> images) {
            swipeRefreshLayout.setRefreshing(false);
            pageTv.setText(getString(R.string.page_with_number, page));//增加页数
            adapter.setItems(images);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
    gridRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        gridRv.setAdapter(adapter);
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);
        loadPage(page+1);
        return view;
    }

    private void loadPage(int page){
        swipeRefreshLayout.setRefreshing(true);
        unsubscribe();
        subscription = Network.getGankApi()
                .getBeauties(10,page)
                .map(GankBeautyResultToItemsMapper.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    @OnClick({R.id.previousPageBt, R.id.nextPageBt, R.id.tipBt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.previousPageBt:
                loadPage(--page);
                if(page==1){
                    previousPageBt.setEnabled(false);
                }
                break;
            case R.id.nextPageBt:
                loadPage(++page);
                if(page==2){
                    previousPageBt.setEnabled(true);
                }
                break;
            case R.id.tipBt:
                break;
        }
    }
}
