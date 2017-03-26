package com.example.sjy.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.sjy.myapplication.One.OneRetrofitRepository;
import com.example.sjy.myapplication.data.retrofit.RetrofitRepository;

/**
 * Created by sjy_1993 on 2017/3/5.
 */
public class BaseFragment extends Fragment{
    RetrofitRepository mRepository;//  仓库 向上层屏蔽了数据来源和内部实现细节

    OneRetrofitRepository mOneReposity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = RetrofitRepository.getInstance(getActivity());
        mOneReposity = OneRetrofitRepository.getInstance(getActivity());
    }


}
