package com.example.sjy.likedouban;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import com.example.sjy.likedouban.Iview.film.FilmFragment;
import com.example.sjy.likedouban.Iview.film.IgetTop250View;
import com.example.sjy.likedouban.adapter.ThemeColorAdapter;
import com.example.sjy.likedouban.base.ActivityCollector;
import com.example.sjy.likedouban.base.BaseActivity;
import com.example.sjy.likedouban.base.EasyRecyclerViewAdapter;
import com.example.sjy.likedouban.base.SecondActivity;
import com.example.sjy.likedouban.bean.ThemeColor;
import com.example.sjy.likedouban.bean.top250.Root;
import com.example.sjy.likedouban.other.AboutActivity;
import com.example.sjy.likedouban.utils.ThemeUtils;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity
        implements IgetTop250View{
//    @BindView(R.id.drawerlayout_home)
//    DrawerLayout drawerlayoutHome;
protected   DrawerLayout   drawerlayoutHome;
//    @BindView(R.id.viewpager)
  private ViewPager viewpager;
//    @BindView(R.id.toolbar)
   private Toolbar toolbar;//ActionBar
//    @BindView(R.id.radiogroup)
   private RadioGroup radioGroup;
//    @BindView(R.id.appbarlayout)
   private AppBarLayout appBarLayout;
//    @BindView(R.id.coordinatorlayout)
   private CoordinatorLayout coordinatorlayout;

//    @BindView(R.id.nav_view)//左侧导航栏
  private   NavigationView navigationView;
    private List<Fragment> listFragment;
    private FilmFragment filmFragment;
    private int currentFragment;//标记这个数字
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
        drawerlayoutHome = (DrawerLayout) findViewById(R.id.drawerlayout_home);
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(MainActivity.this,drawerlayoutHome, ThemeUtils.getThemeColor());

        initView();
        initOther();
        initListener();
        initChangeTheme();
    }

