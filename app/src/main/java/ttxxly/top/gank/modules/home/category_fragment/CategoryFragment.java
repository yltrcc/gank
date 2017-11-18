package ttxxly.top.gank.modules.home.category_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;


import ttxxly.top.gank.R;
import ttxxly.top.gank.common.DividerItemDecoration;
import ttxxly.top.gank.entity.CategoryData;
import ttxxly.top.gank.modules.web.WebActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryContract.View {

    private RecyclerView mRv;
    private ViewGroup mContainer;
    private CategoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mContainer = container;
        //设置Android RecycleView
        mRv = view.findViewById(R.id.rv_fragment_category);
        mRv.setLayoutManager(new LinearLayoutManager(mContainer.getContext()));
        //设置分割线
        mRv.addItemDecoration(new DividerItemDecoration(mContainer.getContext(),
                DividerItemDecoration.VERTICAL_LIST));

        CategoryContract.Presenter presenter = new CategoryPresenter(this);
        presenter.start();
        return view;
    }

    @Override
    public void initData(CategoryData categorydata) {
        adapter = new CategoryAdapter(categorydata, mContainer);
        mRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //分类 Item click
                Toast.makeText(getContext(), adapter.getCategorydata().getResults().get
                        (position).getDesc(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContainer.getContext(), WebActivity.class);
                intent.putExtra("title", adapter.getCategorydata().getResults().get
                        (position).getDesc());
                intent.putExtra("content", adapter.getCategorydata().getResults().get
                        (position).getUrl());
                intent.putExtra("type", 1);
                startActivity(intent);
            }
        });
    }

    @Override
    public void addData(CategoryData categoryData) {
        adapter.addCategoryData(categoryData);
    }

    @Override
    public CategoryData getData() {
        return adapter.getCategorydata();
    }

    @Override
    public void setData(CategoryData categoryData) {
        adapter.setCategorydata(categoryData);
    }
}
