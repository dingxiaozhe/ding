package com.example.geeknew.widget;

public interface TouchCallBack {
    //数据交换
    void onItemMove(int formPosition,int toPosition);
    //数据删除
    void onItemDelete(int position);
}
