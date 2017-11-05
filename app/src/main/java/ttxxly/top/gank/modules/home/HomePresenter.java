package ttxxly.top.gank.modules.home;

import java.util.Set;

/**
 * Description:
 * date: 2017/11/05 15:05
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        mView = view;
    }
    @Override
    public void start() {
        mView.setDrawerLayout();
        mView.setDrawerLayoutLeft();
        mView.setPortrait();
        setRecyclerView();
    }

    @Override
    public void stop() {

    }

    @Override
    public void setRecyclerView() {

    }
}
