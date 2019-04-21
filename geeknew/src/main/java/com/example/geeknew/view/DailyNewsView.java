package com.example.geeknew.view;

import com.example.geeknew.base.BaseMvpView;
import com.example.geeknew.bean.DailyNewsBean;

public interface DailyNewsView extends BaseMvpView{
    void setData(DailyNewsBean bean);
    void setDatas(DailyNewsBean bean);
}
