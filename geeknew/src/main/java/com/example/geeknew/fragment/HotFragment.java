package com.example.geeknew.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.geeknew.R;
import com.example.geeknew.adapter.RlvHotAdapter;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.bean.HotBean;
import com.example.geeknew.presenter.HotPresenter;
import com.example.geeknew.view.HotView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment<HotView,HotPresenter> implements HotView{

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
private ArrayList<HotBean.RecentBean> list;
    private RlvHotAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected HotPresenter initPresenter() {
        return new HotPresenter();
    }

    @Override
    protected void initView() {
        list=new ArrayList<>();
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RlvHotAdapter(list, getContext());
        recyclerview.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void setData(HotBean hotBean) {
        adapter.setData(hotBean);
    }
}
