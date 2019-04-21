package com.example.geeknew.fragment;

import com.example.geeknew.R;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.presenter.EmptyPresenter;
import com.example.geeknew.presenter.ZhihuDailyNewsPresenter;
import com.example.geeknew.view.EmptyView;
import com.example.geeknew.view.ZhihuDailyNewsView;

public class CollectFragment extends BaseFragment<EmptyView,EmptyPresenter>implements ZhihuDailyNewsView{

    protected EmptyPresenter initPresenter(){
    return new EmptyPresenter();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }
}
