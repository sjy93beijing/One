package com.example.sjy.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sjy.myapplication.R;

/**
 * Created by sjy_1993 on 2017/3/15.
 */
public class TheOneFragment extends Fragment{


    public static TheOneFragment newInstance() {
        Bundle args = new Bundle();
       TheOneFragment fragment = new TheOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book,container,false);
    initView();
        return view;
    }
    private void initView() {


    }


}