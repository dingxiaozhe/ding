package com.example.geeknew.model;



import com.example.geeknew.R;
import com.example.geeknew.base.BaseModel;
import com.example.geeknew.bean.DailyNewsBean;
import com.example.geeknew.net.BaseObserver;
import com.example.geeknew.net.HttpUtils;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.net.RxUtils;
import com.example.geeknew.net.ZhihuService;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DailyNewsModel extends BaseModel{
      public void getData(final ResultCallBack<DailyNewsBean> callback){
            ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sBaseUrl, ZhihuService.class);
            Observable<DailyNewsBean> lastDailyNews = apiserver.getLastDailyNews();
            lastDailyNews.compose(RxUtils.<DailyNewsBean>rxObserableSchedulerHelper())
                    .subscribe(new BaseObserver<DailyNewsBean>() {
                          @Override
                          public void onSubscribe(Disposable d) {
                              mCompositeDisposable.add(d);
                          }

                          @Override
                          public void onNext(DailyNewsBean dailyNewsBean) {
                              callback.onSuccess(dailyNewsBean);
                          }
                    });
      }
      public  void getDatas(String date, final ResultCallBack<DailyNewsBean> callback){
          ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.sBaseUrl, ZhihuService.class);
          Observable<DailyNewsBean> before = apiserver.getBefore(date);
            before.compose(RxUtils.<DailyNewsBean>rxObserableSchedulerHelper())
                    .subscribe(new BaseObserver<DailyNewsBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            mCompositeDisposable.add(d);
                        }

                        @Override
                        public void onNext(DailyNewsBean dailyNewsBean) {
                            callback.onSuccess(dailyNewsBean);
                        }
                    });
        }




}
