package com.example.sjy.myplane;

/**
 * Created by sjy_1993 on 2017/3/13.
 */
public abstract class FlyingObject {
    public   int x;//
    public   int y;
    public   int width;
    public   int height;
    public   int image;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
 }
}