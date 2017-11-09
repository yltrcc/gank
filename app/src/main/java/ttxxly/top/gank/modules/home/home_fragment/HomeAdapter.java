package ttxxly.top.gank.modules.home.home_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ttxxly.top.gank.R;
import ttxxly.top.gank.entity.DailyData;

/**
 * Description:
 * date: 2017/11/07 15:04
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener{

    private DailyData dailyData;
    private ViewGroup mContainer = null;
    private OnItemClickListener mOnItemClickListener = null;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public HomeAdapter(DailyData dailyData, ViewGroup container) {
        this.dailyData = dailyData;
        this.mContainer = container;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                mContainer.getContext()).inflate(R.layout.item_home, parent,
                false);
        MyViewHolder holder = new MyViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(dailyData.getResults().get(position).getTitle());
        holder.author.setText("daimajia");
        holder.date.setText(dailyData.getResults().get(position).getPublishedAt());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return dailyData.getResults().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView title;
        private final TextView author;
        private final TextView date;

        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_item_title);
            author = view.findViewById(R.id.tv_item_publisher);
            date = view.findViewById(R.id.tv_item_time);
        }
    }

    public void addDailyData(DailyData data) {
        dailyData.getResults().addAll(data.getResults());
    }


    public DailyData getDailyData() {
        return dailyData;
    }
}