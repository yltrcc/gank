package ttxxly.top.gank.modules.girl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import ttxxly.top.gank.R;

public class GirlActivity extends AppCompatActivity {

    private ImageView mDelete;
    private RelativeLayout mRoot;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_girl);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");

        mRoot = findViewById(R.id.root_girl);
        mDelete = findViewById(R.id.iv_girl_delete);
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loadImg();
    }

    public void loadImg() {

        mRoot.setBackgroundResource(R.mipmap.timg);

    }
}
