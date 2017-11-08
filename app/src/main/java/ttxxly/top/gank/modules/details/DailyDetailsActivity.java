package ttxxly.top.gank.modules.details;

import android.content.Intent;
import android.graphics.Bitmap;
import android.mtp.MtpConstants;
import android.service.quicksettings.Tile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ttxxly.top.gank.R;

public class DailyDetailsActivity extends AppCompatActivity {

    private String title;
    private String content;
    private ImageView mDelete;
    private TextView mTitle;
    private WebView mWeb;
    private List<String> list;
    private String empty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_details);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        list = new ArrayList<>();

        mDelete = findViewById(R.id.iv_delete);
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitle = findViewById(R.id.tv_title);
        mTitle.setText(title);
        mWeb = findViewById(R.id.wb_daily_detail);
        mWeb.loadDataWithBaseURL(null, content, "text/html", "utf-8",
                null);
        // 设置可以支持缩放
        mWeb.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        mWeb.getSettings().setBuiltInZoomControls(false);
        //扩大比例的缩放
        mWeb.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        mWeb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWeb.getSettings().setLoadWithOverviewMode(true);
        mWeb.getSettings().setDefaultFontSize(30);
        //处理各种事件
        mWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.i("11111111url", "" + url);
                list.add(url);
            }
        });
        //获取标题、图标等, 每加载一次就获取一次
        mWeb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                Log.i("111111111title", title);
                mTitle.setText(title);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWeb.canGoBack()) {
                if (list.size() > 1) {
                    //重新加载之前的页面,这里为了让标题也能正常显示
                    String url = list.get(list.size() - 2);
                    empty = "about:blank";
                    list.remove(list.size() - 1);
                    if (list.size() > 0) {
                        list.remove(list.size() - 1);
                    }
                    if (url.equals(empty)) {
                        mWeb.loadDataWithBaseURL(null, content, "text/html", "utf-8",
                                null);
                        mWeb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                        mWeb.getSettings().setLoadWithOverviewMode(true);
                        mWeb.getSettings().setDefaultFontSize(16);
                    } else {
                        mWeb.loadUrl(url);
                    }

                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}