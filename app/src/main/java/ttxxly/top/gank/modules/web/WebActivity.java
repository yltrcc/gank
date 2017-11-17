package ttxxly.top.gank.modules.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ttxxly.top.gank.R;
import ttxxly.top.gank.modules.girl.GirlActivity;

public class WebActivity extends AppCompatActivity implements WebContract.View {

    private String title;
    private String content;
    private WebView mWeb;
    private List<String> list;
    private String empty;
    private int type;
    private Toolbar mToolbar;
    private ProgressBar progressBar;
    private boolean flag = false;
    ;


    public class JsInterface {
        Context context;

        JsInterface(Context context) {
            this.context = context;
        }

        //查看图片url
        @JavascriptInterface
        public void click(String url) {
            Intent intent = new Intent();
            intent.putExtra("url", url);
            intent.setClass(WebActivity.this, GirlActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        type = intent.getIntExtra("type", 1);
        list = new ArrayList<>();

        mToolbar = findViewById(R.id.toolbar_main);
        mWeb = findViewById(R.id.wb_web);
        progressBar = findViewById(R.id.pb_web);

        WebContract.Presenter presenter = new WebPresenter(this);
        presenter.start();
    }


    /**
     * 拼接html字符串片段
     *
     * @param bodyHTML
     * @return
     */
    private String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, " +
                "user-scalable=no\"> " +
                "<style>img{max-width:100% !important; width:auto; height:auto;}</style>" +
                "</head>";
        return "<html>" + head + "<body style:'height:auto;max-width: 100%; width:auto;'>" +
                bodyHTML + "</body></html>";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public void setToolBar() {
        mToolbar.setTitle(title);
        //设置导航图标、添加菜单点击事件要在setSupportActionBar方法之后
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_webview_delete);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.web_refresh:
                        mWeb.loadDataWithBaseURL(null, content, "text/html", "utf-8",
                                null);
                        //mWeb.reload();
                        break;
                    case R.id.web_full_screen:
                        Toast.makeText(WebActivity.this, "全屏浏览", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.web_share:
                        Toast.makeText(WebActivity.this, "分享 !", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.web_copy:
                        Toast.makeText(WebActivity.this, "复制链接 !", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.web_launch:
                        Toast.makeText(WebActivity.this, "启动外部浏览器 !", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(WebActivity.this, "什么情况啊", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });

        //删除当前页面的事件监听
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void initWebView() {
        //设置WebView属性，能够执行JavaScript脚本
        mWeb.getSettings().setJavaScriptEnabled(true);
        //JS交互
        mWeb.addJavascriptInterface(new JsInterface(this), "click");
        //设置可以支持缩放
        mWeb.getSettings().setSupportZoom(true);
        //设置使用内置缩放机制
        mWeb.getSettings().setBuiltInZoomControls(true);
        //设置不显示右下角缩放控件
        mWeb.getSettings().setDisplayZoomControls(false);
        // 设置WebView是否应该支持“viewport”HTML元标记
        mWeb.getSettings().setUseWideViewPort(true);
        //设置缓存
        mWeb.getSettings().setAppCacheEnabled(false);
        //清空缓存
        mWeb.clearCache(true);
        //根据类型来加载 html 内容， 因为可能是 HTML 文件， 也可能是 URL
        if (type == 0) {
            content = getHtmlData(content);
            Log.i("content", content);
            mWeb.loadDataWithBaseURL(null, content, "text/html", "utf-8",
                    null);
        } else if (type == 1) {
            mWeb.loadUrl(content);
        }

    }

    @Override
    public void setWebViewClient() {
        //处理各种事件
        mWeb.setWebViewClient(new WebViewClient() {
            // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.i("11111111url", "" + view.getUrl());
                view.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
                mWeb.loadUrl(view.getUrl());
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                list.add(view.getUrl());
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }


            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                super.doUpdateVisitedHistory(view, url, isReload);
            }
        });
    }

    @Override
    public void setWebChromeClient() {
        //获取标题、图标等, 每加载一次就获取一次
        mWeb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                Log.i("111111111title", title);
                mToolbar.setTitle(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    //加载完网页进度条消失
                    progressBar.setVisibility(View.GONE);
                } else {
                    //开始加载网页时显示进度条
                    progressBar.setVisibility(View.VISIBLE);
                    //设置进度值
                    progressBar.setProgress(newProgress);
                }
            }

            @Override
            public void getVisitedHistory(ValueCallback<String[]> callback) {
                super.getVisitedHistory(callback);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWeb.canGoBack()) {
                mWeb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                mWeb.goBack();
                return true;
            } else if (!flag) {
                mWeb.loadDataWithBaseURL(null, content, "text/html", "utf-8",
                        null);
                flag = true;
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}