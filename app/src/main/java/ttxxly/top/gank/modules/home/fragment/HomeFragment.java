package ttxxly.top.gank.modules.home.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ttxxly.top.gank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private RefreshLayout refreshLayout;
    private ViewGroup mContainer = null;
    private ArrayList<Map<String, String>> mData;
    private RecyclerView mRecyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContainer = container;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initData();
        mRecyclerView = view.findViewById(R.id.rv_fragment_home);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        mRecyclerView.setAdapter(new HomeAdapter());
        //设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));

        //设置下拉刷新 上拉加载
        refreshLayout = view.findViewById(R.id.root_fragment_home);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });


        return view;
    }


    protected void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("title",
                    "主题换色，夜间模式夜间模式夜间模式夜间模式夜间模式夜间模式夜间模式夜间模式，省流量，这可能");
            map.put("author", "代码家");
            map.put("date", "2017-11-4 17:58:31");
            map.put("url", "R.mipmap.girl");
            mData.add(map);
        }
    }

    public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_home, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.title.setText(mData.get(position).get("title"));
            holder.author.setText(mData.get(position).get("author"));
            holder.date.setText(mData.get(position).get("date"));
            holder.img.setImageResource(R.mipmap.girl);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {


            private final TextView title;
            private final TextView author;
            private final TextView date;
            private final ImageView img;

            MyViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.tv_item_title);
                author = view.findViewById(R.id.tv_item_publisher);
                date = view.findViewById(R.id.tv_item_time);
                img = view.findViewById(R.id.iv_item_img);
            }
        }
    }

}
