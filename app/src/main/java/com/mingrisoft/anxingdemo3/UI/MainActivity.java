package com.mingrisoft.anxingdemo3.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.mingrisoft.anxingdemo3.R;
import com.mingrisoft.anxingdemo3.UI.fragment.FragmentFirstPage;
import com.mingrisoft.anxingdemo3.UI.fragment.FragmentMap;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FragmentFirstPage fragmentFirstPage;
    private FragmentMap fragmentMap;
    private FrameLayout lfp,lmp;
    private ImageView ifp,imp;
    private ImageView tton,pton;
    private PopupWindow popWindows;
    private DisplayMetrics dm;
    ImageView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        clickAt();
        slidskip();
    }
    /*
    time:2018.5.13
    editer:书豪
    mean：初始化按钮
    */
    private void initView()
    {

        drawerLayout = (DrawerLayout) findViewById(R.id.activity_Mainpage);
        navigationView = (NavigationView) findViewById(R.id.SlideMainlayout);
        menu= (ImageView) findViewById(R.id.UserIconMenu);
        lfp = findViewById(R.id.layout_firstpage);
        lmp=findViewById(R.id.layout_map);

        ifp=findViewById(R.id.image_firstpage);
        imp=findViewById(R.id.image_map);

        tton=findViewById(R.id.toggle_btn);
        pton=findViewById(R.id.plus_btn);
    }
    /*
   time:2018.5.13
   editer:书豪
   mean：初始化点击事件
   */
    private void initData()
    {
        lfp.setOnClickListener((View.OnClickListener)this);
        lmp.setOnClickListener((View.OnClickListener) this);
        tton.setOnClickListener((View.OnClickListener) this);
    }
    /*
    time:2018.5.13
    editer:书豪
    mean：非菜单点击事件
   */
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.layout_firstpage:
                clickAt();
                break;
            case R.id.layout_map:
                clickAuth();
                break;
            case R.id.toggle_btn:
                clickTog();
                break;
            case R.id.UserIconMenu://点击菜单，跳出侧滑菜单
                if (drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }else{
                    drawerLayout.openDrawer(navigationView);
                }
                break;
        }
    }
    /*
    time:2018.5.13
    editer:书豪
    mean：首页点击事件
   */
    public void clickAt()
    {
        fragmentFirstPage =new FragmentFirstPage();
        android.support.v4.app.FragmentTransaction fragmentTransaction =this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_framecontent, fragmentFirstPage);
        fragmentTransaction.commit();
        lfp.setSelected(true);
        ifp.setSelected(true);

        lmp.setSelected(false);
        imp.setSelected(false);
    }
    /*
      time:2018.5.13
      editer:书豪
      mean：菜单点击事件（优化）
      */
    public void slidskip()
    {
        View headerView = navigationView.getHeaderView(0);
        menu.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.userInfo:
                        Intent intent1 = new Intent(getBaseContext(),Userinfo.class);
                        startActivity(intent1);
                        break;
                    case R.id.urgencyconnerter:
                        Intent intent2 = new Intent(MainActivity.this, UrgencyConnect.class);
                        startActivity(intent2);
                        break;
                    case R.id.Indt:
                        Intent intent3 = new Intent(MainActivity.this, AutonymAttestion.class);
                        startActivity(intent3);
                        break;
                    case R.id.axingconnerter:
                        Intent intent4 = new Intent(MainActivity.this, AxConnecter.class);
                        startActivity(intent4);
                        break;
                    case R.id.systemmessage:
                        Intent intent5 = new Intent(MainActivity.this, SystemInfo.class);
                        startActivity(intent5);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
    /*
    time:2018.5.13
    editer:书豪
    mean：地图点击事件
   */
    public void clickAuth()
    {
        fragmentMap =new FragmentMap();
        android.support.v4.app.FragmentTransaction fragmentTransaction =this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_framecontent, fragmentMap);
        fragmentTransaction.commit();
        lmp.setSelected(true);
        imp.setSelected(true);

        lfp.setSelected(false);
        ifp.setSelected(false);
    }
    /*
    time:2018.5.13
    editer:书豪
    mean：“+”点击
   */
    public void clickTog()
    {
        showpopwindows(tton);
        pton.setSelected(true);
    }

    public void chageButtonImage()
    {
        pton.setSelected(false);
    }
    /*
    time:2018.5.13
    editer:书豪
    mean：显示弹窗
   */
    private void showpopwindows(View parent) {
        if(popWindows==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.popwindows,null);
            dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            popWindows = new PopupWindow(view,dm.widthPixels, LinearLayout.LayoutParams.WRAP_CONTENT);
        }
        popWindows.setFocusable(true);

        popWindows.setOutsideTouchable(true);

        popWindows.setBackgroundDrawable(new BitmapDrawable());


        popWindows.showAsDropDown(parent, 0,0);

        popWindows.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                chageButtonImage();
            }
        });
        popWindows.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {

                chageButtonImage();
                popWindows.dismiss();
                return false;
            }
        });
    }
}
