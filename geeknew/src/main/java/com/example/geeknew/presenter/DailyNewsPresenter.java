package com.example.geeknew.presenter;

import com.example.geeknew.base.BasePresenter;
import com.example.geeknew.bean.DailyNewsBean;
import com.example.geeknew.model.DailyNewsModel;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.view.DailyNewsView;

public class DailyNewsPresenter extends BasePresenter<DailyNewsView>{
    private DailyNewsModel mDailyNewsModel;
    @Override
    protected void initModel() {
        mDailyNewsModel=new DailyNewsModel();
        mModels.add(mDailyNewsModel);

    }
    public void getData(){
        mDailyNewsModel.getData(new ResultCallBack<DailyNewsBean>() {
            @Override
            public void onSuccess(DailyNewsBean bean) {
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
    public  void getDatas(String date){
        mDailyNewsModel.getDatas(date, new ResultCallBack<DailyNewsBean>() {
            @Override
            public void onSuccess(DailyNewsBean bean) {
                if (bean!=null){
                    if (mMvpView!=null){
                        mMvpView.setDatas(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
