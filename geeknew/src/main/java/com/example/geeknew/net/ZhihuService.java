package com.example.geeknew.net;



import com.example.geeknew.bean.DailyNewsBean;
import com.example.geeknew.bean.HotBean;
import com.example.geeknew.bean.SectionsBean;
import com.example.geeknew.bean.V2ExBean;
import com.example.geeknew.bean.WeChatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xts
 *         Created by asus on 2019/4/17.
 */

public interface ZhihuService {
    String sBaseUrl = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<DailyNewsBean> getLastDailyNews();

    @GET("sections ")
    Observable<SectionsBean> getSections();

    @GET("news/hot")
    Observable<HotBean> getHot();


        @GET("news/before ")
        Observable<DailyNewsBean> getBefore(@Query("date") String date);

        String weChatUrl="http://api.tianapi.com/";
        @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
        Observable<WeChatBean> getWeChat();

        @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
        Observable<WeChatBean> getWXHotSearch(@Query("word") String word);

        String v2exUrl="https://www.wanandroid.com/";
        @GET("navi/json")
        Observable<V2ExBean> getV2ex();


        String mUrl="https://www.v2ex.com";
}
