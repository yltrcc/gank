package ttxxly.top.gank.modules.home.category_fragment;


import android.util.Log;

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

    private int tp = 0;

    public CategoryPresenter(CategoryContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        getAndroidData();
        getIosData();
        getWelfareData();
        getVideoData();
        getHtml5Data();
    }

    @Override
    public void stop() {

    }

    @Override
    public void getAndroidData() {
        GankApi gankApi = NetWork.getGankApi();
        Observable<CategoryData> observable = gankApi.getCategory("Android", 3,1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryData>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryData categorydata) {
                        Log.i("数据请求", "请求成功！！！");
                        view.initAndroidData(categorydata);
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

    @Override
    public void getIosData() {
        GankApi gankApi = NetWork.getGankApi();
        Observable<CategoryData> observable = gankApi.getCategory("Android", 3,1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryData>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryData categorydata) {
                        Log.i("数据请求", "请求成功！！！");
                        view.initIosData(categorydata);
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

    @Override
    public void getWelfareData() {
        GankApi gankApi = NetWork.getGankApi();
        Observable<CategoryData> observable = gankApi.getCategory("Android", 3,1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryData>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryData categorydata) {
                        Log.i("数据请求", "请求成功！！！");
                        view.initWelfareData(categorydata);
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

    @Override
    public void getVideoData() {
        GankApi gankApi = NetWork.getGankApi();
        Observable<CategoryData> observable = gankApi.getCategory("Android", 3,1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryData>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryData categorydata) {
                        Log.i("数据请求", "请求成功！！！");
                        view.initVideoData(categorydata);
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

    @Override
    public void getHtml5Data() {
        GankApi gankApi = NetWork.getGankApi();
        Observable<CategoryData> observable = gankApi.getCategory("Android", 3,1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryData>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CategoryData categorydata) {
                        Log.i("数据请求", "请求成功！！！");
                        view.initHtml5Data(categorydata);
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
