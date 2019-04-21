package com.example.geeknew.model;

import com.example.geeknew.R;
import com.example.geeknew.base.BaseModel;
import com.example.geeknew.bean.SectionsBean;
import com.example.geeknew.net.BaseObserver;
import com.example.geeknew.net.HttpUtils;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.net.RxUtils;
import com.example.geeknew.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class SectionsModel extends BaseModel{
   public  void getData(final ResultCallBack<SectionsBean> callback){
       ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sBaseUrl, ZhihuService.class);
       Observable<SectionsBean> sections = apiserver.getSections();
        sections.compose(RxUtils.<SectionsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SectionsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SectionsBean sectionsBean) {
                        callback.onSuccess(sectionsBean);
                    }
                });
   }
}
