package com.example.geeknew.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseMvpView,P extends BasePresenter>extends Fragment implements BaseMvpView{

    protected  P mPresenter;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate=inflater.inflate(getLayoutId(),null);
        mUnbinder = ButterKnife.bind(this, inflate);
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.bind(this);
        }
        initView();
        initListener();
        initData();
        return inflate;
    }


    protected void initData() {
    }

    protected void initListener() {
    }

    protected void initView() {
    }

    protected abstract int getLayoutId();
    protected abstract P initPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        mPresenter.onDestory();
        mPresenter=null;
    }
}
