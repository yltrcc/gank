package ttxxly.top.gank.modules.home.category_fragment;

import ttxxly.top.gank.base.BasePresenter;
import ttxxly.top.gank.base.BaseView;
import ttxxly.top.gank.entity.CategoryData;

/**
 * Description:
 * date: 2017/11/10 14:56
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class CategoryContract {

    interface View extends BaseView{
        void initAndroidData(CategoryData categorydata);
        void initIosData(CategoryData categorydata);
        void initWelfareData(CategoryData categorydata);
        void initVideoData(CategoryData categorydata);
        void initHtml5Data(CategoryData categorydata);
    }

    interface Presenter extends BasePresenter{
        void getAndroidData();
        void getIosData();
        void getWelfareData();
        void getVideoData();
        void getHtml5Data();
    }
}
