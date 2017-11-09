package ttxxly.top.gank.modules.home.home_fragment;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ttxxly.top.gank.data.remote.GankApi;
import ttxxly.top.gank.data.remote.NetWork;
import ttxxly.top.gank.entity.DailyData;

/**
 * Description:
 * date: 2017/11/05 15:05
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    /**
     * 页数
     */
    private int mPage = 1;

    public HomePresenter(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void start() {

        mView.setRefreshAndLoadMore();
        getData(true);
    }

    @Override
    public void stop() {

    }

    @Override
    public void getData(Boolean isRefresh) {

        if (isRefresh) {
            mPage = 1;
        } else {
            mPage += 1;
        }
        GankApi gankApi = NetWork.getGankApi();
        Observable<DailyData> observable = gankApi.getDaily(15, mPage);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyData dailyData) {
                        if (mPage == 1) {
                            mView.initData(dailyData);
                            mView.setRecycleViewListener();
                            mView.finishRefresh(true);
                        } else {
                            mView.finishLoadmore(true);
                            mView.AddData(dailyData);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mPage == 1) {
                            mView.finishRefresh(false);
                        } else {
                            mView.finishLoadmore(false);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
