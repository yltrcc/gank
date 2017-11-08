package ttxxly.top.gank.modules.home.fragment;

import android.media.DrmInitData;

import ttxxly.top.gank.base.BasePresenter;
import ttxxly.top.gank.base.BaseView;
import ttxxly.top.gank.entity.DailyData;

/**
 * Description:
 * date: 2017/11/05 14:55
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class HomeContract {

    interface View extends BaseView{

        void initData(DailyData dailyData);
        void finishRefresh(boolean isSucceed);
        void finishLoadmore(boolean isSucceed);
        void AddData(DailyData dailyData);
        void setRefreshAndLoadMore();
        void setRecycleViewListener();
    }

    interface Presenter extends BasePresenter{

        void getData(Boolean isRefresh);
    }
}
