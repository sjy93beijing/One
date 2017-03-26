package com.example.sjy.myplane.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.sjy.myplane.R;

import java.util.ArrayList;

/**
 * Created by sjy_1993 on 2017/3/13.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback,Runnable{


    private SurfaceHolder mSurfaceHolder;//显示一个surface的抽象接口，使你可以控制surface的大小和格式， 以及在surface上编辑像素，和监视surace的改变。这个接口通常通过SurfaceView类实现。
    private Paint mPaint;
    private int mBackgroundColor;

    //对象

    private Bitmap mPlaneBitmap;//飞机
    private Bitmap mEnemyBitmap;//敌机
    private Bitmap mBullet;//子弹
    private ArrayList<Cloud> mCloudList;
    private ArrayList<Bitmap> mCloudBitmapList;//  云朵的动态数组
    //构造函数
    public GameView(Context context, AttributeSet attrs) {
    super(context,attrs);
    mSurfaceHolder = this.getHolder();
        mSurfaceHolder.addCallback(this);
        mPaint = new Paint();
      //  mBack

    }
    //初始化图像界面
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Bitmap mCloud1 = BitmapFactory.decodeResource(getResources(), R.drawable.cloud1);
        Bitmap mCloud2 = BitmapFactory.decodeResource(getResources(), R.drawable.cloud2);
        Bitmap mCloud3 = BitmapFactory.decodeResource(getResources(), R.drawable.cloud3);
        mCloudBitmapList = new ArrayList<>(3);
        mCloudBitmapList.add(mCloud1);
        mCloudBitmapList.add(mCloud2);
        mCloudBitmapList.add(mCloud3);
//        mPlaneBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.plane);
//        mEnemyBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.enemy);
//        mBullet = BitmapFactory.decodeResource(getResources(),R.drawable.bullet);
//        mPlaneBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.plane);

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void run() {

    }

   public void drawBackground(Canvas canvas){
       canvas.drawColor(mBackgroundColor);
       canvas.save();
       for (int i=0;i<mCloudBitmapList.size();i++){
           canvas.drawBitmap(mCloudBitmapList.get(i % 3),
                   mCloudList.get(i).x,mCloudList.get(i).y,mPaint);
           Cloud cloud = mCloudList.get(i);
           cloud.y+= cloud.speed;
           if(cloud.y>=getHeight()){
               //超界了


           }


       }
   }
}
