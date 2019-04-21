package com.example.geeknew.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.geeknew.R;
import com.example.geeknew.adapter.RlvWeChatAdapter;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.bean.WeChatBean;
import com.example.geeknew.presenter.WeChatPresenter;
import com.example.geeknew.presenter.ZhihuDailyNewsPresenter;
import com.example.geeknew.view.WeCathView;
import com.example.geeknew.view.ZhihuDailyNewsView;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import butterknife.BindView;

public class WeChatFragment extends BaseFragment<WeCathView,WeChatPresenter>implements WeCathView{
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private ArrayList<WeChatBean.NewslistBean> list;
    private RlvWeChatAdapter adapter;
    private  String querys;
    private static final String TAG = "WeChatFragment";
    protected WeChatPresenter initPresenter(){

        return new WeChatPresenter();
    }
    @Override
    protected int getLayoutId() {

        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {
        list=new ArrayList<>();
        adapter = new RlvWeChatAdapter(list, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
        ;
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void setData(WeChatBean weChatBean) {
        adapter.setData(weChatBean);
    }

    @Override
    public void setDatas(WeChatBean weChatBean) {
        adapter.setData(weChatBean);
}


    public  void  query(String query){
        Log.e(TAG, "query: "+query );
        if (query!=null) {
            mPresenter.getDatas(query);
        }
    }

}
