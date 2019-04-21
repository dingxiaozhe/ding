package com.example.geeknew.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.bean.GoldTitleBean;

import java.util.ArrayList;

public class VpGoldAdapter extends FragmentStatePagerAdapter{
   private ArrayList<BaseFragment> mFragments;
   private ArrayList<GoldTitleBean> mTitles;
   private ArrayList<String> mNewTitles=new ArrayList<>();
    public VpGoldAdapter(FragmentManager fm,ArrayList<BaseFragment> fragments,ArrayList<GoldTitleBean> titles) {
        super(fm);
        mFragments=fragments;
        mTitles=titles;
        for (int i = 0; i <mTitles.size() ; i++) {
            GoldTitleBean bean = mTitles.get(i);
            if (bean.isChecked){
                mNewTitles.add(bean.title);
            }
        }
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  mNewTitles.get(position);
    }
}
