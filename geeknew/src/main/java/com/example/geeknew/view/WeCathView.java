package com.example.geeknew.view;

import com.example.geeknew.base.BaseMvpView;
import com.example.geeknew.bean.WeChatBean;

public interface WeCathView extends BaseMvpView{
    void setData(WeChatBean weChatBean);
    void setDatas(WeChatBean weChatBean);
}
