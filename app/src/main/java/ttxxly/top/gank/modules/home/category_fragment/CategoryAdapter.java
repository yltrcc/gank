package ttxxly.top.gank.modules.home.category_fragment;


import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import ttxxly.top.gank.R;
import ttxxly.top.gank.entity.CategoryData;

/**
 * Description:
 * date: 2017/11/13 21:09
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> implements
        View.OnClickListener {

    private CategoryData categorydata;
    private ViewGroup mContainer = null;
    private OnItemClickListener mOnItemClickListener = null;
    private boolean flag;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public CategoryAdapter(CategoryData categorydata, ViewGroup container) {
        this.categorydata = categorydata;
        Log.i("size", categorydata.getResults().size()+"");
        this.mContainer = container;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                mContainer.getContext()).inflate(R.layout.item_fragment_custom, parent,
                false);
        CategoryAdapter.MyViewHolder holder = new CategoryAdapter.MyViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CategoryAdapter.MyViewHolder holder, int position) {
        //绑定数据
        if (!categorydata.getResults().get(position).isEmptyTitle()) {
            Log.i("title", categorydata.getResults().get(position).getDesc());
            holder.title.setText(categorydata.getResults().get(position).getDesc());
        }else {
            holder.title.setText("It doesn't seem to have a title");
        }

        if (!categorydata.getResults().get(position).isEmptyWho()) {
            Log.i("author", categorydata.getResults().get(position).getWho());
            holder.author.setText(categorydata.getResults().get(position).getWho());
        }else {
            holder.author.setText("damajia");
        }

        if (!categorydata.getResults().get(position).isEmptyDate()) {
            Log.i("date", categorydata.getResults().get(position).getPublishedAt());
            holder.date.setText(categorydata.getResults().get(position).getPublishedAt());
        }else {
            holder.date.setText("null");
        }
        if (!categorydata.getResults().get(position).isEmptyImg()) {
            String url = categorydata.getResults().get(position).getImages().get(0);
            flag = false;
            try {
                Picasso.with(mContainer.getContext())
                        .load(url)
                        .into(holder.img, new Callback() {
                            @Override
                            public void onSuccess() {
                                Log.i("启动页图片", "成功");
                                flag = true;
                            }

                            @Override
                            public void onError() {
                                Log.i("启动页图片", "失败1");
                                flag = false;
                            }
                        });
            } catch (Exception e) {
                Log.i("启动页图片", "失败2");
                flag = false;
            }
            if (flag){
                holder.img.setVisibility(View.VISIBLE);
            }
        }
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return categorydata.getResults().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView title;
        private final TextView author;
        private final TextView date;
        private final ImageView img;

        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_item_custom_title);
            author = view.findViewById(R.id.tv_item_custom_publisher);
            date = view.findViewById(R.id.tv_item_custom_time);
            img = view.findViewById(R.id.img_item_custom);
        }

    }
}