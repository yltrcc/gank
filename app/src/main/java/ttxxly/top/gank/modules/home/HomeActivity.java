package ttxxly.top.gank.modules.home;

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
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import ttxxly.top.gank.R;
import ttxxly.top.gank.modules.home.fragment.HomeFragment;


/**
 * Description: APP 首页
 * date: 2017/11/03 12:01
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */
public class HomeActivity extends AppCompatActivity{

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
    private ViewPager vp_home;

    /**
     * Fragment 容器
     */
    private ArrayList<android.support.v4.app.Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        //设置头像
        mPortrait = findViewById(R.id.portrait);
        if (mPortrait != null) {
            setPortrait();
        }

        //设置抽屉导航
        mDrawerLayout = findViewById(R.id.drawer_layout);
        if (mDrawerLayout != null) {
            setDrawerListener();
        }
        //设置抽屉菜单事件侦听
        mDrawerLayoutLeft = findViewById(R.id.drawer_layout_left);
        if (mDrawerLayoutLeft != null) {
            setNavigationItemSelectedListener();
        }
        //设置ViewPager
        mHomePage = findViewById(R.id.home_page);
        vp_home = findViewById(R.id.vp_home);
        list = new ArrayList<>();
        list.add(new HomeFragment());
        vp_home.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), list));

    }


    public void setPortrait() {
        mPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    public void setNavigationItemSelectedListener() {
        mDrawerLayoutLeft.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            /**
             * @param item
             * @return
             */
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
                //关闭抽屉
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    public void setDrawerListener() {
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
}