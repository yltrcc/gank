package ttxxly.top.gank.modules.category;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ttxxly.top.gank.R;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private RecyclerView mRvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        mToolBar = findViewById(R.id.toolbar_category);
        mToolBar.setTitle(title);
        mToolBar.setNavigationIcon(R.drawable.ic_webview_delete);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRvCategory = findViewById(R.id.rv_category);
    }
}
