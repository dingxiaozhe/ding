package com.example.geeknew.model;



import android.support.v4.app.Fragment;
import android.util.Log;

import com.bumptech.glide.util.LogTime;
import com.example.geeknew.fragment.BlankFragment;

import com.example.geeknew.base.BaseModel;
import com.example.geeknew.net.MyCallBack;
import com.example.geeknew.net.ResultCallBack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class V2EXModel extends BaseModel{
    private  String mUrl="https://www.v2ex.com/";
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private static final String TAG = "V2EXModel";
    public void getV2EX(final MyCallBack callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                titles=new ArrayList<>();
                fragments=new ArrayList<>();
                try {
                    Document document = Jsoup.connect(mUrl).get();
                    if (document!=null){
                        Elements tabs = document.select("div#Tabs.inner > a");
                        for (Element element :tabs) {
                            String text = element.text();
                            String href = element.attr("href");
                            //Log.e(TAG, "tab: "+text+",href:"+href);
                            titles.add(text);
                            fragments.add(BlankFragment.newInstant(href));
                        }
                        callback.onMySuccess(titles,fragments);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
