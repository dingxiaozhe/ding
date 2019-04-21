package com.example.geeknew.activity;



import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;


import com.example.geeknew.R;
import com.example.geeknew.adapter.RlvShowAdapter;
import com.example.geeknew.base.BaseActivity;
import com.example.geeknew.base.Constants;
import com.example.geeknew.bean.GoldTitleBean;
import com.example.geeknew.presenter.EmptyPresenter;
import com.example.geeknew.view.EmptyView;
import com.example.geeknew.widget.SimpleItemTouchCallBack;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;

public class ShowActivity extends BaseActivity<EmptyView,EmptyPresenter> implements EmptyView {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ArrayList<GoldTitleBean> mTitles;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        mToolBar.setTitle(R.string.specia_show);
        mToolBar.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAct();
            }
        });
         mTitles = (ArrayList<GoldTitleBean>) getIntent().getSerializableExtra(Constants.DATA);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        RlvShowAdapter adapter = new RlvShowAdapter(mTitles);
        mRlv.setAdapter(adapter);
        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        //拖拽移动和左滑删除
        SimpleItemTouchCallBack simpleItemTouchCallBack = new SimpleItemTouchCallBack(adapter);
        simpleItemTouchCallBack.setmSwipeEnable(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallBack);
        itemTouchHelper.attachToRecyclerView(mRlv);
    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA,mTitles);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAct();
    }
}
