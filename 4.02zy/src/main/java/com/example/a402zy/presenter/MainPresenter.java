package com.example.a402zy.presenter;

import android.text.TextUtils;


import com.example.a402zy.base.BasePresenter;
import com.example.a402zy.bean.LoginBean;
import com.example.a402zy.model.MainModel;
import com.example.a402zy.net.ResultCallBack;
import com.example.a402zy.view.MainView;



public class MainPresenter extends BasePresenter<MainView>{
    private static final String TAG = "MainPresenter";
    private MainModel mMainModel;

    public void login() {
        String userName = mMvpView.getUserName();
        String psw = mMvpView.getPsw();
        if (TextUtils.isEmpty(userName) ||TextUtils.isEmpty(psw)){
            mMvpView.showToast("用户名或者密码不能为空");
            return;
        }
        mMainModel.login(userName, psw, new ResultCallBack() {
            @Override
            public void onSuccess(LoginBean bean) {
                if (bean!=null) {
                    com.example.a402zy.util.Logger.logD(TAG,bean.toString());
                    if (bean.getCode() == 200) {
                        if (mMvpView != null) {
                            mMvpView.showToast("登录成功");
                        }
                    } else {
                        if (mMvpView != null) {
                            mMvpView.showToast("登录失败");
                        }
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                    if (mMvpView!=null){
                        mMvpView.showToast("登录失败");
                        com.example.a402zy.util.Logger.logD(TAG,msg);
                    }
            }
        });
    }
    @Override
    protected  void  initModel(){
        mMainModel=new MainModel();
        mModels.add(mMainModel);
    }
}
