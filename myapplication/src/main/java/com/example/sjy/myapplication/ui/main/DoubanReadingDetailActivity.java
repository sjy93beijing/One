package com.example.sjy.myapplication.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.sjy.myapplication.One.Bean.ReadingDetail;
import com.example.sjy.myapplication.R;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 *
 * Created by sjy_1993 on 2017/3/23.
 */
public class DoubanReadingDetailActivity extends BaseActivity {
    private static final String INERNT_KEY_MOVIE_ID = "content_id";
    private static final String TAG = "DoubanReading";
    private TextView title;
    private TextView author;
    private TextView lasttime;
    private TextView text;
    private ScrollView scrollView;
    //    private CardView cardView;
    @Override
    protected void initActionBar() {

    }

    public static Intent getCalling(Context context, String id) {
        Log.i(TAG, "getCalling: " + id);
        Intent intent = new Intent(context, DoubanReadingDetailActivity.class);
        intent.putExtra(INERNT_KEY_MOVIE_ID, id);//根据刚刚得到的id传入  去开启详情页
        return intent;//返回这个intent   被其他activity调用内部类
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_detail);
        Log.i(TAG, "onCreate: 进入了读书详情页————————————————————");
        initUI();
    }

    private void initUI() {
        title = (TextView) findViewById(R.id.re_title);
        author = (TextView) findViewById(R.id.re_author_desc);
        lasttime = (TextView) findViewById(R.id.re_lasttime);
        scrollView = (ScrollView) findViewById(R.id.re_scrollView);
        text = (TextView) findViewById(R.id.text1) ;
//        cardView = (CardView) findViewById(R.id.re_content);
        getReadingDetail(getIntent()); //传递一个intent进入
        Log.i(TAG, "initUI: ");
    }

    private void getReadingDetail(Intent intent) {
        String content_id = intent.getStringExtra(INERNT_KEY_MOVIE_ID);
        Log.i(TAG, "getMovieDetail: "+content_id);
        if (!TextUtils.isEmpty(content_id)) {
            //得到id   string 转换为int
            mOneRepository.getReadingDetail(Integer.parseInt(content_id))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ReadingDetail>() {
                        @Override
                        public void onCompleted() {
                            Log.i(TAG, "onCompleted: ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.i(TAG, "onError: ");
                        }

                        @Override
                        public void onNext(ReadingDetail readingDetaildata) {
                            ReadingDetail.DataEntity dataEntity = readingDetaildata.getData();
                            Log.i(TAG, "onNext: "+dataEntity.getHp_title());
                            if (dataEntity != null) {
                                Log.i(TAG, "onNext: " + dataEntity.getHp_content() + "名字：" + dataEntity.getHp_title());
                                //打印

                                                    //标题
                                title.setText(dataEntity.getHp_title());
                                lasttime.setText(dataEntity.getLast_update_date());
                                author.setText(dataEntity.getHp_author());
                                text.setText(dataEntity.getHp_content());
//                                scrollView.setTextDirection(dataEntity.getHp_content());
//                            cardView.setTextDirection();
                            }
                        }
                    });

        }

    }
}

