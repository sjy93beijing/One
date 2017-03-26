package com.example.sjy.myapplication.One.Bean;

/**
 * Created by sjy_1993 on 2017/3/23.
 */
public class PhotoDetail {

    /**
     * author_id : -1
     * commentnum : 0
     * content_bgcolor : #FFFFFF
     * hide_flag : 0
     * hp_author : 插画＆Georgie McAusland 作品
     * hp_content : 我发现只要心无旁骛，专注于工作，最终还是会有钱的。 by [美] 伍迪·艾伦
     * hp_img_original_url : http://image.wufazhuce.com/Fg4DX3KMGDX4W7lra-wWJhAsYv9X
     * hp_img_url : http://image.wufazhuce.com/Fg4DX3KMGDX4W7lra-wWJhAsYv9X
     * hp_makettime : 2017-03-21 06:00:00
     * hp_title : VOL.1627
     * hpcontent_id : 1654
     * image_authors : Georgie McAusland
     * image_from :
     * ipad_url : http://image.wufazhuce.com/Fg4DX3KMGDX4W7lra-wWJhAsYv9X
     * last_update_date : 2017-03-20 11:20:30
     * maketime : 2017-03-21 06:00:00
     * praisenum : 13403
     * share_list : {"qq":{"desc":"","imgUrl":"","link":"","title":""},"weibo":{"desc":"","imgUrl":"","link":"","title":"ONE·一个 我发现只要心无旁骛，专注于工作，最终还是会有钱的。 by [美] 伍迪·艾伦\u2014\u2014[美] 伍迪·艾伦 下载ONE·一个APP:http://weibo.com/p/100404157874"},"wx":{"desc":"","imgUrl":"","link":"","title":""}}
     * sharenum : 3701
     * template_category : 1
     * text_authors : [美] 伍迪·艾伦
     * text_from :
     * wb_img_url :
     * web_url : http://m.wufazhuce.com/one/1654
     */

    private DataEntity data;
    /**
     * data : {"author_id":"-1","commentnum":0,"content_bgcolor":"#FFFFFF","hide_flag":"0","hp_author":"插画＆Georgie McAusland 作品","hp_content":"我发现只要心无旁骛，专注于工作，最终还是会有钱的。 by [美] 伍迪·艾伦","hp_img_original_url":"http://image.wufazhuce.com/Fg4DX3KMGDX4W7lra-wWJhAsYv9X","hp_img_url":"http://image.wufazhuce.com/Fg4DX3KMGDX4W7lra-wWJhAsYv9X","hp_makettime":"2017-03-21 06:00:00","hp_title":"VOL.1627","hpcontent_id":"1654","image_authors":"Georgie McAusland","image_from":"","ipad_url":"http://image.wufazhuce.com/Fg4DX3KMGDX4W7lra-wWJhAsYv9X","last_update_date":"2017-03-20 11:20:30","maketime":"2017-03-21 06:00:00","praisenum":13403,"share_list":{"qq":{"desc":"","imgUrl":"","link":"","title":""},"weibo":{"desc":"","imgUrl":"","link":"","title":"ONE·一个 我发现只要心无旁骛，专注于工作，最终还是会有钱的。 by [美] 伍迪·艾伦\u2014\u2014[美] 伍迪·艾伦 下载ONE·一个APP:http://weibo.com/p/100404157874"},"wx":{"desc":"","imgUrl":"","link":"","title":""}},"sharenum":3701,"template_category":"1","text_authors":"[美] 伍迪·艾伦","text_from":"","wb_img_url":"","web_url":"http://m.wufazhuce.com/one/1654"}
     * res : 0
     */

    private int res;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataEntity getData() {
        return data;
    }

    public int getRes() {
        return res;
    }

    public static class DataEntity {
        private String author_id;
        private int commentnum;
        private String content_bgcolor;
        private String hide_flag;
        private String hp_author;
        private String hp_content;
        private String hp_img_original_url;
        private String hp_img_url;
        private String hp_makettime;
        private String hp_title;
        private String hpcontent_id;
        private String image_authors;
        private String image_from;
        private String ipad_url;
        private String last_update_date;
        private String maketime;
        private int praisenum;
        /**
         * qq : {"desc":"","imgUrl":"","link":"","title":""}
         * weibo : {"desc":"","imgUrl":"","link":"","title":"ONE·一个 我发现只要心无旁骛，专注于工作，最终还是会有钱的。 by [美] 伍迪·艾伦\u2014\u2014[美] 伍迪·艾伦 下载ONE·一个APP:http://weibo.com/p/100404157874"}
         * wx : {"desc":"","imgUrl":"","link":"","title":""}
         */

