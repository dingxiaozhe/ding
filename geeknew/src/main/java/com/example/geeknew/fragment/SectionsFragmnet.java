package com.example.geeknew.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.geeknew.R;
import com.example.geeknew.activity.SectionsDetailsActivity;
import com.example.geeknew.adapter.RlvSectionsAdapter;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.bean.SectionsBean;
import com.example.geeknew.presenter.SectionsPresenter;
import com.example.geeknew.view.SectionsView;

import java.util.ArrayList;

import butterknife.BindView;

public class SectionsFragmnet extends BaseFragment<SectionsView,SectionsPresenter>implements SectionsView, RlvSectionsAdapter.onItemClick {
//  丁小哲  1808A
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private ArrayList<SectionsBean.DataBean> list;
    private RlvSectionsAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sections;
    }

    @Override
    protected SectionsPresenter initPresenter() {
        return new SectionsPresenter();
    }

    @Override
    protected void initView() {
        list=new ArrayList<>();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new RlvSectionsAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClick(this);

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }
    public   void  setData(SectionsBean bean){
        adapter.setData(bean);
    }

    @Override
    public void send(int position, SectionsBean.DataBean dataBean) {
        int id = dataBean.getId();
        Intent intent = new Intent(getContext(), SectionsDetailsActivity.class);
        intent.putExtra("id",String.valueOf(id));
        intent.putExtra("name",dataBean.getName());
        startActivity(intent);
    }
}
