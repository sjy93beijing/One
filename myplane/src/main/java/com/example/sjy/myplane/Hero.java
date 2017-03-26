package com.example.sjy.myplane;

/**
 * Created by sjy_1993 on 2017/3/13.
 */
public class Hero extends FlyingObject{
    //双倍子弹数量，命的数量
    protected int index = 0;

    private int doubleFire;
    private int life;

    public Hero(){
        life = 3;
        doubleFire = 0;


    }
}
