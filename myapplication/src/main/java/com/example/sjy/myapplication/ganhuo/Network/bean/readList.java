package com.example.sjy.myapplication.ganhuo.Network.bean;

import java.util.List;
/**
 * Created by sjy_1993 on 2017/3/15.
 */
public class readList {

    public class Author
    {
        private String desc;

        private String fans_total;

        private String is_settled;

        private String settled_type;

        private String summary;

        private String user_id;

        private String user_name;

        private String wb_name;

        private String web_url;

        public void setDesc(String desc){
            this.desc = desc;
        }
        public String getDesc(){
            return this.desc;
        }
        public void setFans_total(String fans_total){
            this.fans_total = fans_total;
        }
        public String getFans_total(){
            return this.fans_total;
        }
        public void setIs_settled(String is_settled){
            this.is_settled = is_settled;
        }
        public String getIs_settled(){
            return this.is_settled;
        }
        public void setSettled_type(String settled_type){
            this.settled_type = settled_type;
        }
        public String getSettled_type(){
            return this.settled_type;
        }
        public void setSummary(String summary){
            this.summary = summary;
        }
        public String getSummary(){
            return this.summary;
        }
        public void setUser_id(String user_id){
            this.user_id = user_id;
        }
        public String getUser_id(){
            return this.user_id;
        }
        public void setUser_name(String user_name){
            this.user_name = user_name;
        }
        public String getUser_name(){
            return this.user_name;
        }
        public void setWb_name(String wb_name){
            this.wb_name = wb_name;
        }
        public String getWb_name(){
            return this.wb_name;
        }
        public void setWeb_url(String web_url){
            this.web_url = web_url;
        }
        public String getWeb_url(){
            return this.web_url;
        }
    }

    public class Share_info
    {
        private String content;

        private String image;

        private String title;

        private String url;

        public void setContent(String content){
            this.content = content;
        }
        public String getContent(){
            return this.content;
        }
        public void setImage(String image){
            this.image = image;
        }
        public String getImage(){
            return this.image;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setUrl(String url){
            this.url = url;
        }
        public String getUrl(){
            return this.url;
        }
    }


    public class Qq
    {
        private String desc;

        private String imgUrl;

        private String link;

        private String title;

        public void setDesc(String desc){
            this.desc = desc;
        }
        public String getDesc(){
            return this.desc;
        }
        public void setImgUrl(String imgUrl){
            this.imgUrl = imgUrl;
        }
        public String getImgUrl(){
            return this.imgUrl;
        }
        public void setLink(String link){
            this.link = link;
        }
        public String getLink(){
            return this.link;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
    }

    public class Weibo
    {
        private String desc;

        private String imgUrl;

        private String link;

        private String title;

        public void setDesc(String desc){
            this.desc = desc;
        }
        public String getDesc(){
            return this.desc;
        }
        public void setImgUrl(String imgUrl){
            this.imgUrl = imgUrl;
        }
        public String getImgUrl(){
            return this.imgUrl;
        }
        public void setLink(String link){
            this.link = link;
        }
        public String getLink(){
            return this.link;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
    }


    public class Wx
    {
        private String desc;

        private String imgUrl;

        private String link;

        private String title;

        public void setDesc(String desc){
            this.desc = desc;
        }
        public String getDesc(){
            return this.desc;
        }
        public void setImgUrl(String imgUrl){
            this.imgUrl = imgUrl;
        }
        public String getImgUrl(){
            return this.imgUrl;
        }
        public void setLink(String link){
            this.link = link;
        }
        public String getLink(){
            return this.link;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
    }

    public class Share_list
    {
        private Qq qq;

        private Weibo weibo;

        private Wx wx;

        public void setQq(Qq qq){
            this.qq = qq;
        }
        public Qq getQq(){
            return this.qq;
        }
        public void setWeibo(Weibo weibo){
            this.weibo = weibo;
        }
        public Weibo getWeibo(){
            return this.weibo;
        }
        public void setWx(Wx wx){
            this.wx = wx;
        }
        public Wx getWx(){
            return this.wx;
        }
    }


    public class Data
    {
        private String ad_closetime;

        private int ad_id;

        private String ad_linkurl;

        private String ad_makettime;

        private String ad_pvurl;

        private String ad_pvurl_vendor;

        private String ad_share_cnt;

        private int ad_type;

        private int audio_platform;

        private String audio_url;

        private Author author;

        private String category;

        private String content_bgcolor;

        private String content_id;

        private String content_type;

        private int display_category;

        private String forward;

        private String id;

        private String img_url;

        private String item_id;

        private DateTime last_update_date;

        private int like_count;

        private int movie_story_id;

        private int number;

        private String pic_info;

        private DateTime post_date;

        private int serial_id;

        private List<String> serial_list;

        private Share_info share_info;

        private Share_list share_list;

        private String share_url;

        private String start_video;

        private String subtitle;

        private List<String> tag_list;

        private String title;

        private String video_url;

        private int volume;

        private String words_info;

