package com.example.sjy.picasso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sjy.picasso.adapter.WechatAdapter;
import com.example.sjy.picasso.bean.Wechat;
import com.example.sjy.picasso.utils.OkHttpUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.iv)
    ImageView iv;

    @Bind(R.id.mListView)
    ListView mListView;


    private WechatAdapter adapter;//适配器
    private String url = "";
    private String wechat_url = "http://v.juhe.cn/weixin/query?key=78f723dccf85aea324a3cf0daac97f35";
    private List<Wechat> mList = new ArrayList<>();//初始化这个数组
    private List<String> urlList = new ArrayList<String>();//传递给下一个页面用的链接网址和   标题
    private List<String> titleList = new ArrayList<String>();//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }
    //点击事件

    public void initView() {

        OkHttpUtils okHttp = OkHttpUtils.getInstance();
        okHttp.syncJsonStringByURL(wechat_url, new OkHttpUtils.FuncJsonString() {
            @Override
            public void onResponse(String result) {
                Log.i("json", result);
                getJson(result);
            }
        });
        //此处设置        监听
        mListView.setOnScrollListener(new ListScroller());
        //跳转
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this,WebViewActivity.class);
                i.putExtra("title",titleList.get(position));//标题
                i.putExtra("url",urlList.get(position));//下一个子页的布局网址
                startActivity(i);
            }
        });

    }

//
//    @OnClick(R.id.load)
//    public void load(View view) {
//
//    }

    //解析jSons
    private void getJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonresult = jsonObject.getJSONObject("result");
            JSONArray jArray = jsonresult.getJSONArray("list");//得到JsonArray数组
            for (int i = 0; i < jArray.length(); i++) {
                //得到数组
                JSONObject jb =(JSONObject)jArray.get(i);//遍历第几个数组
                Wechat bean = new Wechat();
                bean.setTitle(jb.getString("title"));//设置标题
                bean.setSource(jb.getString("source"));//来源类型
                bean.setFirstImg(jb.getString("firstImg"));//第一个图片
                bean.setUrl(jb.getString("url"));//详情链接

                //存起来
                mList.add(bean);
                //存起来
                urlList.add(jb.getString("url"));
                titleList.add(jb.getString("title"));
                Log.i("title",jb.getString("title"));
                Log.i("source",jb.getString("source"));
            }
            //设置adapter  跟谁绑定
            adapter = new WechatAdapter(this,mList);
            mListView.setAdapter(adapter);//把数据放到ListView里面

        } catch (JSONException e) {
            e.printStackTrace();

        }
    }
    /**
     * 滚动监听  监听它 的回调
     */
    public class ListScroller implements AbsListView.OnScrollListener{

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            final Picasso picasso = Picasso.with(MainActivity.this);
            if (scrollState == SCROLL_STATE_IDLE || scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                //重置
//                picasso.resumeTag(MainActivity.this);
            } else {
                //暂停
//                picasso.pauseTag(MainActivity.this);
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    }


}