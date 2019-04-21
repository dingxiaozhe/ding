package com.example.administrator.geeknews.presenter;

import com.example.administrator.geeknews.base.BasePresenter;
import com.example.administrator.geeknews.view.MainView;

public class MainPresenter extends BasePresenter<MainView>{
    public void getData(){
        String data="请求回来的数据";
        if (mMvpView!=null){
            mMvpView.setData(data);
        }
    }
}
