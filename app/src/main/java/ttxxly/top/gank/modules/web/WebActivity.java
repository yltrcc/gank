package ttxxly.top.gank.modules.web;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ttxxly.top.gank.R;
import ttxxly.top.gank.modules.girl.GirlActivity;

public class WebActivity extends AppCompatActivity implements View.OnTouchListener{

    private String title;
    private String content;
    private ImageView mDelete;
    private TextView mTitle;
    private WebView mWeb;
    private List<String> list;
    private String empty;
    /**
     * 点击的坐标位置
     */
    float x,y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

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
        //加载 html 内容
        content = getHtmlData(content);
        Log.i("content", content);
        mWeb.loadDataWithBaseURL(null, content, "text/html", "utf-8",
                null);
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

    class JsInterface {
        Context context;

        public JsInterface(Context context) {
            this.context = context;
        }
        //查看图片url
        @JavascriptInterface
        public void click(String url){
            Intent intent = new Intent();
            intent.putExtra("url", url);
            intent.setClass(WebActivity.this, GirlActivity.class);
            startActivity(intent);
        }
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
                    } else {
                        mWeb.loadUrl(url);
                    }
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }




    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.i("OnTouch", "事件相应了");
        //通过webview的touch来响应web上的图片点击事件
        //屏幕密度
        float density = getResources().getDisplayMetrics().density;
        //必须除以屏幕密度
        float touchX = event.getX() / density;
        float touchY = event.getY() / density;
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            v.performClick();
            x = touchX;
            y = touchY;
        }

        if(event.getAction() == MotionEvent.ACTION_UP){
            float dx = Math.abs(touchX-x);
            float dy = Math.abs(touchY-y);
            if(dx<10.0/density&&dy<10.0/density){
                clickImage(touchX,touchY);
            }
        }
        return false;
    }

    private void clickImage(float touchX, float touchY) {
        //通过触控的位置来获取图片URL
        String js = "javascript:(function(){" +
                "var  obj=document.elementFromPoint("+touchX+","+touchY+");"
                +"if(obj.src!=null){"+ " window.imageClick.click(obj.src);}" +
                "})()";
        mWeb.loadUrl(js);
    }
}