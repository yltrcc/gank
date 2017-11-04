package ttxxly.top.gank.modules.launcher;

import ttxxly.top.gank.base.BasePresenter;
import ttxxly.top.gank.base.BaseView;


/**
 * Description:
 * date: 2017-11-03 14:03
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */
public class LauncherContract {

    interface View extends BaseView<Presenter> {

        /**
         * 跳转主页面
         */
        void goHomeActivity();

        /**
         * 加载启动页图片
         *
         * @param url pic url
         */
        void loadImg(String url);
    }

    interface Presenter extends BasePresenter {

    }
}
