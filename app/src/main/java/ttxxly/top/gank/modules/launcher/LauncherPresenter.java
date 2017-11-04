package ttxxly.top.gank.modules.launcher;

import android.content.Intent;

import ttxxly.top.gank.modules.home.HomeActivity;

/**
 * Description:
 * Created by ttxxly on 2017-11-03 12:00
 * Updated by ttxxly on 2017-11-03 12:00
 * Email: ttxxly@gmail.com
 */
public class LauncherPresenter implements LauncherContract.Presenter{

    private LauncherContract.View mView;

    public LauncherPresenter(LauncherContract.View view) {

        mView = view;
    }

    @Override
    public void start() {
        mView.loadImg("http://ww3.sinaimg.cn/large/610dc034gw1fbsfgssfrwj20u011h48y.jpg");
    }

    @Override
    public void stop() {

    }
}
