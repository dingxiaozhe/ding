package com.example.geeknew.net;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

public interface MyCallBack {
    void onMySuccess(ArrayList<String> titles, ArrayList<Fragment> fragments);
}
