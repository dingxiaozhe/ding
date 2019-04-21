package com.example.administrator.geeknews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseMvpView,P extends BasePresenter> extends AppCompatActivity implements BaseMvpView{
    protected  P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.bind(this);
        }
        initView();
        initListener();
        initData();
    }

    protected abstract P initPresenter();

    protected void initListener() {
    }

    protected  void initData(){

    }

    protected  void initView(){

    }

    public abstract  int getLayoutId();


}
