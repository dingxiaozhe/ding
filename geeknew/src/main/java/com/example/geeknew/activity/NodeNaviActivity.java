package com.example.geeknew.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.geeknew.R;
import com.example.geeknew.adapter.NodeNaviAdapter;
import com.example.geeknew.base.BaseActivity;
import com.example.geeknew.bean.V2ExBean;
import com.example.geeknew.presenter.NodeNaviPresenter;
import com.example.geeknew.view.NodeNaviView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import qdx.stickyheaderdecoration.NormalDecoration;

public class NodeNaviActivity extends BaseActivity<NodeNaviView,NodeNaviPresenter> implements NodeNaviView {

    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private NodeNaviAdapter adapter;

    @Override
    protected NodeNaviPresenter initPresenter() {
        return new NodeNaviPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_node_navi;
    }

    @Override
    protected void initView() {
        mToolbar.setTitle("节点导航");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<V2ExBean.DataBean> list=new ArrayList<>();
        adapter = new NodeNaviAdapter(list, this);
        mRlv.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        mPresenter.getNode();
    }

    @Override
    public void updateNode(final List<V2ExBean.DataBean> data) {
       NormalDecoration normalDecoration=new NormalDecoration() {
           @Override
           public String getHeaderName(int i) {
               return data.get(i).getName();
           }
       };

     mRlv.addItemDecoration(normalDecoration);
        adapter.setAll(data);
    }

}
