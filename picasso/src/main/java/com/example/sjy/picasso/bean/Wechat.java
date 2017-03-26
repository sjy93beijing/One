package com.example.sjy.picasso.bean;

/**
 * Created by sjy_1993 on 2017/2/28.
 */
public class Wechat {
   private String url;//连接
   private String title;//
   private String source;//类型
   private String type;//类型
   private String firstImg;

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String toString() {
        return "WechatBean [url=" + url + ", title=" + title + ", type=" + type+"firstImg"+firstImg
                + "]";
    }
}
