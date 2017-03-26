package com.example.sjy.myplane;

/**蜜蜂
 * Created by sjy_1993 on 2017/3/13.

 击中蜜蜂可以获得奖励 ，所有要实现Award接口
 */
public class Bee extends FlyingObject implements Arard{
    private int xSpeed = 1;
    private int ySpeed = 2;
    private int awartType;
    @Override
    public int getType() {
        return 0;
    }
}
