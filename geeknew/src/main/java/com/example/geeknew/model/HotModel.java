package com.example.geeknew.model;

import com.example.geeknew.base.BaseModel;
import com.example.geeknew.bean.HotBean;
import com.example.geeknew.net.BaseObserver;
import com.example.geeknew.net.HttpUtils;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.net.RxUtils;
import com.example.geeknew.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class HotModel extends BaseModel{
    public void getData(final ResultCallBack<HotBean> callback){
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sBaseUrl, ZhihuService.class);
        Observable<HotBean> hot = apiserver.getHot();
        hot.compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callback.onSuccess(hotBean);
                    }
                });
    }
}
