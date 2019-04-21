package com.example.a402zy;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a402zy.base.BaseActivity;
import com.example.a402zy.presenter.MainPresenter;
import com.example.a402zy.util.ToastUtil;
import com.example.a402zy.view.MainView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity <MainView,MainPresenter> implements MainView{
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.ed_name)
    EditText ed_name;
    @BindView(R.id.ed_psw)
    EditText ed_psw;


    @Override
    protected MainPresenter initPresenter() {

        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main;
    }
    @OnClick({R.id.login})
    public void click(View v){
        mPresenter.login();
    }
    @Override
    public void setData(String data) {

    }

    @Override
    public String getUserName() {

        return ed_name.getText().toString().trim();
    }

    @Override
    public String getPsw() {

        return ed_psw.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.showShort(msg);
    }
}
