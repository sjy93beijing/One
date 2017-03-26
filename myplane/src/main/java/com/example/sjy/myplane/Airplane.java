package com.example.sjy.myplane;

/**敌飞机
 * Created by sjy_1993 on 2017/3/13.
 */
public class Airplane extends FlyingObject implements Enemy{
    private int speed = 2;
   //获取分数
    @Override
    public int getScore() {
        return 0;
    }


}
