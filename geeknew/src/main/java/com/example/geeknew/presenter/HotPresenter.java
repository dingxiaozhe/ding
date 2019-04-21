package com.example.geeknew.presenter;

import com.example.geeknew.base.BasePresenter;
import com.example.geeknew.bean.HotBean;
import com.example.geeknew.model.HotModel;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.view.HotView;

public class HotPresenter extends BasePresenter<HotView>{
    private HotModel hotModel;
    @Override
    protected void initModel() {
        hotModel=new HotModel();
        mModels.add(hotModel);
    }
    public void getData(){
        hotModel.getData(new ResultCallBack<HotBean>() {
            @Override
            public void onSuccess(HotBean bean) {
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
