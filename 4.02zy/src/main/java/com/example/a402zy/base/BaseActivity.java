package com.example.a402zy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseMvpView,p extends BasePresenter> extends AppCompatActivity implements BaseMvpView{
    //丁小哲 1808A
    protected  p mPresenter;
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

    protected abstract p initPresenter();

    protected void initListener() {
    }

    protected void initData() {
    }

    protected void initView() {
    }

    protected abstract  int getLayoutId();

   protected  void onDestroy(){
       super.onDestroy();
       mPresenter.onDestory();
        mPresenter=null;
   }

}
