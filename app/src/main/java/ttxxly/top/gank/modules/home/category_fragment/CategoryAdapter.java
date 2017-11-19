package ttxxly.top.gank.modules.home.category_fragment;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import retrofit2.http.HEAD;
import ttxxly.top.gank.R;
import ttxxly.top.gank.entity.CategoryData;
import ttxxly.top.gank.modules.category.CategoryActivity;

/**
 * Description:
 * date: 2017/11/13 21:09
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private CategoryData categorydata;
    private ViewGroup mContainer = null;
    private OnItemClickListener mOnItemClickListener = null;
    private boolean flag;
    private static int TYPE_NO_TITLE = 0;
    private static int TYPE_WITH_TITLE = 1;
    private static int TYPE_HEADER = 3;
    private String ANDROID = "Android";
    private String IOS = "iOS";
    private String WELFARE = "福利";
    private String VIDEO = "休息视频";
    private String HTML5 = "前端";


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public CategoryAdapter(CategoryData categorydata, ViewGroup container) {
        this.categorydata = categorydata;
        Log.i("size", categorydata.getResults().size() + "");
        this.mContainer = container;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NO_TITLE) {
            View view = LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_category_body, parent,
                    false);
            return new NoTitleHolder(view);
        } else if (viewType == TYPE_WITH_TITLE) {
            View view = LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_category_title, parent,
                    false);
            return new WithTitleHolder(view);
        } else if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(
                    mContainer.getContext()).inflate(R.layout.item_category_header, parent,
                    false);
            return new HeaderHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.i("position" + position, "" + categorydata.getResults().get(position).getDesc());
        if (holder instanceof NoTitleHolder) {
            NoTitleHolder notitleHolder = (NoTitleHolder) holder;
            //绑定数据
            if (!categorydata.getResults().get(position).isEmptyTitle()) {
                Log.i("title", categorydata.getResults().get(position).getDesc());
                notitleHolder.title.setText(categorydata.getResults().get(position).getDesc());
            } else {
                notitleHolder.title.setText("It doesn't seem to have a title");
            }

            if (!categorydata.getResults().get(position).isEmptyWho()) {
                Log.i("author", categorydata.getResults().get(position).getWho());
                notitleHolder.author.setText(categorydata.getResults().get(position).getWho());
            } else {
                notitleHolder.author.setText("damajia");
            }

            if (!categorydata.getResults().get(position).isEmptyDate()) {
                Log.i("date", categorydata.getResults().get(position).getPublishedAt());
                notitleHolder.date.setText(categorydata.getResults().get(position).getPublishedAt
                        ());
            } else {
                notitleHolder.date.setText("null");
            }
            if (!categorydata.getResults().get(position).isEmptyImg()) {
                notitleHolder.img.setVisibility(View.VISIBLE);
                String url = categorydata.getResults().get(position).getImages().get(0);
                try {
                    Picasso.with(mContainer.getContext())
                            .load(url)
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .into(notitleHolder.img, new Callback() {
                                @Override
                                public void onSuccess() {
                                    Log.i("启动页图片", "成功");
                                }

                                @Override
                                public void onError() {
                                    Log.i("启动页图片", "失败1");
                                }
                            });
                } catch (Exception e) {
                    Log.i("启动页图片", "失败2");
                }
            }
        } else if (holder instanceof WithTitleHolder) {
            String title = null;
            WithTitleHolder withTitleHolder = (WithTitleHolder) holder;
            if (!categorydata.getResults().get(position).isEmptyTitle()) {
                title = categorydata.getResults().get(position).getDesc();
                Log.i("title", title);
                withTitleHolder.title.setText(title);
            } else {
                title = "It doesn't seem to have a title";
                withTitleHolder.title.setText(title);
            }
            final String finalTitle = title;
            withTitleHolder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ANDROID.equals(finalTitle)) {
                        Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                        intent.putExtra("title", ANDROID);
                        mContainer.getContext().startActivity(intent);
                    } else if (IOS.equals(finalTitle)) {
                        Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                        intent.putExtra("title", IOS);
                        mContainer.getContext().startActivity(intent);
                    } else if (WELFARE.equals(finalTitle)) {
                        Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                        intent.putExtra("title", WELFARE);
                        mContainer.getContext().startActivity(intent);
                    } else if (VIDEO.equals(finalTitle)) {
                        Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                        intent.putExtra("title", VIDEO);
                        mContainer.getContext().startActivity(intent);
                    } else if (HTML5.equals(finalTitle)) {
                        Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                        intent.putExtra("title", HTML5);
                        mContainer.getContext().startActivity(intent);
                    }
                }
            });
        } else if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            headerHolder.mAndroid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Android",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                    intent.putExtra("title", "Android");
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mIos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Ios",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                    intent.putExtra("title", IOS);
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mWelfare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Welfare",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                    intent.putExtra("title", WELFARE);
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Video",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                    intent.putExtra("title", VIDEO);
                    mContainer.getContext().startActivity(intent);
                }
            });
            headerHolder.mHtml5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContainer.getContext(), "Html5",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContainer.getContext(), CategoryActivity.class);
                    intent.putExtra("title", HTML5);
                    mContainer.getContext().startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        Log.i("size", categorydata.getResults().size() + "");
        return categorydata.getResults().size();
    }

    class NoTitleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


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

    class WithTitleHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView more;

        public WithTitleHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_category_title_title);
            more = itemView.findViewById(R.id.tv_category_title_more);
        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder {

        private final LinearLayout mAndroid;
        private final LinearLayout mIos;
        private final LinearLayout mWelfare;
        private final LinearLayout mVideo;
        private final LinearLayout mHtml5;

        public HeaderHolder(View itemView) {
            super(itemView);
            mAndroid = itemView.findViewById(R.id.ll_item_category_header_android);
            mIos = itemView.findViewById(R.id.ll_item_category_header_ios);
            mWelfare = itemView.findViewById(R.id.ll_item_category_header_welfare);
            mVideo = itemView.findViewById(R.id.ll_item_category_header_video);
            mHtml5 = itemView.findViewById(R.id.ll_item_category_header_html5);
        }
    }

    public void addCategoryData(CategoryData data) {
        categorydata.getResults().addAll(data.getResults());
    }

    public CategoryData getCategorydata() {
        return categorydata;
    }

    public void setCategorydata(CategoryData categorydata) {
        this.categorydata = categorydata;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position % 11 == 1) {
            return TYPE_WITH_TITLE;
        } else {
            return TYPE_NO_TITLE;
        }

    }
}