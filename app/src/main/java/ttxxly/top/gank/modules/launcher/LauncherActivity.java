package ttxxly.top.gank.modules.launcher;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import ttxxly.top.gank.R;
import ttxxly.top.gank.modules.home.HomeActivity;

/**
 * APP 启动页
 *
 * @author ttxxly
 * @date 2017年11月3日10:28:44
 */
public class LauncherActivity extends AppCompatActivity implements LauncherContract.View{

    private boolean isResume;
    private LauncherContract.Presenter mPresenter = new LauncherPresenter(this);
    private ImageView mIvLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);
        mIvLauncher = findViewById(R.id.iv_launcher);
        mPresenter.start();
    }


    @Override
    public void goHomeActivity() {
        Intent intent = new Intent(LauncherActivity.this, HomeActivity.class);
        startActivity(intent);
        // Activity 切换淡入淡出动画
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    @Override
    public void loadImg(String url) {
        Handler handler = new Handler();
        //1.5 秒后執行
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isResume) {
                    finish();
                    return;
                }
                goHomeActivity();
            }
        }, 1500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isResume = false;
        mPresenter.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isResume = true;
    }
}
