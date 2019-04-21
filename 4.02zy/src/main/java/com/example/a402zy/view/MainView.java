package com.example.a402zy.view;

import com.example.a402zy.base.BaseMvpView;

public interface MainView extends BaseMvpView{
    void setData(String data);
    String getUserName();
    String getPsw();
    void showToast(String msg);
}
