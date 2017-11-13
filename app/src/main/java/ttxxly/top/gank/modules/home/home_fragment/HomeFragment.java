package ttxxly.top.gank.modules.home.home_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import ttxxly.top.gank.R;
import ttxxly.top.gank.common.DividerItemDecoration;
import ttxxly.top.gank.entity.DailyData;
import ttxxly.top.gank.modules.web.WebActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeContract.View {


    private RefreshLayout refreshLayout;
    private ViewGroup mContainer = null;
    private RecyclerView mRecyclerView;
    private HomePresenter presenter;
    private HomeAdapter homeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContainer = container;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = view.findViewById(R.id.rv_fragment_home);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        //设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));
        refreshLayout = view.findViewById(R.id.root_fragment_home);

        //设置逻辑操作，获取数据
        presenter = new HomePresenter(this);
        presenter.start();
        return view;
    }


    /**
     * 刷新数据
     *
     * @param dailyData
     */
    @Override
    public void initData(DailyData dailyData) {
        homeAdapter = new HomeAdapter(dailyData, mContainer);
        mRecyclerView.setAdapter(homeAdapter);
    }

    /**
     * 完成刷新，根据结果提示用户是否刷新成功
     *
     * @param isSucceed
     */
    @Override
    public void finishRefresh(boolean isSucceed) {
        refreshLayout.finishRefresh();
        if (!isSucceed) {
            Toast.makeText(getContext(), "刷新失败！！！！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 完成加载更多，根据结果提示用户
     *
     * @param isSucceed
     */
    @Override
    public void finishLoadmore(boolean isSucceed) {
        refreshLayout.finishLoadmore();
        if (!isSucceed) {
            Toast.makeText(getContext(), "数据加载失败！！！！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 加载更多数据
     *
     * @param dailyData
     */
    @Override
    public void AddData(DailyData dailyData) {
        int start = homeAdapter.getItemCount();
        homeAdapter.addDailyData(dailyData);
        homeAdapter.notifyItemRangeInserted(start, dailyData.getResults().size());
    }

    @Override
    public void setRefreshAndLoadMore() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.getData(true);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                presenter.getData(false);
            }
        });
    }

    @Override
    public void setRecycleViewListener() {

        //RecycleView 点击事件
        homeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //首页 Item click
                Toast.makeText(getContext(), homeAdapter.getDailyData().getResults().get
                        (position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContainer.getContext(), WebActivity.class);
                intent.putExtra("title", homeAdapter.getDailyData().getResults().get(position)
                        .getTitle());
                intent.putExtra("content", homeAdapter.getDailyData().getResults().get(position)
                        .getContent());
                startActivity(intent);
            }
        });
    }
}
