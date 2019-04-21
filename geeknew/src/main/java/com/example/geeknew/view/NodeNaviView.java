package com.example.geeknew.view;

import com.example.geeknew.base.BaseMvpView;
import com.example.geeknew.bean.V2ExBean;

import java.util.List;

public interface NodeNaviView extends BaseMvpView{
    void updateNode(List<V2ExBean.DataBean> data);
}
