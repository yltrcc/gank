package ttxxly.top.gank.entity;

import android.service.quicksettings.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  http://gank.io/api/data/all/20/1
 * date: 2017/11/13 20:55
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class CategoryData {


    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5a06d733421aa90fef20351b
         * createdAt : 2017-11-11T18:55:47.563Z
         * desc : “叫阿姨”进阶版来了！当女生被叫“奶奶”，还会那么淡定吗？
         * publishedAt : 2017-11-13T12:10:58.643Z
         * source : chrome
         * type : 休息视频
         * url : http://www.bilibili.com/video/av16137432/
         * used : true
         * who : lxxself
         * images : ["http://img.gank.io/e28303d0-e4af-461a-b1e2-2405f81658db"]
         */

        private String _id = null;
        private String createdAt = null;
        private String desc = null;
        private String publishedAt = null;
        private String source = null;
        private String type = null;
        private String url = null;
        private boolean used = false;
        private String who = null;
        private List<String> images = new ArrayList<>();

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

        public boolean isEmptyImg() {
            int size = images.size();
            return size == 0;
        }

        public boolean isEmptyWho() {
            return who == null;
        }

        public boolean isEmptyTitle() {
            return desc == null;
        }

        public boolean isEmptyDate() {
            return publishedAt == null;
        }
    }
}
