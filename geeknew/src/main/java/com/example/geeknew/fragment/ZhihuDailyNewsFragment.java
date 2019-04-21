package com.example.geeknew.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geeknew.R;
import com.example.geeknew.adapter.VpZhihuAdapter;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.presenter.ZhihuDailyNewsPresenter;
import com.example.geeknew.view.ZhihuDailyNewsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhihuDailyNewsFragment extends BaseFragment<ZhihuDailyNewsView, ZhihuDailyNewsPresenter> implements ZhihuDailyNewsView {
// 丁小哲  1808A
    @BindView(R.id.tablayout)
     TabLayout tablayout;
    @BindView(R.id.viewpager)
     ViewPager viewpager;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<Integer> mTitles;
    protected ZhihuDailyNewsPresenter initPresenter() {

        return new ZhihuDailyNewsPresenter();
    }

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_zhihu_daily_news;
    }

    @Override
    protected void initView() {
        super.initView();
        initTitle();
        initFragments();
        VpZhihuAdapter adapter = new VpZhihuAdapter(getContext(), getChildFragmentManager(), mFragments, mTitles);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    private void initFragments() {
        mFragments=new ArrayList<>();
        mFragments.add(new DailyNewsFragment());
       mFragments.add(new HotFragment());
        mFragments.add(new SectionsFragmnet());
        mFragments.add(new HotFragment());
    }

    private void initTitle() {
        mTitles=new ArrayList<>();
        mTitles.add(R.string.dailyNews);
        mTitles.add(R.string.theme);
        mTitles.add(R.string.sections);
        mTitles.add(R.string.hot);


    }
}
