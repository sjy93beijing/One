package com.example.sjy.myapplication.One.Bean;

import java.util.List;

/**
 * Created by sjy_1993 on 2017/3/23.
 */
public class PhotoList {

    /**
     * res : 0
     * data : ["1656","1655","1654","1653","1651","1652","1650","1649","1648","1647"]
     */

    private int res;
    private List<String> data;

    public void setRes(int res) {
        this.res = res;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getRes() {
        return res;
    }

    public List<String> getData() {
        return data;
    }
}
