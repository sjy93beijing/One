package com.example.sjy.myapplication.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sjy.myapplication.One.Bean.PhotoDetail;
import com.example.sjy.myapplication.One.Bean.PhotoList;
import com.example.sjy.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sjy_1993 on 2017/3/23.
 */
public class OnePhotoFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "OnePhotoFragment";
    private SwipeRefreshLayout swiprefresh;
    private RecyclerView recycleView;
    TextView text_content;
    TextView text_title;
    TextView text_author;
    TextView text_vol;

     List<String> data =new ArrayList<>();
    List<String> mdata = new ArrayList<String>();
    ImageView imageView;
    private int mPage = 0;
    private Button btn;
    //初始化
    public static OnePhotoFragment newInstance() {
        Bundle args = new Bundle();
        OnePhotoFragment fragment = new OnePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_photo, null);
        //下拉框
        swiprefresh = (SwipeRefreshLayout) view.findViewById(R.id.photo_refresh_layout);
//        recycleView = (RecyclerView) view.findViewById(R.id.recyclerview);
        swiprefresh.setColorSchemeResources(R.color.colorPrimary);
//        btn = (Button) view.findViewById(R.id.btn_photo);
        text_content = (TextView) view.findViewById(R.id.photo_content);
        text_author= (TextView) view.findViewById(R.id.photo_author);
//        text_title = (TextView) view.findViewById(R.id.photo_title);
        text_vol = (TextView) view.findViewById(R.id.photo_vol);
        imageView = (ImageView) view.findViewById(R.id.imageView);//照片
       swiprefresh.setOnRefreshListener(this);

        Log.i(TAG, "onCreateView: ******");

        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        LinearLayoutManager mLinearManager = new LinearLayoutManager(getActivity());
//        //设置
//        recycleView.setLayoutManager(mLinearManager);
//        recycleView.addItemDecoration(new GridMarginDecoration(
//        getResources().getDimensionPixelSize(R.dimen.grid_item_spacing)));
//        recycleView.setHasFixedSize(true);
        requestReadingData();


    }

    //得到这个图片阅读列表
    private void requestReadingData() {
        Log.i(TAG, "requestReadingData: ");
        mOneReposity.getPhotoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PhotoList>() {
                    @Override
                    public void onCompleted() {
                    swiprefresh.setRefreshing(false);
                        Toast.makeText(getActivity(),"获取最新数据完毕",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        swiprefresh.setRefreshing(false);
                        Toast.makeText(getActivity(),"网络出错",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNext(PhotoList photoList) {
                    if(photoList.getData()!=null){
                        mdata = photoList.getData();
                        Log.i(TAG, "OnePhoto   *** onNext: "+mdata);
                        //随机得到图片
                      final int m = (int) (Math.random() * mdata.size());
                         requestReadingDetailData(mdata.get(m));
                //每次选第一个
//                        btn.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                //往前加
//
//
//                                if (m==0||m==mdata.size()) {
//
//                                    requestReadingDetailData(mdata.get(m));
//                                    mPage++;
//                                }
//                                else {
//                                    requestReadingDetailData(mdata.get(mPage++));
//                                    Toast.makeText(getActivity(),"已经到头了",Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
                        //得到最新的
                    }
                    }
                });
    }

    //阅读详细
    private void requestReadingDetailData(String data) {
//       int  i  = (int) Math.random()*mdata.size();
//        Log.i(TAG, "requestReadingDetailData: "+i);
        mOneReposity.getPhotoDetail(Integer.parseInt(data))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PhotoDetail>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(PhotoDetail photoDetail) {
                        loadBackdrop(photoDetail.getData().getHp_img_url());
                        Log.i(TAG, "onNext: 图片网址"+photoDetail.getData().getHp_img_url());
                   if(photoDetail!=null){

                     PhotoDetail.DataEntity  mdataDetail = photoDetail.getData();

                       Log.i(TAG, "onNext:请求网址链接"+mdataDetail.getHp_img_url());
                       Log.i(TAG, "onNext: 请求的内容"+mdataDetail.getHp_content());

                         text_content.setText(mdataDetail.getHp_content());
//                       text_title.setText(mdataDetail.getHp_title());
                       text_vol.setText(mdataDetail.getHp_title());
                       text_author.setText("本图By"+mdataDetail.getImage_authors()+mdataDetail.getImage_from());
                            Log.i(TAG, "onNext: "+ mdataDetail);



                        }
                    }
                });
    }
    private void loadBackdrop(String url) {
        Glide.with(this).load(url).centerCrop().into(imageView);

    }
    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(),"正在刷新",Toast.LENGTH_SHORT).show();
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 final int m = (int) (Math.random() * mdata.size());
                 requestReadingDetailData(mdata.get(m));
                 Toast.makeText(getActivity(),"刷新完成",Toast.LENGTH_SHORT).show();

                 swiprefresh.setRefreshing(false);
             }
         },2000);



    }
}
