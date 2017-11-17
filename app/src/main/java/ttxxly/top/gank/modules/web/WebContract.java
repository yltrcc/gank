package ttxxly.top.gank.modules.web;

import ttxxly.top.gank.base.BasePresenter;
import ttxxly.top.gank.base.BaseView;

/**
 * Description:
 * date: 2017/11/17 16:50
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class WebContract {

    interface View extends BaseView {
       void setToolBar();
       void initWebView();
       void setWebViewClient();
       void setWebChromeClient();
    }
    interface Presenter extends BasePresenter{

    }
}
