package com.example.geeknew.presenter;

import com.example.geeknew.base.BasePresenter;
import com.example.geeknew.bean.WeChatBean;
import com.example.geeknew.model.WeChatModel;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.view.WeCathView;
import com.example.geeknew.view.ZhihuDailyNewsView;

public class WeChatPresenter extends BasePresenter<WeCathView>{
    private WeChatModel weChatModel;
    @Override
    protected void initModel() {
        weChatModel=new WeChatModel();
        mModels.add(weChatModel);
    }
    public  void getData(){
        weChatModel.getData(new ResultCallBack<WeChatBean>() {
            @Override
            public void onSuccess(WeChatBean bean) {
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

    public  void getDatas(String word){
        weChatModel.getDatas(word, new ResultCallBack<WeChatBean>() {
            @Override
            public void onSuccess(WeChatBean bean) {
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
