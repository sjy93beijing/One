package com.example.sjy.myapplication.bean;

import java.util.List;

/**
 *
 * 用json 写的时候。。元素属性  是私有的。getset方法，下一级的列表是共有的  public static  class mSubjectsBean
 * Created by sjy_1993 on 2017/3/5.
 */
//实现分页的接口
public class mTop250Bean extends PageBean{
    /**
     * 一级菜单  标题  具体的实体
     */
    //父标题
    private List<mSubjectsBean> subjects;
    private String title;

    public List<mSubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<mSubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 二级菜单 具体的实体  如果一个像演员里面有多高就应该用List 来展开  比如类别  一开始实体类
     * @return
     */
    public static  class mSubjectsBean{
        private String id;
        private List<CastsBean> casts;
        private List<String> genres;
        private String alt;//详情连接
        private ImagesBean  images;  //电影封面图片
        private RatingBean rating;//评分
        private String title;//电影标题
        private String year;//年份

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public ImagesBean getImages() {
                return images;
            }

            public void setImages(ImagesBean images) {
                this.images = images;
            }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

        public static class CastsBean{
            private String alt;//连接
            private AvatarsBean avatars;
            private int id;
            private String name;

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        //演员图片大小
        public static class AvatarsBean{
            private String large;
            private String medium;
            private String small;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }

        public static class RatingBean{
            private String average;
            private int stars;

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getStars() {
                return stars;
            }

            public void setStars(int stars) {
                this.stars = stars;
            }
        }
        //电影图片大小
        public static class ImagesBean {
            private String large;
            private String media;
            private String small;

            public String getMedia() {
                return media;
            }

            public void setMedia(String media) {
                this.media = media;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }
        }


}
