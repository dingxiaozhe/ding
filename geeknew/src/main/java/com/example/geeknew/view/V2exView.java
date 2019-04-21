package com.example.geeknew.view;

import android.support.v4.app.Fragment;

import com.example.geeknew.base.BaseMvpView;

import java.util.ArrayList;

public interface V2exView extends BaseMvpView{
    void setAllData(ArrayList<String> titles, ArrayList<Fragment> fragments);
}
