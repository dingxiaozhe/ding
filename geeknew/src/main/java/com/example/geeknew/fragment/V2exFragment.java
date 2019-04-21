package com.example.geeknew.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.geeknew.R;
import com.example.geeknew.activity.NodeNaviActivity;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.presenter.V2exPresenter;
import com.example.geeknew.presenter.ZhihuDailyNewsPresenter;
import com.example.geeknew.view.V2exView;




import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class V2exFragment extends BaseFragment<V2exView,V2exPresenter>implements V2exView{
    //丁小哲 1808A
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.arrow)
    ImageView mArrow;
    @BindView(R.id.vp)
    ViewPager vp;
    private static final String TAG = "V2exFragment";
    protected V2exPresenter initPresenter(){
    return new V2exPresenter();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2ex;
    }

        @OnClick(R.id.arrow)
        public void onClick(View v){
                switch (v.getId()){
                    case R.id.arrow:
                        geToShow();
                        break;
                }
            }

    @Override
    protected void initData() {
        mPresenter.getV2eEx();
    }

    private void geToShow() {
        startActivity(new Intent(getContext(), NodeNaviActivity.class));
    }


    @Override
    public void setAllData(final ArrayList<String> titles, final ArrayList<Fragment> fragments) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FragmentPagerAdapter adapter=new FragmentPagerAdapter(getChildFragmentManager()) {
                    @Override
                    public int getCount() {

                        return fragments.size();
                    }

                    @Override
                    public Fragment getItem(int i) {

                        return fragments.get(i);
                    }
                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {

                        return titles.get(position);
                    }
                };
                vp.setAdapter(adapter);
                mTab.setupWithViewPager(vp);
            }
        });
    }
}
