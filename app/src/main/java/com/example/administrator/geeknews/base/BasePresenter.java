package com.example.administrator.geeknews.base;

public abstract class BasePresenter<V extends BaseMvpView> {
    protected  V mMvpView;
    public void bind(V view){
        this.mMvpView=view;
    }
}
