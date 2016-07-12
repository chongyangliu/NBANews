package com.example.lcy.nbanews.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-7-11.
 */
public class NBANewsEntity implements Serializable {

    /**
     * nextId : 119142361
     * newslist : [{"contentType":"ARTICLE","description":"火箭今夏签下了安德森和戈登。","title":"莫雷：努力打造出一支尽可能优秀的球队","putdate":1468218000000,"imgUrlList":["http://image.res.meizu.com/image/reader/c12d9f7478a302db5ddf79d3eefa3554/original"],"randomNum":1468217875000,"articleId":119143433,"contentSourceName":"虎扑NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143433.json","type":"IMAGETEXT","sourceType":"NORMAL"},{"contentType":"ARTICLE","description":"乔治比赛中还完成了360度扣篮。","title":"乔治在西雅图Pro-Am比赛里砍下40分","putdate":1468218000000,"imgUrlList":["http://image.res.meizu.com/image/reader/dea2680e5459ddb388da6d74579974eb/original"],"randomNum":1468217924000,"articleId":119143434,"contentSourceName":"虎扑NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143434.json","type":"IMAGETEXT","sourceType":"NORMAL"},{"contentType":"ARTICLE","description":"教练认为他的投篮问题是心理上的。","title":"霍利斯-杰弗森：需要相信自己能投进球","putdate":1468218000000,"imgUrlList":["http://image.res.meizu.com/image/reader/c8af36462389882b65c05cf632d4188a/original"],"randomNum":1468217862000,"articleId":119143435,"contentSourceName":"虎扑NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143435.json","type":"IMAGETEXT","sourceType":"NORMAL"},{"contentType":"ARTICLE","description":"队友们都称赞南斯的激情和斗志。","title":"小南斯笑称：我有点儿像科比了","putdate":1468218000000,"imgUrlList":["http://image.res.meizu.com/image/reader/31653c16dbb1a155c46df10d556d29fc/original"],"randomNum":1468217791000,"articleId":119143436,"contentSourceName":"虎扑NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143436.json","type":"IMAGETEXT","sourceType":"NORMAL"},{"contentType":"ARTICLE","description":"詹皇IG回顾夺冠 凤凰体育讯 北京时间7月11日，距离克利夫兰骑士队夺得队史首冠已经过去21天了","title":"詹皇IG回顾夺冠 称完成不可能任务","putdate":1468217400000,"imgUrlList":["http://image.res.meizu.com/image/reader/2cfb1ccd29652539983eed3b1b5c18b2/original"],"randomNum":1468217254000,"articleId":119143138,"contentSourceName":"NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143138.json","type":"IMAGETEXT","sourceType":"ZAKER"},{"contentType":"ARTICLE","description":"很有可能是火箭对周琦没多大兴趣 凤凰体育讯 北京时间7月11日，一则\u201c周琦今年不打NBA，新疆不","title":"经纪人：去向未定 但火箭或不需周琦","putdate":1468217400000,"imgUrlList":["http://image.res.meizu.com/image/reader/d9693d0c109b524a069e562b216c6685/original"],"randomNum":1468217239000,"articleId":119143139,"contentSourceName":"NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143139.json","type":"IMAGETEXT","sourceType":"ZAKER"},{"contentType":"ARTICLE","description":"林书豪 据台湾\u201c联合新闻网\u201d消息， \u201c林来疯\u201d已成过去式，\u201c豪小子\u201d林书豪新球季将带着更成熟的身","title":"林书豪：准备担任领袖 林疯狂已过去","putdate":1468217400000,"imgUrlList":["http://image.res.meizu.com/image/reader/93b4ee11e44d0df7bc4787d8efe57203/original"],"randomNum":1468217294000,"articleId":119143140,"contentSourceName":"NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143140.json","type":"IMAGETEXT","sourceType":"ZAKER"},{"contentType":"ARTICLE","description":"虎扑体育7月11日讯 当地时间周五的一场拉斯维加斯夏季联赛中，今年的五号秀克里斯-邓恩 (Kris ","title":"奶一口？锡伯杜：球队的年轻核心很棒","putdate":1468217400000,"imgUrlList":["http://image.res.meizu.com/image/reader/c487b64fd9e2efe6d155a2608ec4e434/original"],"randomNum":1468217117000,"articleId":119143141,"contentSourceName":"NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143141.json","type":"IMAGETEXT","sourceType":"ZAKER"},{"contentType":"ARTICLE","description":"休斯敦火箭队主教练麦克-丹东尼日前接受了Sirius XM NBA电台的采访。丹东尼在采访中谈到了火","title":"丹东尼：哈登应重签合同 能让他专注","putdate":1468217400000,"imgUrlList":["http://image.res.meizu.com/image/reader/1a699cec4ba7620c2ffa1dd0a0c99984/original"],"randomNum":1468217293000,"articleId":119143142,"contentSourceName":"NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143142.json","type":"IMAGETEXT","sourceType":"ZAKER"},{"contentType":"ARTICLE","description":"最近，NBA名宿斯科蒂-皮蓬接受了《体育画报》的采访，他回忆了自己在国家队效力的经历，也谈到了最近公","title":"皮蓬：LBJ伟大！公牛交易罗斯是双赢","putdate":1468217400000,"imgUrlList":["http://image.res.meizu.com/image/reader/837b3814060627d1c245fd0a0c1173fe/original"],"randomNum":1468217295000,"articleId":119143143,"contentSourceName":"NBA","articleUrl":"http://reader.res.meizu.com/reader/articlecontent/20160711/119143143.json","type":"IMAGETEXT","sourceType":"ZAKER"}]
     */

    private String nextId;
    /**
     * contentType : ARTICLE
     * description : 火箭今夏签下了安德森和戈登。
     * title : 莫雷：努力打造出一支尽可能优秀的球队
     * putdate : 1468218000000
     * imgUrlList : ["http://image.res.meizu.com/image/reader/c12d9f7478a302db5ddf79d3eefa3554/original"]
     * randomNum : 1468217875000
     * articleId : 119143433
     * contentSourceName : 虎扑NBA
     * articleUrl : http://reader.res.meizu.com/reader/articlecontent/20160711/119143433.json
     * type : IMAGETEXT
     * sourceType : NORMAL
     */

    private List<NewslistBean> newslist;

    public String getNextId() {
        return nextId;
    }

    public void setNextId(String nextId) {
        this.nextId = nextId;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

     public static class NewslistBean extends MultiItemEntity implements Serializable {
        private String contentType;
        private String description;
        private String title;
        private long putdate;
        private long randomNum;
        private int articleId;
        private String contentSourceName;
        private String articleUrl;
        private String type;
        private String sourceType;
        private List<String> imgUrlList;

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getPutdate() {
            return putdate;
        }

        public void setPutdate(long putdate) {
            this.putdate = putdate;
        }

        public long getRandomNum() {
            return randomNum;
        }

        public void setRandomNum(long randomNum) {
            this.randomNum = randomNum;
        }

        public int getArticleId() {
            return articleId;
        }

        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }

        public String getContentSourceName() {
            return contentSourceName;
        }

        public void setContentSourceName(String contentSourceName) {
            this.contentSourceName = contentSourceName;
        }

        public String getArticleUrl() {
            return articleUrl;
        }

        public void setArticleUrl(String articleUrl) {
            this.articleUrl = articleUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public List<String> getImgUrlList() {
            return imgUrlList;
        }

        public void setImgUrlList(List<String> imgUrlList) {
            this.imgUrlList = imgUrlList;
        }
    }
}
