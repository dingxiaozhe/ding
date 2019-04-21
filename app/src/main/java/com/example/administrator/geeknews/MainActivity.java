package com.example.administrator.geeknews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.geeknews.base.BaseActivity;
import com.example.administrator.geeknews.presenter.MainPresenter;
import com.example.administrator.geeknews.view.MainView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainView,MainPresenter> implements MainView{

   @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    protected  void  initData(){

    }
    @OnClick({R.id.btn})
     public void click(View v){
        mPresenter.getData();
}

    @Override
    public void setData(String data) {
            mBtn.setText(data);
    }
}
