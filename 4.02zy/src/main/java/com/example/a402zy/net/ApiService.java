package com.example.a402zy.net;

import com.example.a402zy.bean.LoginBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    String sBaseUrl="http://yun918.cn/study/public/index.php/";

    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@Field("username") String name,
                                @Field("password") String psw);
}
