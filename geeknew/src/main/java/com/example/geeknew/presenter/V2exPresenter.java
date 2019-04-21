package com.example.geeknew.presenter;

import android.support.v4.app.Fragment;

import com.example.geeknew.base.BasePresenter;
import com.example.geeknew.model.V2EXModel;
import com.example.geeknew.net.MyCallBack;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.view.V2exView;
import com.example.geeknew.view.ZhihuDailyNewsView;

import java.util.ArrayList;

public class V2exPresenter extends BasePresenter<V2exView>{
    private V2EXModel model;
    @Override
    protected void initModel() {
        model=new V2EXModel();
        mModels.add(model);
    }
    public void getV2eEx(){
        model.getV2EX(new MyCallBack() {

            @Override
            public void onMySuccess(ArrayList<String> titles, ArrayList<Fragment> fragments) {
                mMvpView.setAllData(titles,fragments);
            }
        });
    }
}
