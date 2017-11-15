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

    interface View extends BaseView {
        void initData(CategoryData categorydata);
        void addData(CategoryData categoryData);
    }

    interface Presenter extends BasePresenter {
        void getData(int type, String category);

    }
}
