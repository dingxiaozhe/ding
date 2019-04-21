package com.example.geeknew.model;

import com.example.geeknew.R;
import com.example.geeknew.base.BaseModel;
import com.example.geeknew.bean.WeChatBean;
import com.example.geeknew.net.BaseObserver;
import com.example.geeknew.net.HttpUtils;
import com.example.geeknew.net.ResultCallBack;
import com.example.geeknew.net.RxUtils;
import com.example.geeknew.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WeChatModel extends BaseModel{
    public  void getData(final ResultCallBack<WeChatBean> callback){
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.weChatUrl, ZhihuService.class);
        Observable<WeChatBean> weChat = apiserver.getWeChat();
        weChat.compose(RxUtils.<WeChatBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        callback.onSuccess(weChatBean);
                    }
                });
    }

    public void getDatas( String word, final ResultCallBack<WeChatBean> callback){
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.weChatUrl, ZhihuService.class);
        Observable<WeChatBean> wxHotSearch = apiserver.getWXHotSearch(word);
        wxHotSearch.compose(RxUtils.<WeChatBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        callback.onSuccess(weChatBean);
                    }
                });
    }

}
