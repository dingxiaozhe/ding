package com.example.geeknew.fragment;


import android.content.Intent;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.geeknew.R;
import com.example.geeknew.activity.CalendarActivity;
import com.example.geeknew.adapter.RlvDailyNewsAdapter;
import com.example.geeknew.base.BaseFragment;
import com.example.geeknew.bean.DailyNewsBean;
import com.example.geeknew.bean.SectionsBean;
import com.example.geeknew.net.ZhihuService;
import com.example.geeknew.presenter.DailyNewsPresenter;
import com.example.geeknew.view.DailyNewsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyNewsFragment extends BaseFragment<DailyNewsView,DailyNewsPresenter> implements DailyNewsView{

    private static final String TAG = "DailyNewsFragment";
    @BindView(R.id.rlv)
    RecyclerView rlv;
    private RlvDailyNewsAdapter adapter;
    @BindView(R.id.fab)
    FloatingActionButton fab;
   // private ArrayList<DailyBeforeListBean.StoriesBean> beforeList=new ArrayList<>();
  // private List<DailyNewsBean> beforList=new ArrayList<>();
    private String date;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_news;
    }

    @Override
    protected DailyNewsPresenter initPresenter() {
        return new DailyNewsPresenter();
    }

    @Override
    protected void initView() {

        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<DailyNewsBean.StoriesBean> storiesBeans=new ArrayList<>();
        ArrayList<DailyNewsBean.TopStoriesBean> topStoriesBeans=new ArrayList<>();
        adapter = new RlvDailyNewsAdapter(getContext(), storiesBeans, topStoriesBeans);
        rlv.setAdapter(adapter);
        initfab();

    }




    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void setData(DailyNewsBean bean) {

        adapter.setData(bean);
    }

    @Override
    public void setDatas(DailyNewsBean bean) {
        adapter.setData(bean);
    }

    private void initfab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CalendarActivity.class);
               // CircularAnimUtil.
                        startActivityForResult(intent,1001);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1001&&resultCode==1002){
            date = data.getStringExtra("date");
            Log.e(TAG, "onActivityResult: "+date );
                mPresenter.getDatas(date);

        }
    }
}
