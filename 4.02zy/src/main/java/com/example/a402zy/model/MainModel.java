package com.example.a402zy.model;

import com.example.a402zy.base.BaseModel;
import com.example.a402zy.bean.LoginBean;
import com.example.a402zy.net.ApiService;
import com.example.a402zy.net.BaseObserver;
import com.example.a402zy.net.HttpUtils;
import com.example.a402zy.net.ResultCallBack;
import com.example.a402zy.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel{

    public void login(String username, String psw, final ResultCallBack callBack){
      /*  Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiService.sBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<LoginBean> login = retrofit.create(ApiService.class).login(username, psw);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        callBack.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/


        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.sBaseUrl, ApiService.class);
        Observable<LoginBean> login1 = apiserver.login(username, psw);
        login1.compose(RxUtils.<LoginBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        callBack.onSuccess(loginBean);
                    }
                });
    }
}
