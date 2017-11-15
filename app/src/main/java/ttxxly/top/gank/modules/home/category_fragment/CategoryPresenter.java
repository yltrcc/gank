package ttxxly.top.gank.modules.home.category_fragment;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ttxxly.top.gank.data.remote.GankApi;
import ttxxly.top.gank.data.remote.NetWork;
import ttxxly.top.gank.entity.CategoryData;

/**
 * Description:
 * date: 2017/11/10 14:57
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View view;
    private List<String> list = new ArrayList<>();

    private int tp = 0;

    public CategoryPresenter(CategoryContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        list.add("Android");
        list.add("iOS");
        list.add("福利");
        list.add("休息视频");
        list.add("前端");
        getData(tp, list.get(tp));

    }

    @Override
    public void stop() {

    }

    @Override
    public void getData(int type, String category) {
        tp = type;
        GankApi gankApi = NetWork.getGankApi();
        Observable<CategoryData> observable = gankApi.getCategory(category, 10, 1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryData>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryData categorydata) {
                        Log.i("数据请求", "请求成功！！！");
                        if (tp == 0) {
                            view.initData(categorydata);
                        } else {
                            view.addData(categorydata);
                        }
                        tp++;
                        if (tp < 5) {
                            getData(tp, list.get(tp));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("数据请求", "请求失败！！！");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



}
