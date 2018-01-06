package ttxxly.top.gank.modules.home.girls_fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import ttxxly.top.gank.R;
import ttxxly.top.gank.entity.CategoryData;
import ttxxly.top.gank.modules.girl.GirlActivity;

/**
 * Description:
 * date: 2017/11/21 18:42
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class GirlsAdapter extends RecyclerView.Adapter {
    private int[] data;
    private ViewGroup mContainer;

    public GirlsAdapter(int[] data, ViewGroup container) {
        this.data = data;
        this.mContainer = container;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                mContainer.getContext()).inflate(R.layout.item_category_girls, parent,
                false);
        return new BodyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BodyHolder bodyHolder = (BodyHolder) holder;
        bodyHolder.imageView.setImageResource(data[position]);
        bodyHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContainer.getContext(),
                        GirlActivity.class);
                intent.putExtra("url", "http://img.361games.com/file/tu/show/q2ri4a1kov4.jpg");
                mContainer.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class BodyHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public BodyHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_item_girls_girls);
        }
    }
}
