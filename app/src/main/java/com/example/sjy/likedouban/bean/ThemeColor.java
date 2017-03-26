package com.example.sjy.likedouban.bean;

/**
 * 颜色选择的状态实体类
 * 被选中的状态。
 * Created by sjy_1993 on 2017/3/1.
 */

public class ThemeColor {
    int color;
    boolean isChosen = false;

    public ThemeColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }
}
