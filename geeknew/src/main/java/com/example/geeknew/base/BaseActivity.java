package com.example.geeknew.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseMvpView,P extends BasePresenter> extends AppCompatActivity implements BaseMvpView{
   //丁小哲 1808A
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

    protected void initData() {
    }

    protected void initView() {
    }

    protected abstract int getLayoutId();



    protected void setToolBar(Toolbar toolbar, String title) {
       toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
        mPresenter=null;
    }


}


