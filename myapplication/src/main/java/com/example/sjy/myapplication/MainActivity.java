package com.example.sjy.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.sjy.myapplication.fragment.InTheaterFragment;
import com.example.sjy.myapplication.fragment.MeiziFragment;
import com.example.sjy.myapplication.fragment.OnePhotoFragment;
import com.example.sjy.myapplication.fragment.OneReadingFragment;
import com.example.sjy.myapplication.fragment.Top250Fragment;
import com.example.sjy.myapplication.ui.main.AboutActivity;
import com.example.sjy.myapplication.ui.main.AuthorInfoActivity;
import com.example.sjy.myapplication.ui.main.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout_home;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.tl_channel_tabs) //上边框
    TabLayout mTabLayout;
    @BindView(R.id.vp_channel_pager)
    ViewPager mViewPager;   //滑动viewpager
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }
    private void initUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.hometoolbar);  //顶部导航栏
        //这个方法是设置我们的toolbar作为appbar  不设置的话只相当于一个普通view，一些appbar的特性是支持不了的！
        setSupportActionBar(toolbar);
        //自带 控件
        mTabLayout = (TabLayout) findViewById(R.id.tl_channel_tabs);  //滑动导航条,正在热映，Top250,每日一文
        mViewPager = (ViewPager) findViewById(R.id.vp_channel_pager); //下面的滑动viewpager

       //navigationView.inflateHeaderView(R.layout.nav_header_main);
        View headerView = navigationView.getHeaderView(0);
        //头像
        CircleImageView sdvHeader = (CircleImageView) headerView.findViewById(R.id.sdv_avatar);
        sdvHeader.setImageResource(R.drawable.nav_sufei);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(fragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        // Materal Design自带  右下角的按钮
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //这个类可以方便的将 DrawerLayout，appbar绑定在一起，自动添加一个汉堡按钮，并且打开关闭时带有动画显示
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout_home, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //设置监听器为toggle
        drawerLayout_home.setDrawerListener(toggle);
        //启动绑定！
        toggle.syncState();

        //左侧  导航栏  按钮设置监听（主页，关于,分享 什么之类的）
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //侧边栏的按钮
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            startThActivity(AuthorInfoActivity.class);

        }  else if (id == R.id.nav_gallery) {
            startThActivity(AboutActivity.class);

    } else if (id == R.id.nav_slideshow) {

    } else if (id == R.id.nav_manage) {

    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    }
        //响应完时间之后就关掉自己咯~
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
            return true;
    }

    @Override
    protected void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
        }
    }
    private static class FragmentAdapter extends FragmentStatePagerAdapter {
        private Context context;
        public FragmentAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        //返回对应的标题
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return context.getString(R.string.tab_title_intheaters);//正在热映
                case 1:
                    return context.getString(R.string.tab_title_comming_soon);

                case 2:
                    return context.getString(R.string.tab_title_book);
                case 3:
                    return context.getString(R.string.tab_title_photo);
                case 4:
                    return context.getString(R.string.tab_title_meizi);
                default:
                    return context.getString(R.string.tab_title_intheaters);

            }
        }

        //返回对应的Fragment
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Log.i(TAG, "getItem: 进入了InTheaterFragment");
                   return InTheaterFragment.newInstance();
              case 1:
                return Top250Fragment.newInstance();
             case 2:
                return OneReadingFragment.newInstance();
              case 3:
                 return OnePhotoFragment.newInstance();
                case 4:
                    return MeiziFragment.newInstance();
                default:
                    return InTheaterFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 5;
        }


//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//appbar菜单项 没啥好说的 都知道吧
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    }
}
