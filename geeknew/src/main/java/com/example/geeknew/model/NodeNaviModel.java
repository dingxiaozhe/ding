package com.example.geeknew.model;

import com.example.geeknew.base.BaseModel;
import com.example.geeknew.bean.V2ExBean;
import com.example.geeknew.net.BaseObserver;
import com.example.geeknew.net.HttpUtils;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.net.RxUtils;
import com.example.geeknew.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class NodeNaviModel extends BaseModel{
    public void getNode(final ResultCallBack callBack) {
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.v2exUrl, ZhihuService.class);
        Observable<V2ExBean> observable = apiserver.getV2ex();
        observable.compose(RxUtils.<V2ExBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<V2ExBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(V2ExBean v2EXBean) {
                        if (v2EXBean.getErrorCode()==0){
                            callBack.onSuccess(v2EXBean);
                        }else {
                            callBack.onFail("请求失败");
                        }
                    }
                });
    }
}
