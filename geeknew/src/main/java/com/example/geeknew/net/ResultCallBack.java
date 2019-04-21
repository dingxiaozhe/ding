package com.example.geeknew.net;


import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * @author xts
 *         Created by asus on 2019/4/2.
         */

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFail(String msg);

}
