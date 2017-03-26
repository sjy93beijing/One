package com.example.sjy.likedouban.Iview.film;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sjy.likedouban.R;
import com.example.sjy.likedouban.adapter.MyViewPagerAdapter;
import com.example.sjy.likedouban.base.BaseFragment;
import com.example.sjy.likedouban.utils.ThemeUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sjy_1993 on 2017/2/26.
 */
public class FilmFragment extends BaseFragment implements ViewPager.OnPageChangeListener{
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private ArrayList mFragment;

    @Nullable
    private FilmLiveFragment filmLiveFragment;
    private MyViewPagerAdapter mViewPagerAdapter;
    //在Fragment里绘制界面时，必须回调的方法
    // TabLayout中的tab标题
    private String[] mTitles;
    public static FilmFragment newInstance(){
        Bundle args = new Bundle();
        FilmFragment fragment = new FilmFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  mView = inflater.inflate(R.layout.fragmentfilm,container,false);
        ButterKnife.bind(this,mView);
        return mView;
    }
    //设置view的显示方法
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }
    private void initViews(){
        mTitles = getResources().getStringArray(R.array.tab_film);
        //填充到ViewPager里的两个组合 Fragment
        //list 与ArrayList的区别 List是有序的可重复的集合，集合中每个元素都有其对应的顺序索引。有添加顺序
        //ArrayList是一个动态的数组 ，线程不安全
        mFragment = new ArrayList<>();
        filmLiveFragment = FilmLiveFragment.newInstance();
//        filmTop250Fragment=FilmTop250Fragment.newInstance();
        mFragment.add(filmLiveFragment);
//        mFragment.add(filmTop250Fragment);
    //初始化ViewPager的适配器，并设置给它
        mViewPagerAdapter  = new MyViewPagerAdapter(getChildFragmentManager(),mTitles,mFragment);
        viewPager.setAdapter(mViewPagerAdapter);
        // 设置ViewPager最大缓存的页面个数
        viewPager.setOffscreenPageLimit(3);
        //给ViewPager添加页面动态监听器
        viewPager.addOnPageChangeListener(this);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);;
        tabLayout.setSelectedTabIndicatorColor(ThemeUtils.getThemeColor());
        tabLayout.setTabTextColors(getResources().getColor(R.color.text_gray_6),ThemeUtils.getThemeColor());

        tabLayout.setSelectedTabIndicatorColor(ThemeUtils.getThemeColor());
//        将Tablayout的Tab显示ViewPager进行关联，让两者联动
        tabLayout.setupWithViewPager(viewPager);
//        Tab显示viewPager的适配器中的getPageTitle获取到标题
        tabLayout.setTabsFromPagerAdapter(mViewPagerAdapter);

    }



    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    public void onPageSelected(int position) {

    }


    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean hasMultiFragment() {
        return true;
    }
    @Override
    protected String setFragmentName() {
        return "首页－Fragment";
    }

}
