package com.example.geeknew.view;

import com.example.geeknew.base.BaseMvpView;
import com.example.geeknew.bean.DocumentBean;

import java.util.ArrayList;

public interface BlankView extends BaseMvpView{
    void updateDoc(ArrayList<DocumentBean> bean);
}
