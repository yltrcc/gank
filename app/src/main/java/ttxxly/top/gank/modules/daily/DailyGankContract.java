package ttxxly.top.gank.modules.daily;

import ttxxly.top.gank.base.BasePresenter;
import ttxxly.top.gank.base.BaseView;

/**
 * Description:
 * date: 2017/11/09 14:18
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class DailyGankContract {

    interface View extends BaseView{

        void setDeleteClickListener();
        void setTitle();
        void setImgClickListener();
        void getUrl(String url);
    }

    interface Presenter extends BasePresenter{
        void setImg();
        String setUrl();
    }
}