private void initUI(){
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
         appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);
    coordinatorlayout  = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
     navigationView =(NavigationView) findViewById(R.id.nav_view);
}

    //监听器
    private void initListener(){
        //上方的radioButton的监听器
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.rb_home:
                    currentFragment = 0;//标记
                break;
                case R.id.rb_dynamic:
                    currentFragment = 1;
                    break;
                case R.id.rb_message:
                    currentFragment=2;
                    break;
            }
            //通知viewPager 根据不同的标记返回不同的视图
            viewpager.setCurrentItem(currentFragment,false);
        }
    });

        //viewPager可以随时跟上不同的
        viewpager.setAdapter(new FragmentPagerAdapter(
                getSupportFragmentManager()) {
            @Override
            //多少个Fragment
            public Fragment getItem(int position) {
                return listFragment.get(position);
            }

            @Override
            public int getCount() {
                return listFragment.size();
            }
        });
    }



    private void initView(){
//     toolbar = (Toolbar) findViewById(R.id.toolbar);//左侧按钮
//        setSupportActionBar(toolbar);
      toolbar.setBackgroundColor(ThemeUtils.getToolBarColor());//获取数据的颜色

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerlayoutHome, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawerlayoutHome.setDrawerListener(toggle);

    //     DrawerLayout  drawerlayoutHome = (DrawerLayout) findViewById(R.id.drawerlayout_home);
        //左边的滑动开关 控制抽屉开闭
        //底部的浮动框
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                Snackbar.make(view, "取代你的活动", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //抽屉布局

        //   以上是          抽屉开关的动作
        //侧滑栏的头部
        navigationView.inflateHeaderView(R.layout.header_nav);
        View headerView =   navigationView.getHeaderView(0);//头像布局
        CircleImageView sdvHeader = (CircleImageView) headerView.findViewById(R.id.sdv_avatar);//设定圆角头像
        sdvHeader.setImageResource(R.drawable.ic_avtar);//头像信息
//        viewpager =(ViewPager) findViewById(R.id.viewpager);
//         NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);//左侧抽屉导航栏
      //左侧导航栏
        navigationView.inflateMenu(R.menu.activity_main_drawer);//引入菜单栏
//        idNavigationview.setNavigationItemSelectedListener(this);//绑定监听器
    //自己定义的点击事件         设置它的点击事件
        navigationView.setItemIconTintList(ThemeUtils.getNaviItemIconTinkList());
        // 自己写的方法，设置NavigationView中menu的item被选中后要执行的操作
        onNavgationViewMenuItemSelected(navigationView);
        //给NavigationView填充顶部区域，也可在xml中使用app:headerLayout="@layout/header_nav"来设置

}



    private void initOther(){
        filmFragment= FilmFragment.newInstance();//初始化FilemFragment
//        bookFragment=BookFragment.newInstance();
//        musicFragment=MusicFragment.newInstance();
        listFragment=new ArrayList<>();
        listFragment.add(filmFragment);
//        listFragment.add(bookFragment);
//        listFragment.add(musicFragment);
        viewpager.setOffscreenPageLimit(3);//设置ViePager几页
        viewpager.setOnPageChangeListener(onPageChangeListener);//设置监听器 ，匿名内部类

    }
    //根据不同的滑动点击，RadioButton对应跳转到不同的位置
    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    radioGroup.check(R.id.rb_home);
                    break;
                case 1:
                    radioGroup.check(R.id.rb_dynamic);
                    break;
                case 2:
                    radioGroup.check(R.id.rb_message);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    //左侧的按钮toorBar  切换回抽屉布局
    @Override
    public void onBackPressed() {
        drawerlayoutHome = (DrawerLayout) findViewById(R.id.drawerlayout_home);
        if (drawerlayoutHome.isDrawerOpen(GravityCompat.START)) {
            drawerlayoutHome.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //右侧设置
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置NavigationView中menu的item被选中后要执行的操作
     * @param
     * @return
     */
    //左侧导航栏
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_theme) {
//            //更换主题
//            //获取到ViewPager
//            //初始化主题色框
//            //弹出dialog                                                      对话框是一个RecycleView且是GridView类型
//            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_theme_color, null, false);
////            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.theme_recycler_view);
//            //改成用注解的方式
//            theme_recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
//            theme_recyclerView.setAdapter(themeColorAdapter);
//            //设置弹出框
//            android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("主题选择")
//                    .setView(view)
//                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int i) {
//                            ThemeUtils.setThemeColor(getResources().getColor(themeColorList.get(themeColorAdapter.getPosition()).getColor()));// 不要变换位置
//                            ThemeUtils.setThemePosition(themeColorAdapter.getPosition());
//                            new Handler().postDelayed(new Runnable() {
//                                public void run() {
//                                    ActivityCollector.getInstance().refreshAllActivity();//刷新所有的线程
//
//                                }
//                            }, 100);
//                        }
//                    })
//                    .show();
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout_home);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    private void onNavgationViewMenuItemSelected(NavigationView mNav) {
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nav_camera:
//                        startThActivity(AuthorInfoActivity.class);
                        break;
                    case R.id.nav_gallery:
                        startThActivity(AboutActivity.class);

                        break;

                    case R.id.nav_send:
//                        startThActivity(RecommedActivity.class);
                        break;
                    case R.id.nav_share:

                        break;
                    case R.id.nav_slideshow:

                        // startThActivityByIntent(new Intent(MainActivity.this, SettingActivity.class));
                        break;

                    case R.id.nav_theme:

                        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_theme_color, null, false);
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.theme_recycler_view);
                        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
                        recyclerView.setAdapter(themeColorAdapter);
                        android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("主题选择")
                                .setView(view)
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ThemeUtils.setThemeColor( getResources().getColor(themeColorList.get(themeColorAdapter.getPosition()).getColor()));// 不要变换位置
                                        ThemeUtils.setThemePosition(themeColorAdapter.getPosition());
                                        // finish();
                                        new Handler().postDelayed(new Runnable() {
                                            public void run() {
                                                ActivityCollector.getInstance().refreshAllActivity();
                                                // closeHandler.sendEmptyMessageDelayed(MSG_CLOSE_ACTIVITY, 300);
                                            }
                                        }, 100);
                                    }
                                })
                                .show();

                        break;
                }
                // Menu item点击后选中，并关闭Drawerlayout
                menuItem.setChecked(true);
                //drawerlayoutHome.closeDrawers();
                // Toast.makeText(MainActivity.this,msgString,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    private ArrayList<ThemeColor> themeColorList = new ArrayList<>();//存储颜色的数组列表
    private ThemeColorAdapter themeColorAdapter = new ThemeColorAdapter();

    private void initChangeTheme(){
        themeColorAdapter = new ThemeColorAdapter();
        //添加颜色
        themeColorList.add(new ThemeColor(R.color.red_back));
        themeColorList.add(new ThemeColor(R.color.blue_back));
        themeColorList.add(new ThemeColor(R.color.yellow_back));
        //添加颜色Adapter
        themeColorAdapter.setDatas(themeColorList);
        //设置监听事件
        themeColorAdapter.setOnItemClickListener(new EasyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, Object data) {
                //得到所选的颜色   遍历themeColorList里的集合，得到所选的设置为TRUE ，然后更新adapter事件
                for(ThemeColor  themeColor:themeColorList){
                    themeColor.setChosen(false);//把颜色全都置为false
                }
                themeColorList.get(position).setChosen(true);
                themeColorAdapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void getTop250Success(Root root, boolean isLoadMore) {

    }

    @Override
    public void getDataFail() {

    }

    @Override
    public String setActName() {
        return null;
    }
}
