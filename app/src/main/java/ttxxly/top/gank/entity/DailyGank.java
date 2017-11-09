package ttxxly.top.gank.entity;

import java.util.List;

/**
 * Description: http://gank.io/api/day/2017/11/08
 * date: 2017/11/09 15:12
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class DailyGank {

    /**
     * category : ["休息视频","Android","前端","瞎推荐","福利","iOS"]
     * error : false
     * results : {"Android":[{"_id":"5a000a51421aa90fef203504",
     * "createdAt":"2017-11-06T15:08:01.257Z","desc":" 使用CMake来进行Android NDK开发",
     * "publishedAt":"2017-11-08T11:00:50.559Z","source":"chrome","type":"Android",
     * "url":"http://blog.csdn.net/qq_34902522/article/details/78104610","used":true,
     * "who":"宇宝守护神"},{"_id":"5a010bea421aa90fe7253604","createdAt":"2017-11-07T09:27:06.248Z",
     * "desc":"如何实现超萌动感小太阳？","publishedAt":"2017-11-08T11:00:50.559Z","source":"web",
     * "type":"Android","url":"https://mp.weixin.qq
     * .com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488057&idx=2&sn=d67b8d9c7da04e4efdec4084efe2098f",
     * "used":true,"who":"陈宇明"},{"_id":"5a0113a7421aa90fe7253605",
     * "createdAt":"2017-11-07T10:00:07.760Z","desc":"Android Gradle 自定义Task 详解",
     * "publishedAt":"2017-11-08T11:00:50.559Z","source":"web","type":"Android",
     * "url":"http://blog.csdn.net/zhaoyanjun6/article/details/76408024","used":true,
     * "who":"赵彦军"},{"_id":"5a012636421aa90fe2f02c31","createdAt":"2017-11-07T11:19:18.496Z",
     * "desc":"教你如何在SDK开发使用美团Robust进行热更新","publishedAt":"2017-11-08T11:00:50.559Z",
     * "source":"web","type":"Android","url":"http://www.jianshu.com/p/9284853d5762","used":true,
     * "who":"Ou Bowu"},{"_id":"5a027262421aa90fe725360e","createdAt":"2017-11-08T10:56:34.462Z",
     * "desc":"Lanproxy 是一个将局域网个人电脑、服务器代理到公网的内网穿透工具。","images":["http://img.gank
     * .io/52be5d7d-48a6-45fb-bc80-629d057f1bea"],"publishedAt":"2017-11-08T11:00:50.559Z",
     * "source":"chrome","type":"Android","url":"https://github.com/ffay/lanproxy","used":true,
     * "who":"代码家"}],"iOS":[{"_id":"5a026ff4421aa90fe725360b",
     * "createdAt":"2017-11-08T10:46:12.345Z","desc":"利用苹果的 AvatarKit 实现的表情移植功能。",
     * "images":["http://img.gank.io/c4c8915e-8e9d-446d-b2a1-8da6a3a62051"],
     * "publishedAt":"2017-11-08T11:00:50.559Z","source":"chrome","type":"iOS",
     * "url":"https://github.com/simonbs/SBSAnimoji","used":true,"who":"代码家"},
     * {"_id":"5a02723f421aa90fe725360d","createdAt":"2017-11-08T10:55:59.312Z","desc":"优化 Swift
     * 编译时间。","images":["http://img.gank.io/365b4d67-6291-415f-ba38-30900f22b8ba"],
     * "publishedAt":"2017-11-08T11:00:50.559Z","source":"chrome","type":"iOS",
     * "url":"https://github.com/fastred/Optimizing-Swift-Build-Times","used":true,"who":"代码家"}],
     * "休息视频":[{"_id":"59fefc38421aa90fe2f02c25","createdAt":"2017-11-05T19:55:36.730Z",
     * "desc":"据说这是今年最好的爱情片，尽管只有2分钟，你看懂了吗？","publishedAt":"2017-11-08T11:00:50.559Z",
     * "source":"chrome","type":"休息视频","url":"https://weibo
     * .com/tv/v/FtEOCEIqv?fid=1034:9b2526d0a27176d005486141ee3b78da&display=0&retcode=6102",
     * "used":true,"who":"lxxself"}],"前端":[{"_id":"5a003604421aa90fe50c01e1",
     * "createdAt":"2017-11-06T18:14:28.850Z","desc":"前端每周清单第 38 期: Node 9 发布，Kotlin 与
     * React，Netflix 架构解密","publishedAt":"2017-11-08T11:00:50.559Z","source":"web","type":"前端",
     * "url":"https://zhuanlan.zhihu.com/p/30790399","used":true,"who":"王下邀月熊(Chevalier)"},
     * {"_id":"5a011caf421aa90fef203507","createdAt":"2017-11-07T10:38:39.695Z","desc":"Negative
     * array index support `array[-1]` using ES2015 Proxy",
     * "publishedAt":"2017-11-08T11:00:50.559Z","source":"web","type":"前端","url":"https://github
     * .com/sindresorhus/negative-array","used":true,"who":"鑫花璐放"}],
     * "瞎推荐":[{"_id":"5a003bd7421aa90fef203505","createdAt":"2017-11-06T18:39:19.877Z",
     * "desc":"Kotlin 语言下设计模式的不同实现","publishedAt":"2017-11-08T11:00:50.559Z","source":"web",
     * "type":"瞎推荐","url":"http://www.jianshu.com/p/a5c33a25f8e9","used":true,"who":"阿韦"},
     * {"_id":"5a0119bd421aa90fe7253608","createdAt":"2017-11-07T10:26:05.191Z","desc":"最好用的 NBA
     * CLI 工具 - 給想邊上班邊看 NBA 的程序員","images":["http://img.gank
     * .io/2118cc3d-40e7-4ae4-912d-262940e59cd3"],"publishedAt":"2017-11-08T11:00:50.559Z",
     * "source":"web","type":"瞎推荐","url":"https://github.com/xxhomey19/nba-go","used":true,
     * "who":"Homer Chen"},{"_id":"5a027024421aa90fe725360c",
     * "createdAt":"2017-11-08T10:47:00.215Z","desc":"利用 certstream 信息，主动出击抓取钓鱼网站。",
     * "publishedAt":"2017-11-08T11:00:50.559Z","source":"chrome","type":"瞎推荐",
     * "url":"https://github.com/x0rz/phishing_catcher","used":true,"who":"代码家"}],
     * "福利":[{"_id":"5a011452421aa90fe7253606","createdAt":"2017-11-07T10:02:58.73Z",
     * "desc":"11-7","publishedAt":"2017-11-08T11:00:50.559Z","source":"chrome","type":"福利",
     * "url":"http://7xi8d6.com1.z0.glb.clouddn
     * .com/20171107100244_0fbENB_yyannwong_7_11_2017_10_2_5_982.jpeg","used":true,
     * "who":"daimajia"}]}
     */

    private boolean error;
    private ResultsBean results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsBean {
        private List<AndroidBean> Android;
        private List<IOSBean> iOS;
        private List<休息视频Bean> 休息视频;
        private List<前端Bean> 前端;
        private List<瞎推荐Bean> 瞎推荐;
        private List<福利Bean> 福利;

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public List<休息视频Bean> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<休息视频Bean> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<前端Bean> get前端() {
            return 前端;
        }

        public void set前端(List<前端Bean> 前端) {
            this.前端 = 前端;
        }

        public List<瞎推荐Bean> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<瞎推荐Bean> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<福利Bean> get福利() {
            return 福利;
        }

        public void set福利(List<福利Bean> 福利) {
            this.福利 = 福利;
        }

        public static class AndroidBean {
            /**
             * _id : 5a000a51421aa90fef203504
             * createdAt : 2017-11-06T15:08:01.257Z
             * desc :  使用CMake来进行Android NDK开发
             * publishedAt : 2017-11-08T11:00:50.559Z
             * source : chrome
             * type : Android
             * url : http://blog.csdn.net/qq_34902522/article/details/78104610
             * used : true
             * who : 宇宝守护神
             * images : ["http://img.gank.io/52be5d7d-48a6-45fb-bc80-629d057f1bea"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class IOSBean {
            /**
             * _id : 5a026ff4421aa90fe725360b
             * createdAt : 2017-11-08T10:46:12.345Z
             * desc : 利用苹果的 AvatarKit 实现的表情移植功能。
             * images : ["http://img.gank.io/c4c8915e-8e9d-446d-b2a1-8da6a3a62051"]
             * publishedAt : 2017-11-08T11:00:50.559Z
             * source : chrome
             * type : iOS
             * url : https://github.com/simonbs/SBSAnimoji
             * used : true
             * who : 代码家
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 休息视频Bean {
            /**
             * _id : 59fefc38421aa90fe2f02c25
             * createdAt : 2017-11-05T19:55:36.730Z
             * desc : 据说这是今年最好的爱情片，尽管只有2分钟，你看懂了吗？
             * publishedAt : 2017-11-08T11:00:50.559Z
             * source : chrome
             * type : 休息视频
             * url : https://weibo.com/tv/v/FtEOCEIqv?fid=1034:9b2526d0a27176d005486141ee3b78da
             * &display=0&retcode=6102
             * used : true
             * who : lxxself
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 前端Bean {
            /**
             * _id : 5a003604421aa90fe50c01e1
             * createdAt : 2017-11-06T18:14:28.850Z
             * desc : 前端每周清单第 38 期: Node 9 发布，Kotlin 与 React，Netflix 架构解密
             * publishedAt : 2017-11-08T11:00:50.559Z
             * source : web
             * type : 前端
             * url : https://zhuanlan.zhihu.com/p/30790399
             * used : true
             * who : 王下邀月熊(Chevalier)
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 瞎推荐Bean {
            /**
             * _id : 5a003bd7421aa90fef203505
             * createdAt : 2017-11-06T18:39:19.877Z
             * desc : Kotlin 语言下设计模式的不同实现
             * publishedAt : 2017-11-08T11:00:50.559Z
             * source : web
             * type : 瞎推荐
             * url : http://www.jianshu.com/p/a5c33a25f8e9
             * used : true
             * who : 阿韦
             * images : ["http://img.gank.io/2118cc3d-40e7-4ae4-912d-262940e59cd3"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 福利Bean {
            /**
             * _id : 5a011452421aa90fe7253606
             * createdAt : 2017-11-07T10:02:58.73Z
             * desc : 11-7
             * publishedAt : 2017-11-08T11:00:50.559Z
             * source : chrome
             * type : 福利
             * url : http://7xi8d6.com1.z0.glb.clouddn.com/20171107100244_0fbENB_yyannwong_7_11_2017_10_2_5_982.jpeg
             * used : true
             * who : daimajia
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }
    }
}
