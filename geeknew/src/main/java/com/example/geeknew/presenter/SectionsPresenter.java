package com.example.geeknew.presenter;

import com.example.geeknew.base.BasePresenter;
import com.example.geeknew.bean.SectionsBean;
import com.example.geeknew.model.SectionsModel;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.view.SectionsView;

public class SectionsPresenter extends BasePresenter<SectionsView>{
    private SectionsModel sectionsModel;
    @Override
    protected void initModel() {
        sectionsModel=new SectionsModel();
        mModels.add(sectionsModel);
    }
    public void getData(){
        sectionsModel.getData(new ResultCallBack<SectionsBean>() {
            @Override
            public void onSuccess(SectionsBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.setData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
