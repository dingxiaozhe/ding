package com.example.geeknew.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.geeknew.R;
import com.example.geeknew.base.BaseActivity;
import com.example.geeknew.fragment.AboutFragment;
import com.example.geeknew.fragment.CollectFragment;
import com.example.geeknew.fragment.GankFragment;
import com.example.geeknew.fragment.GoldFragment;
import com.example.geeknew.fragment.SettingFragment;
import com.example.geeknew.fragment.V2exFragment;
import com.example.geeknew.fragment.WeChatFragment;
import com.example.geeknew.fragment.ZhihuDailyNewsFragment;
import com.example.geeknew.presenter.MainPresenter;
import com.example.geeknew.util.ToastUtil;
import com.example.geeknew.view.MainView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;

// 丁小哲  1808A
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.na)
    NavigationView na;
    @BindView(R.id.fragment_container)
    FrameLayout fragment_container;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;


    private ArrayList<Integer> mTitles;
    private ArrayList<Fragment> mFragments;
    private final int TYPE_ZHIHU = 0;
    private final int TYPE_WECHAT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_V2EX = 4;
    private final int TYPE_COLLECT = 5;
    private final int TYPE_SETTING = 6;
    private final int TYPE_ABOUT = 7;
    private int mLastFragmentPosition = 0;
    private FragmentManager mManager;
    private MenuItem mSearchItem;
    private String  querys;
    private WeChatFragment weChatFragment;


    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        mManager = getSupportFragmentManager();
        initToolbar();
        // initTitle();

        initFragments();
        addZhihuDailyNewsFragment();

    }



    private void addZhihuDailyNewsFragment() {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.fragment_container, mFragments.get(0));
        transaction.commit();
        // toolbar.setTitle(mTitles.get(0));

    }

    private void initToolbar() {
        toolbar.setTitle("知乎日报");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.app_name, R.string.app_name);
        //设置旋转开关颜色
        toogle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(toogle);
        toogle.syncState();
        na.setItemIconTintList(null);


    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new ZhihuDailyNewsFragment());
        weChatFragment = new WeChatFragment();
        mFragments.add(weChatFragment);
        mFragments.add(new GankFragment());
        mFragments.add(new GoldFragment());
        mFragments.add(new V2exFragment());
        mFragments.add(new CollectFragment());
        mFragments.add(new SettingFragment());
        mFragments.add(new AboutFragment());

    }

    private void initTitle() {
        mTitles = new ArrayList<>();
        mTitles.add(R.id.zhihu);
        mTitles.add(R.id.wechat);
        mTitles.add(R.id.gank);
        mTitles.add(R.id.gold);
        mTitles.add(R.id.v2ex);
        mTitles.add(R.id.collect);
        mTitles.add(R.id.settings);
        mTitles.add(R.id.about);

    }

    @Override
    protected void initListener() {
        super.initListener();
        na.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId != R.id.info_title && itemId != R.id.option_title) {
                    item.setChecked(true);
                    toolbar.setTitle(item.getTitle());
                    switch (itemId) {
                        case R.id.zhihu:
                            switchFragments(TYPE_ZHIHU);
                            break;
                        case R.id.wechat:
                            switchFragments(TYPE_WECHAT);
                            break;
                        case R.id.gank:
                            switchFragments(TYPE_GANK);
                            break;
                        case R.id.gold:
                            switchFragments(TYPE_GOLD);
                            break;
                        case R.id.v2ex:
                            switchFragments(TYPE_V2EX);
                            break;
                        case R.id.collect:
                            switchFragments(TYPE_COLLECT);
                            break;
                        case R.id.settings:
                            switchFragments(TYPE_SETTING);
                            break;
                        case R.id.about:
                            switchFragments(TYPE_ABOUT);
                            break;
                    }
                    dl.closeDrawer(Gravity.LEFT);
                } else {
                    item.setChecked(false);
                }
                return false;
            }
        });
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                querys= query;
                //提交搜索内容时的监听
               // ToastUtil.showShort("提交的内容:"+query);

                weChatFragment.query(querys);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //文本发生改变的监听
                ToastUtil.showShort(newText);
                return false;
            }
        });
        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //搜索框展开
                ToastUtil.showShort("展开");
            }

            @Override
            public void onSearchViewClosed() {
                //搜索框关闭
                ToastUtil.showShort("关闭");
            }
        });
        //显示提示信息
        //mSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));

    }

    private void switchFragments(int type) {
        //本质显示一个fragment,隐藏一个
        //要显示的fragment
        Fragment fragment = mFragments.get(type);
        //要隐藏的碎片
        Fragment hideFragment = mFragments.get(mLastFragmentPosition);
        FragmentTransaction transaction = mManager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fragment_container, fragment);
        }
        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();
        mLastFragmentPosition = type;

        //显示隐藏搜索框
        if (type == TYPE_WECHAT|| type== TYPE_GANK){
            mSearchItem.setVisible(true);
        }else {
            mSearchItem.setVisible(false);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        mSearchItem = menu.findItem(R.id.action_search);
        mSearchItem.setVisible(false);
        mSearchView.setMenuItem(mSearchItem);

        return true;
    }

    /**
     * 按回退键会调用这个方法
     */
    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
