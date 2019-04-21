package com.example.geeknew.presenter;

import com.example.geeknew.base.BasePresenter;
import com.example.geeknew.bean.DocumentBean;
import com.example.geeknew.model.BlankModel;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.view.BlankView;

import java.util.ArrayList;

public class BlankPresenter extends BasePresenter<BlankView>{
   private BlankModel model;
    @Override
    protected void initModel() {
        model=new BlankModel();
        mModels.add(model);
    }
    public void getBlank(String href){
        model.getBlank(href, new ResultCallBack<ArrayList<DocumentBean>>() {
            @Override
            public void onSuccess(ArrayList<DocumentBean> bean) {

                        mMvpView.updateDoc(bean);


            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