        public void setAd_closetime(String ad_closetime){
            this.ad_closetime = ad_closetime;
        }
        public String getAd_closetime(){
            return this.ad_closetime;
        }
        public void setAd_id(int ad_id){
            this.ad_id = ad_id;
        }
        public int getAd_id(){
            return this.ad_id;
        }
        public void setAd_linkurl(String ad_linkurl){
            this.ad_linkurl = ad_linkurl;
        }
        public String getAd_linkurl(){
            return this.ad_linkurl;
        }
        public void setAd_makettime(String ad_makettime){
            this.ad_makettime = ad_makettime;
        }
        public String getAd_makettime(){
            return this.ad_makettime;
        }
        public void setAd_pvurl(String ad_pvurl){
            this.ad_pvurl = ad_pvurl;
        }
        public String getAd_pvurl(){
            return this.ad_pvurl;
        }
        public void setAd_pvurl_vendor(String ad_pvurl_vendor){
            this.ad_pvurl_vendor = ad_pvurl_vendor;
        }
        public String getAd_pvurl_vendor(){
            return this.ad_pvurl_vendor;
        }
        public void setAd_share_cnt(String ad_share_cnt){
            this.ad_share_cnt = ad_share_cnt;
        }
        public String getAd_share_cnt(){
            return this.ad_share_cnt;
        }
        public void setAd_type(int ad_type){
            this.ad_type = ad_type;
        }
        public int getAd_type(){
            return this.ad_type;
        }
        public void setAudio_platform(int audio_platform){
            this.audio_platform = audio_platform;
        }
        public int getAudio_platform(){
            return this.audio_platform;
        }
        public void setAudio_url(String audio_url){
            this.audio_url = audio_url;
        }
        public String getAudio_url(){
            return this.audio_url;
        }
        public void setAuthor(Author author){
            this.author = author;
        }
        public Author getAuthor(){
            return this.author;
        }
        public void setCategory(String category){
            this.category = category;
        }
        public String getCategory(){
            return this.category;
        }
        public void setContent_bgcolor(String content_bgcolor){
            this.content_bgcolor = content_bgcolor;
        }
        public String getContent_bgcolor(){
            return this.content_bgcolor;
        }
        public void setContent_id(String content_id){
            this.content_id = content_id;
        }
        public String getContent_id(){
            return this.content_id;
        }
        public void setContent_type(String content_type){
            this.content_type = content_type;
        }
        public String getContent_type(){
            return this.content_type;
        }
        public void setDisplay_category(int display_category){
            this.display_category = display_category;
        }
        public int getDisplay_category(){
            return this.display_category;
        }
        public void setForward(String forward){
            this.forward = forward;
        }
        public String getForward(){
            return this.forward;
        }
        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return this.id;
        }
        public void setImg_url(String img_url){
            this.img_url = img_url;
        }
        public String getImg_url(){
            return this.img_url;
        }
        public void setItem_id(String item_id){
            this.item_id = item_id;
        }
        public String getItem_id(){
            return this.item_id;
        }
        public void setLast_update_date(DateTime last_update_date){
            this.last_update_date = last_update_date;
        }
        public DateTime getLast_update_date(){
            return this.last_update_date;
        }
        public void setLike_count(int like_count){
            this.like_count = like_count;
        }
        public int getLike_count(){
            return this.like_count;
        }
        public void setMovie_story_id(int movie_story_id){
            this.movie_story_id = movie_story_id;
        }
        public int getMovie_story_id(){
            return this.movie_story_id;
        }
        public void setNumber(int number){
            this.number = number;
        }
        public int getNumber(){
            return this.number;
        }
        public void setPic_info(String pic_info){
            this.pic_info = pic_info;
        }
        public String getPic_info(){
            return this.pic_info;
        }
        public void setPost_date(DateTime post_date){
            this.post_date = post_date;
        }
        public DateTime getPost_date(){
            return this.post_date;
        }
        public void setSerial_id(int serial_id){
            this.serial_id = serial_id;
        }
        public int getSerial_id(){
            return this.serial_id;
        }
        public void setSerial_list(List<String> serial_list){
            this.serial_list = serial_list;
        }
        public List<String> getSerial_list(){
            return this.serial_list;
        }
        public void setShare_info(Share_info share_info){
            this.share_info = share_info;
        }
        public Share_info getShare_info(){
            return this.share_info;
        }
        public void setShare_list(Share_list share_list){
            this.share_list = share_list;
        }
        public Share_list getShare_list(){
            return this.share_list;
        }
        public void setShare_url(String share_url){
            this.share_url = share_url;
        }
        public String getShare_url(){
            return this.share_url;
        }
        public void setStart_video(String start_video){
            this.start_video = start_video;
        }
        public String getStart_video(){
            return this.start_video;
        }
        public void setSubtitle(String subtitle){
            this.subtitle = subtitle;
        }
        public String getSubtitle(){
            return this.subtitle;
        }
        public void setTag_list(List<String> tag_list){
            this.tag_list = tag_list;
        }
        public List<String> getTag_list(){
            return this.tag_list;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setVideo_url(String video_url){
            this.video_url = video_url;
        }
        public String getVideo_url(){
            return this.video_url;
        }
        public void setVolume(int volume){
            this.volume = volume;
        }
        public int getVolume(){
            return this.volume;
        }
        public void setWords_info(String words_info){
            this.words_info = words_info;
        }
        public String getWords_info(){
            return this.words_info;
        }
    }


    public class Root
    {
        private List<Data> data;

        private int res;

        public void setData(List<Data> data){
            this.data = data;
        }
        public List<Data> getData(){
            return this.data;
        }
        public void setRes(int res){
            this.res = res;
        }
        public int getRes(){
            return this.res;
        }
    }


    private class DateTime {
    }
}
