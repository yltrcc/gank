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

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private CategoryData categorydata;
    private ViewGroup mContainer = null;
    private OnItemClickListener mOnItemClickListener = null;
    private boolean flag;
    private static int TYPE_NO_TITLE = 0;
    private static int TYPE_WITH_TITLE = 1;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public CategoryAdapter(CategoryData categorydata, ViewGroup container) {
        this.categorydata = categorydata;
        Log.i("size", categorydata.getResults().size()+"");
        this.mContainer = container;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NO_TITLE) {
            View view = LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_fragment_custom, parent,
                    false);
            return new NoTitleHolder(view);
        }
        if (viewType == TYPE_WITH_TITLE) {
            View view = LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_fragment_custom_with_title, parent,
                    false);
            return new WithTitleHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NoTitleHolder) {
            NoTitleHolder notitleHolder = (NoTitleHolder) holder;
            //绑定数据
            if (!categorydata.getResults().get(position).isEmptyTitle()) {
                Log.i("title", categorydata.getResults().get(position).getDesc());
                notitleHolder.title.setText(categorydata.getResults().get(position).getDesc());
            }else {
                notitleHolder.title.setText("It doesn't seem to have a title");
            }

            if (!categorydata.getResults().get(position).isEmptyWho()) {
                Log.i("author", categorydata.getResults().get(position).getWho());
                notitleHolder.author.setText(categorydata.getResults().get(position).getWho());
            }else {
                notitleHolder.author.setText("damajia");
            }

            if (!categorydata.getResults().get(position).isEmptyDate()) {
                Log.i("date", categorydata.getResults().get(position).getPublishedAt());
                notitleHolder.date.setText(categorydata.getResults().get(position).getPublishedAt());
            }else {
                notitleHolder.date.setText("null");
            }
            if (!categorydata.getResults().get(position).isEmptyImg()) {
                String url = categorydata.getResults().get(position).getImages().get(0);
                flag = false;
                try {
                    Picasso.with(mContainer.getContext())
                            .load(url)
                            .into(notitleHolder.img, new Callback() {
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
                    notitleHolder.img.setVisibility(View.VISIBLE);
                }
            }
        }

        if (holder instanceof WithTitleHolder) {
            WithTitleHolder withTitleHolder = (WithTitleHolder) holder;
            //设置Category
            if (position % 10 == 0 ) {
                if (position / 10 == 0) {
                    withTitleHolder.category.setText("Android");
                }else if (position / 10 == 1) {
                    withTitleHolder.category.setText("Ios");
                }else if (position / 10 == 2) {
                    withTitleHolder.category.setText("福利");
                }else if (position / 10 == 3) {
                    withTitleHolder.category.setText("视频");
                }else if (position / 10 == 4) {
                    withTitleHolder.category.setText("前端");
                }
            }

            //绑定数据
            if (!categorydata.getResults().get(position).isEmptyTitle()) {
                Log.i("title", categorydata.getResults().get(position).getDesc());
                withTitleHolder.title.setText(categorydata.getResults().get(position).getDesc());
            }else {
                withTitleHolder.title.setText("It doesn't seem to have a title");
            }

            if (!categorydata.getResults().get(position).isEmptyWho()) {
                Log.i("author", categorydata.getResults().get(position).getWho());
                withTitleHolder.author.setText(categorydata.getResults().get(position).getWho());
            }else {
                withTitleHolder.author.setText("damajia");
            }

            if (!categorydata.getResults().get(position).isEmptyDate()) {
                Log.i("date", categorydata.getResults().get(position).getPublishedAt());
                withTitleHolder.date.setText(categorydata.getResults().get(position).getPublishedAt());
            }else {
                withTitleHolder.date.setText("null");
            }
            if (!categorydata.getResults().get(position).isEmptyImg()) {
                String url = categorydata.getResults().get(position).getImages().get(0);
                flag = false;
                try {
                    Picasso.with(mContainer.getContext())
                            .load(url)
                            .into(withTitleHolder.img, new Callback() {
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
                    withTitleHolder.img.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return categorydata.getResults().size();
    }

    class NoTitleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private final TextView title;
        private final TextView author;
        private final TextView date;
        private final ImageView img;

        NoTitleHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item_custom_title);
            author = itemView.findViewById(R.id.tv_item_custom_publisher);
            date = itemView.findViewById(R.id.tv_item_custom_time);
            img = itemView.findViewById(R.id.img_item_custom);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }
    class WithTitleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView title;
        private final TextView author;
        private final TextView date;
        private final ImageView img;
        private final TextView category;

        public WithTitleHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item_custom_with_title_title);
            author = itemView.findViewById(R.id.tv_item_custom_with_title_publisher);
            date = itemView.findViewById(R.id.tv_item_custom_with_title_time);
            img = itemView.findViewById(R.id.img_item_custom_with_title);
            category = itemView.findViewById(R.id.tv_item_custom_with_title_category_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }

    public void addCategoryData(CategoryData data) {
        categorydata.getResults().addAll(data.getResults());
    }

    public CategoryData getCategorydata() {
        return categorydata;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 10 == 0) {
            return TYPE_WITH_TITLE;
        }else {
            return TYPE_NO_TITLE;
        }

    }
}