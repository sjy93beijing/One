package com.example.sjy.myapplication.One.Bean;

import java.util.List;

/**
 * Created by sjy_1993 on 2017/3/23.
 */
public class IdListBean {
/*
{
    "res": 0,
    "data": [
        "3528",
        "3520",
        "3519",
        "3517",
        "3516",
        "3515",
        "3514",
        "3513",
        "3476",
        "3505"
    ]
}
 */
    private int res;
    private List<String> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
