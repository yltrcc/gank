package ttxxly.top.gank.modules.about;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import ttxxly.top.gank.R;

public class AboutActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mToolbar = findViewById(R.id.tl_about);
        mVersion = findViewById(R.id.tv_version);

        // ---get the package info---
        PackageManager pm = getApplicationContext().getPackageManager();
        PackageInfo pi = null;
        try {
            pi = pm.getPackageInfo(getApplicationContext().getPackageName(), 0);
            mVersion.setText(pi.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mToolbar.setTitle("关于");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_webview_delete);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
