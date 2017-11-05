package ttxxly.top.gank.modules.home;

import android.view.View;

import ttxxly.top.gank.base.BasePresenter;
import ttxxly.top.gank.base.BaseView;

/**
 * Description:
 * date: 2017/11/05 14:55
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class HomeContract {

    interface View extends BaseView{

        void setPortrait();
        void setDrawerLayoutLeft();
        void setDrawerLayout();
    }

    interface Presenter extends BasePresenter{

        void setRecyclerView();
    }
}
