package ttxxly.top.gank;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 整个应用的主Activity
 *
 * @author ttxxly
 * @date 2017年10月29日15:34:50
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 首页头像
     */
    private CircleImageView mPortrait;

    /**
     * 根布局（包含抽屉视图、首页视图）
     */
    private DrawerLayout mDrawerLayout;

    /**
     * 左侧抽屉视图
     */
    private NavigationView mDrawerLayoutLeft;

    /**
     * 抽屉是否打开
     */
    boolean isOpenDrawer = false;

    /**
     * 首页, 现在是 RelativeLayout， 如果 根布局发生变化，记得修改
     */
    private LinearLayout mHomePage;

    /**
     * ViewPager，容器，填充 Fragment
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        mPortrait = findViewById(R.id.portrait);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayoutLeft = findViewById(R.id.drawer_layout_left);
        mHomePage = findViewById(R.id.home_page);
        mViewPager = findViewById(R.id.vp_home);

        if (mPortrait != null) {
            setPortrait();
        }
        if (mDrawerLayout != null) {
            setDrawerLayout();
        }
        if (mDrawerLayoutLeft != null) {
            setDrawerLayoutLeft();
        }

    }


    private void setDrawerLayoutLeft() {
        mDrawerLayoutLeft.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home_page:
                        //做相应的操作
                        break;
                    case R.id.nav_all:
                        break;
                    case R.id.nav_girls:
                        break;
                    case R.id.nav_about:
                        break;
                    default:
                        break;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START); //关闭抽屉
                return true;
            }
        });
    }

    /**
     * 抽屉的滑动事件监听
     */
    private void setDrawerLayout() {
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                isOpenDrawer = true;
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                mHomePage.layout(mDrawerLayoutLeft.getRight(), 0, mDrawerLayoutLeft.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    /**
     * 点击头像，打开侧边抽屉
     */
    private void setPortrait() {
        mPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



}