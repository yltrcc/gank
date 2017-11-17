package ttxxly.top.gank.modules.web;

/**
 * Description:
 * date: 2017/11/17 17:13
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class WebPresenter implements WebContract.Presenter {
    private WebContract.View mView;

    public WebPresenter(WebContract.View view) {
        mView = view;
    }
    @Override
    public void start() {
        mView.setToolBar();
        mView.initWebView();
        mView.setWebViewClient();
        mView.setWebChromeClient();
    }

    @Override
    public void stop() {

    }
}
