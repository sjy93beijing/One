package com.example.sjy.likedouban.Iview.film;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sjy.likedouban.FilmDetailActivity;
import com.example.sjy.likedouban.Presenter.DoubanFilmPresenter;
import com.example.sjy.likedouban.R;
import com.example.sjy.likedouban.adapter.FilmLiveAdapter;
import com.example.sjy.likedouban.base.BaseFragment;
import com.example.sjy.likedouban.base.EasyRecyclerViewAdapter;
import com.example.sjy.likedouban.bean.film.FilmLive;
import com.example.sjy.likedouban.utils.ThemeUtils;
import com.example.sjy.likedouban.widget.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import forezp.com.douyalibrary.utils.ScreenUtils;

/**
 * 实时电影更新直播public FilmLiveFragment(FragmentActivity ) {
        super();
    }
 * Created by sjy_1993 on 2017/2/26.
 */
public class FilmLiveFragment extends BaseFragment implements IGetFilmLiveView,SwipeRefreshLayout.OnRefreshListener {
    private DoubanFilmPresenter doubanFilmPresenter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private FilmLiveAdapter filmLiveAdapter;
    @BindView(R.id.id_swiperefreshlayout)
    SwipeRefreshLayout idSwiperefreshlayout;


//    public FilmLiveFragment(DoubanFilmPresenter doubanFilmPresenter, FilmLiveAdapter filmLiveAdapter) {
//        this.doubanFilmPresenter = doubanFilmPresenter;
//        this.filmLiveAdapter = filmLiveAdapter;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  mView = inflater.inflate(R.layout.fragmentfilm_live,container,false);
        ButterKnife.bind(this,mView);
        return mView;
    }
/**
 *  实时热映的实例
 */

    public static FilmLiveFragment newInstance(){
        Bundle args = new Bundle();
        FilmLiveFragment fragment = new FilmLiveFragment();
        fragment.setArguments(args);//传递这个实例
        return    fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filmLiveAdapter = new FilmLiveAdapter(getActivity());
        doubanFilmPresenter = new DoubanFilmPresenter(getActivity());
        doubanFilmPresenter.getFilmLive(this);
        idSwiperefreshlayout.setColorSchemeColors(ThemeUtils.getThemeColor());
        idSwiperefreshlayout.setOnRefreshListener(this);
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        SpacesItemDecoration spacesItemDecoration=new SpacesItemDecoration(ScreenUtils.dipToPx(getActivity(),10),ScreenUtils.dipToPx(getActivity(),10),ScreenUtils.dipToPx(getActivity(),10),0);
        recyclerview.addItemDecoration(spacesItemDecoration);
        recyclerview.setAdapter(filmLiveAdapter);
    }

    @Override
    protected String setFragmentName() {
        return null;
    }

    @Override
    public boolean hasMultiFragment() {
        return false;
    }

    @Override
    public void getFilmLiveSuccess(FilmLive filmLive) {
        filmLiveAdapter.setDatas(filmLive.getSubjects());//传入得到数据
        filmLiveAdapter.notifyDataSetChanged();
        filmLiveAdapter.setOnItemClickListener(new EasyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, Object data) {
                //设置每个RecycleView 的点击事件
                Intent intent=new Intent(getActivity(),FilmDetailActivity.class);
//                intent.putExtra(FilmDetailActivity.EXTRA_ID,filmLive.getSubjects().get(position).getId());
                startThActivityByIntent(intent);
            }
        });
    }

    @Override
    public void getDataFail() {

    }
    //下拉控件的刷新

    public void onRefresh() {
        doubanFilmPresenter.getFilmLive(this);
        idSwiperefreshlayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (idSwiperefreshlayout != null) {
                    idSwiperefreshlayout.setRefreshing(false);
                }
            }
        },2000);    }


}
