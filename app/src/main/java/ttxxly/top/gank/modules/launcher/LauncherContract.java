package ttxxly.top.gank.modules.launcher;

import ttxxly.top.gank.base.BasePresenter;
import ttxxly.top.gank.base.BaseView;

/**
 * description:
 * author: created by ttxxly on 2017:11:03:11
 * mial: ttxxly@gmail.com
 */

public class LauncherContract {

    interface View extends BaseView {

        /**
         * 跳转主页面
         */
        void goHomeActivity();

        /**
         * 加载启动页图片
         * @param url
         */
        void loadImg(String url);
    }

    interface Presenter extends BasePresenter {

    }
}
