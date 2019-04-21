package com.example.geeknew.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.geeknew.R;
import com.example.geeknew.activity.VShowActivity;
import com.example.geeknew.adapter.V2exAdapter;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.bean.DocumentBean;
import com.example.geeknew.net.ZhihuService;
import com.example.geeknew.presenter.BlankPresenter;
import com.example.geeknew.view.BlankView;

import java.util.ArrayList;

import butterknife.BindView;

public class BlankFragment extends BaseFragment<BlankView,BlankPresenter>implements BlankView{
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private V2exAdapter adapter;
    private String href;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected BlankPresenter initPresenter() {
        return new BlankPresenter();
    }

public  static  BlankFragment newInstant(String href){
    BlankFragment blankFragment = new BlankFragment();
    Bundle bundle = new Bundle();
    bundle.putString("href",href);
    blankFragment.setArguments(bundle);
    return blankFragment;
}
    @Override
    protected void initView() {
        ArrayList<DocumentBean> list=new ArrayList<>();
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new V2exAdapter(list, getContext());
        mRlv.setAdapter(adapter);
        Bundle bundle = getArguments();
        href=bundle.getString("href");
        adapter.setOnItemClickListener(new V2exAdapter.OnItemClickListener() {
            @Override
            public void itemClick(DocumentBean documentBean) {
                Intent intent = new Intent(getContext(), VShowActivity.class);
                intent.putExtra("url", ZhihuService.mUrl+documentBean.getUrl());
                intent.putExtra("title",documentBean.getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getBlank(href);
    }

    @Override
    public void updateDoc(final ArrayList<DocumentBean> bean) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.setAll(bean);
                }
            });
    }
}
