package com.example.geeknew.fragment;

import com.example.geeknew.R;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.presenter.GankPresenter;
import com.example.geeknew.presenter.ZhihuDailyNewsPresenter;
import com.example.geeknew.view.GankView;
import com.example.geeknew.view.ZhihuDailyNewsView;

public class GankFragment extends BaseFragment<GankView,GankPresenter>implements ZhihuDailyNewsView{

    protected GankPresenter initPresenter(){
    return new GankPresenter();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }
}
