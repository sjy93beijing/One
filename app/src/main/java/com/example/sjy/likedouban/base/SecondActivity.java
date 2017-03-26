package com.example.sjy.likedouban.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.sjy.likedouban.R;
import com.example.sjy.likedouban.bean.MovieEntity;
import com.example.sjy.likedouban.service.MovieService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sjy_1993 on 2017/2/24.
 */
public class SecondActivity extends AppCompatActivity{

    @BindView(R.id.click_me_BN)
    Button clickMeBN;
    @BindView(R.id.result_TV)
    TextView resultTV;
   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ButterKnife.bind(this);
    }
    @OnClick(R.id.click_me_BN)
    public  void onClick(){
        getMovie();
    }
    //进行网络请求
    private void getMovie(){
        String baseUrl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    //回调
        MovieService movieService = retrofit.create(MovieService.class);
        Call<MovieEntity> call = movieService.getTopMovie(0,10);//开始0  到总共多少行
   //异步的方式
    call.enqueue(new Callback<MovieEntity>() {
        @Override
        public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
            resultTV.setText(response.body().toString());
        }

        @Override
        public void onFailure(Call<MovieEntity> call, Throwable t) {
            resultTV.setText(t.getMessage());
        }
    });
    }
}
