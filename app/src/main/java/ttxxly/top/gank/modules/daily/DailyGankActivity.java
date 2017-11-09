package ttxxly.top.gank.modules.daily;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ttxxly.top.gank.R;
import ttxxly.top.gank.modules.girl.GirlActivity;

public class DailyGankActivity extends AppCompatActivity implements DailyGankContract.View{

    private DailyGankContract.Presenter presenter;
    private ImageView mDelete;
    private TextView mTitle;
    private ImageView mGirl;
    private String title;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_gank);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        String year = intent.getStringExtra("year");
        String month = intent.getStringExtra("month");
        String day = intent.getStringExtra("day");

        mDelete = findViewById(R.id.iv_daily_gank_delete);
        mTitle = findViewById(R.id.tv_daily_gank_title);
        mGirl = findViewById(R.id.iv_daily_gank_girl);

        //绑定
        presenter = new DailyGankPresenter(this, year, month, day);
        presenter.start();
    }

    @Override
    public void setDeleteClickListener() {
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void setTitle() {
        mTitle.setText(title);
    }

    @Override
    public void setImgClickListener() {
        mGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到 GirlActivity 显示 Girl 完整大图
                Intent intent = new Intent(getApplicationContext(), GirlActivity.class);
                if (url != null) {
                    intent.putExtra("url", url);
                }else {
                    intent.putExtra("url", presenter.setUrl());
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void getUrl(String url) {
        this.url = url;
    }
}