        private ShareListEntity share_list;
        private int sharenum;
        private String template_category;
        private String text_authors;
        private String text_from;
        private String wb_img_url;
        private String web_url;

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        public void setContent_bgcolor(String content_bgcolor) {
            this.content_bgcolor = content_bgcolor;
        }

        public void setHide_flag(String hide_flag) {
            this.hide_flag = hide_flag;
        }

        public void setHp_author(String hp_author) {
            this.hp_author = hp_author;
        }

        public void setHp_content(String hp_content) {
            this.hp_content = hp_content;
        }

        public void setHp_img_original_url(String hp_img_original_url) {
            this.hp_img_original_url = hp_img_original_url;
        }

        public void setHp_img_url(String hp_img_url) {
            this.hp_img_url = hp_img_url;
        }

        public void setHp_makettime(String hp_makettime) {
            this.hp_makettime = hp_makettime;
        }

        public void setHp_title(String hp_title) {
            this.hp_title = hp_title;
        }

        public void setHpcontent_id(String hpcontent_id) {
            this.hpcontent_id = hpcontent_id;
        }

        public void setImage_authors(String image_authors) {
            this.image_authors = image_authors;
        }

        public void setImage_from(String image_from) {
            this.image_from = image_from;
        }

        public void setIpad_url(String ipad_url) {
            this.ipad_url = ipad_url;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }

        public void setShare_list(ShareListEntity share_list) {
            this.share_list = share_list;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }

        public void setTemplate_category(String template_category) {
            this.template_category = template_category;
        }

        public void setText_authors(String text_authors) {
            this.text_authors = text_authors;
        }

        public void setText_from(String text_from) {
            this.text_from = text_from;
        }

        public void setWb_img_url(String wb_img_url) {
            this.wb_img_url = wb_img_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public String getContent_bgcolor() {
            return content_bgcolor;
        }

        public String getHide_flag() {
            return hide_flag;
        }

        public String getHp_author() {
            return hp_author;
        }

        public String getHp_content() {
            return hp_content;
        }

        public String getHp_img_original_url() {
            return hp_img_original_url;
        }

        public String getHp_img_url() {
            return hp_img_url;
        }

        public String getHp_makettime() {
            return hp_makettime;
        }

        public String getHp_title() {
            return hp_title;
        }

        public String getHpcontent_id() {
            return hpcontent_id;
        }

        public String getImage_authors() {
            return image_authors;
        }

        public String getImage_from() {
            return image_from;
        }

        public String getIpad_url() {
            return ipad_url;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public String getMaketime() {
            return maketime;
        }

        public int getPraisenum() {
            return praisenum;
        }

        public ShareListEntity getShare_list() {
            return share_list;
        }

        public int getSharenum() {
            return sharenum;
        }

        public String getTemplate_category() {
            return template_category;
        }

        public String getText_authors() {
            return text_authors;
        }

        public String getText_from() {
            return text_from;
        }

        public String getWb_img_url() {
            return wb_img_url;
        }

        public String getWeb_url() {
            return web_url;
        }

        public static class ShareListEntity {
            /**
             * desc :
             * imgUrl :
             * link :
             * title :
             */

            private QqEntity qq;
            /**
             * desc :
             * imgUrl :
             * link :
             * title : ONE·一个 我发现只要心无旁骛，专注于工作，最终还是会有钱的。 by [美] 伍迪·艾伦——[美] 伍迪·艾伦 下载ONE·一个APP:http://weibo.com/p/100404157874
             */

            private WeiboEntity weibo;
            /**
             * desc :
             * imgUrl :
             * link :
             * title :
             */

            private WxEntity wx;

            public void setQq(QqEntity qq) {
                this.qq = qq;
            }

            public void setWeibo(WeiboEntity weibo) {
                this.weibo = weibo;
            }

            public void setWx(WxEntity wx) {
                this.wx = wx;
            }

            public QqEntity getQq() {
                return qq;
            }

            public WeiboEntity getWeibo() {
                return weibo;
            }

            public WxEntity getWx() {
                return wx;
            }

            public static class QqEntity {
                private String desc;
                private String imgUrl;
                private String link;
                private String title;

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public String getLink() {
                    return link;
                }

                public String getTitle() {
                    return title;
                }
            }

            public static class WeiboEntity {
                private String desc;
                private String imgUrl;
                private String link;
                private String title;

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public String getLink() {
                    return link;
                }

                public String getTitle() {
                    return title;
                }
            }

            public static class WxEntity {
                private String desc;
                private String imgUrl;
                private String link;
                private String title;

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDesc() {
                    return desc;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public String getLink() {
                    return link;
                }

                public String getTitle() {
                    return title;
                }
            }
        }
    }
}
