package ttxxly.top.gank.modules.home.category_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import ttxxly.top.gank.R;
import ttxxly.top.gank.common.DividerItemDecoration;
import ttxxly.top.gank.entity.CategoryData;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryContract.View {

    private RecyclerView mRvAndroid;
    private ViewGroup mContainer;
    private RecyclerView mRvIOS;
    private RecyclerView mRvVideo;
    private RecyclerView mRvWelfare;
    private RecyclerView mRvHtml5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mContainer = container;
        //设置Android RecycleView
        mRvAndroid = view.findViewById(R.id.rv_fragment_category_android);
        mRvAndroid.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        //设置分割线
        mRvAndroid.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));
        //设置IOS RecycleView
        mRvIOS = view.findViewById(R.id.rv_fragment_category_ios);
        mRvIOS.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        //设置分割线
        mRvIOS.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));

        //设置Video RecycleView
        mRvVideo = view.findViewById(R.id.rv_fragment_category_video);
        mRvVideo.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        //设置分割线
        mRvVideo.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));

        //设置福利 RecycleView
        mRvWelfare = view.findViewById(R.id.rv_fragment_category_welfare);
        mRvWelfare.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        //设置分割线
        mRvWelfare.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));

        //设置前端 RecycleView
        mRvHtml5 = view.findViewById(R.id.rv_fragment_category_html5);
        mRvHtml5.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        //设置分割线
        mRvHtml5.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));

        CategoryContract.Presenter presenter = new CategoryPresenter(this);
        presenter.start();
        return view;
    }

    @Override
    public void initAndroidData(CategoryData categorydata) {
        CategoryAdapter mAndroidAdapter = new CategoryAdapter(categorydata, mContainer);
        mRvAndroid.setAdapter(mAndroidAdapter);
    }

    @Override
    public void initIosData(CategoryData categorydata) {
        CategoryAdapter mIosAdapter = new CategoryAdapter(categorydata, mContainer);
        mRvIOS.setAdapter(mIosAdapter);
    }

    @Override
    public void initWelfareData(CategoryData categorydata) {
        CategoryAdapter mWelfareAdapter = new CategoryAdapter(categorydata, mContainer);
        mRvWelfare.setAdapter(mWelfareAdapter);
    }

    @Override
    public void initVideoData(CategoryData categorydata) {
        CategoryAdapter mVideoAdapter = new CategoryAdapter(categorydata, mContainer);
        mRvVideo.setAdapter(mVideoAdapter);
    }

    @Override
    public void initHtml5Data(CategoryData categorydata) {
        CategoryAdapter mHtml5Adapter = new CategoryAdapter(categorydata, mContainer);
        mRvHtml5.setAdapter(mHtml5Adapter);
    }
}
