package com.example.geeknew.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geeknew.R;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.base.Constants;
import com.example.geeknew.presenter.EmptyPresenter;
import com.example.geeknew.view.EmptyView;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldDetailFragment extends BaseFragment<EmptyView,EmptyPresenter> implements EmptyView {

    @BindView(R.id.tv)
    TextView mTv;

    public static GoldDetailFragment newInstance(String text){
        GoldDetailFragment goldDetailFragment = new GoldDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA,text);
        goldDetailFragment.setArguments(bundle);
        return  goldDetailFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_detail;
    }

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        String data = arguments.getString(Constants.DATA);
        mTv.setText(data);
    }
}
