package com.example.geeknew.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.bean.DailyNewsBean;

import java.util.ArrayList;

import retrofit2.http.POST;

public class VpZhihuAdapter extends FragmentStatePagerAdapter{
   private Context mContext;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<Integer> mTitles;
    public VpZhihuAdapter(Context context,FragmentManager fm, ArrayList<BaseFragment> fragments
                                            ,ArrayList<Integer> titles) {
        super(fm);
        mContext=context;
        mFragments=fragments;
        mTitles=titles;

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
        return mContext.getResources().getString(mTitles.get(position));
    }
}
