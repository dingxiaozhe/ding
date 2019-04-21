package com.example.a402zy.net;

import com.example.a402zy.bean.LoginBean;

public interface ResultCallBack {
    void onSuccess(LoginBean bean);
    void onFail(String msg);
}
