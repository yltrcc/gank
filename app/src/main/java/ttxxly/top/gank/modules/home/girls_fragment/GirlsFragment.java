package ttxxly.top.gank.modules.home.girls_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ttxxly.top.gank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GirlsFragment extends Fragment {


    private RecyclerView mRv;
    private int[] data = {R.mipmap.timg, R.mipmap.timg, R.mipmap.timg, R.mipmap.timg, R.mipmap
            .timg, R.mipmap.timg, R.mipmap.timg, R.mipmap.timg, R.mipmap.timg, R.mipmap.timg};

    public GirlsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_girls, container, false);
        mRv = view.findViewById(R.id.rv_fragment_girls);
        mRv.setAdapter(new GirlsAdapter(data, container));

        //设置layoutManager
        GridLayoutManager layoutManager = new GridLayoutManager(container.getContext(), 2);
        //把LayoutManager设置给RecyclerView
        mRv.setLayoutManager(layoutManager);
        return view;
    }

}
