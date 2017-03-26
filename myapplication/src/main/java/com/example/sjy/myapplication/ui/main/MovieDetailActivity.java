package com.example.sjy.myapplication.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sjy.myapplication.R;
import com.example.sjy.myapplication.bean.MovieDetailBean;
import com.udaye.library.pullloadlibrary.CommonViewHolder;
import com.udaye.library.pullloadlibrary.RecyclerViewCommonAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 这里有个问题是，一直从外面页面跳不进来，原来是要指定这个页面是单例模式
 * Created by sjy_1993 on 2017/3/5.
 */
public class MovieDetailActivity extends BaseActivity {
    private static final String INERNT_KEY_MOVIE_ID = "id";
    @BindView(R.id.tv_title)
    TextView tvTitle;

        @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.appbarlayout)
//    AppBarLayout appbarlayout;
    @BindView(R.id.iv_film)
    ImageView ivFilm;//电影图片
    @BindView(R.id.tv_rating)
    TextView tvRating;//电影评分
    @BindView(R.id.tv_rating_num)
    TextView tvRatingNum;
    @BindView(R.id.tv_film_name)
    TextView tvFilmName;//电影名
    @BindView(R.id.tv_film_desc)
    TextView tv_description;
    @BindView(R.id.tv_date_and_film_time)
    TextView tvDateAndFilmTime;
    @BindView(R.id.tv_film_type)
    TextView tvFilmType;
    @BindView(R.id.tv_film_country)
    TextView tvFilmCountry;
    @BindView(R.id.tv_more_info)
    TextView tvMoreinfo;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

//    @BindView(R.id.iv_cast)
//    ImageView ivCast;
//    @BindView(R.id.tx_cast_name)
//    TextView txCastName;

    private String alt;//此电影豆瓣的连接
//    MovieDetailBean movieDetailBean;//传入的id 1292052


    public static Intent getCalling(Context context, String id) {
        Log.i(TAG, "getCalling: " + id);
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(INERNT_KEY_MOVIE_ID, id);//根据刚刚得到的id传入  去开启详情页
        return intent;//返回这个intent   被其他activity调用内部类
    }

    //得到ID
    private static final String TAG = "MovieDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
//    initActionBar();
        initUI();

    }

    private void initUI() {
//        LinearLayoutManager mLinearManager = new LinearLayoutManager(this);
//        //设置
//      recyclerview.setLayoutManager(mLinearManager);
//        recyclerview.addItemDecoration(new GridMarginDecoration(
//                getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
//        recyclerview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL));

        getMovieDetail(getIntent()); //传递一个intent进入
    }


//    @Override
//    protected void onNewIntent(Intent intent) {
//        getMovieDetail(intent);
//    }

    @Override
   protected void initActionBar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 获取电影资讯详情
     */
    private void getMovieDetail(Intent intent) {
        //1.得到ID这里面是演员的详情
        String movieId = intent.getStringExtra(INERNT_KEY_MOVIE_ID);
        //处理正则字符串的   如果movieId不为空
        if (!TextUtils.isEmpty(movieId)) {
            mRepository.getMovieDetail(Integer.parseInt(movieId))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<MovieDetailBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        //处理逻辑
                        @Override
                        public void onNext(MovieDetailBean movieDetailBean) {
                            //1.判空
                            if (movieDetailBean != null) {
                                //2.缓加载
                                loadBackdrop(movieDetailBean.getImages().getLarge());
                                //强制转换在  后面加一个(float) 转换为float型，本来是double
                                //影片信息
//                                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                                Log.i(TAG, "MovieDetailActivity： onNext " + movieDetailBean.getTitle() + movieDetailBean.getYear() +
                                        movieDetailBean.getCasts());
                                float averageLevel = (float) movieDetailBean.getRating().getAverage();
                                //设置标题
                                //评分人数 平分 电影名
                                tvRating.setText(String.format("%s 分", String.valueOf(averageLevel)));
                                tvFilmName.setText(movieDetailBean.getTitle());
                                tvRatingNum.setText(String.format("%s 人", String.valueOf(movieDetailBean.getRatings_count())));
                                tvDateAndFilmTime.setText(movieDetailBean.getYear());
                                if (movieDetailBean.getCountries() != null && movieDetailBean.getCountries().size() > 0) {

                                    tvFilmCountry.setText(movieDetailBean.getCountries().get(0));
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                for (String s : movieDetailBean.getGenres()) {
                                    stringBuilder.append(s + "/");
                                }
                                tvFilmType.setText(stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1));
                                tvFilmName.setText(movieDetailBean.getOriginal_title() + " [原名]");
                                //国家 年代 名字
                                toolbar.setTitle(movieDetailBean.getTitle());
                                tv_description.setText(movieDetailBean.getSummary());
                                //alt的处理
                                alt = movieDetailBean.getAlt();
//                                 loadBaseInfo(movieDetailBean);
                                //处理这个RecycleView里 的照片了

//                                CelebrityActivity.start(mContext, castsBean.getId());
                             MovieDetailAdapter artAdapter = new MovieDetailAdapter(MovieDetailActivity.this, movieDetailBean.getCasts());

                              recyclerview.setAdapter(artAdapter);
                            }
                        }
                    });
        }

    }

//    Adapter
    private class MovieDetailAdapter extends RecyclerViewCommonAdapter<MovieDetailBean.CastsBean> {


        public MovieDetailAdapter(Context mContext, List<MovieDetailBean.CastsBean> list)  //构造函数可以里面的参数可以改变，重载
        {
            super(mContext, list, R.layout.view_list_casts);
        }

        //1.目的  绑定演员照片跟姓名  用在RecycleView
        @Override
        public void onListBindViewHolder(CommonViewHolder holder, final int position) {
            final MovieDetailBean.CastsBean castsBean = getItem(position);//演员的Id
            if (castsBean != null) {
                if (castsBean.getAvatars() != null) {

                ImageView castImage  = holder.getView(R.id.iv_cast);
                    //加载图片
                  Glide.with(mContext).load(castsBean.getAvatars().getMedium()).placeholder(android.R.color.white).into(castImage);
                } else {
                    //图片为空的话，填充默认图片
                    holder.setImageRes(R.id.iv_cast, R.drawable.default_large);
                }


                holder.setText(R.id.tx_cast_name, castsBean.getName());//设置它的名字  castBean的本身的名字
                Log.i(TAG, "onListBindViewHolder: " + castsBean.getName() + castsBean.getAlt());
//                alt = movieDetailBean.getAlt();//此电影的连接
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRepository != null) {
        }
    }

    //加载图片
    private void loadBackdrop(String url) {
        Glide.with(this).load(url).centerCrop().into(ivFilm);

    }

    @OnClick({R.id.iv_film, R.id.tv_more_info})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_film:
            case R.id.tv_more_info:
                Log.i(TAG, "onClick: "+"点击了" +view.getId()+alt);
            Intent  intent = new Intent(MovieDetailActivity.this,WebViewActivity.class) ;

              intent.putExtra(WebViewActivity.EXTRA_URL,alt);
                startThActivityByIntent(intent);
                break;
        }
    }
}
