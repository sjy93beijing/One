package com.example.sjy.picasso.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sjy.picasso.R;
import com.example.sjy.picasso.bean.Wechat;
import com.example.sjy.picasso.utils.PicassoUtils;

import java.util.List;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class WechatAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Wechat> mList;
    private Wechat bean;

    public WechatAdapter(Context mContext, List<Wechat> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    //用来刷新它所在的RecycleView ，在item从屏幕外滑进屏幕内的时候，或者程序刚开始的时候创建第一屏item被调用
    // parent:List  convertView :可重用的视图   position：位置，getItem得到
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//      View view = convertView;

        ViewHoldwe vHoldwe = null;
        if(convertView==null){
            vHoldwe = new ViewHoldwe();
            convertView = inflater.inflate(R.layout.wechatist_item, null);
            vHoldwe.iv_url = (ImageView) convertView
                    .findViewById(R.id.iv_url);//图片资源
            vHoldwe.tv_title = (TextView) convertView
                    .findViewById(R.id.tv_title);
            vHoldwe.tv_type = (TextView) convertView.findViewById(R.id.tv_type);
            convertView.setTag(vHoldwe);
        } else {
            vHoldwe = (ViewHoldwe) convertView.getTag();
        }

        bean = mList.get(position);
        vHoldwe.tv_title.setText(bean.getTitle());//给他设置。从bean里得到标题
        vHoldwe.tv_type.setText(bean.getSource());//来源类型

        if(!TextUtils.isEmpty(bean.getUrl())){
            PicassoUtils.loadImageViewSize(mContext, bean.getFirstImg(),250,200, vHoldwe.iv_url);
        }else{
            vHoldwe.iv_url.setImageResource(R.mipmap.ic_launcher);
        }
        return convertView;
//        return view;
    }

    //自己创建的ViewHolder
    class ViewHoldwe{
        private ImageView iv_url;//图片url
        private TextView tv_title;//标题
        private TextView tv_type;//新闻类型
    }

}
