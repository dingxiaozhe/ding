package com.example.geeknew.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geeknew.R;
import com.example.geeknew.bean.DailyNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RlvDailyNewsAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<DailyNewsBean.StoriesBean> mStoriesBeans ;
    private ArrayList<DailyNewsBean.TopStoriesBean> mTopStoriesBeans ;
    //private  ArrayList<DailyBeforeListBean.StoriesBean> beforeList;
    private static final int ITEM_BANNER = 0;
    private static final int ITEM_TIME = 1;
    private static final int ITEM_DAILY_NEWS = 2;
    private String mDate = "今日要闻";



    public RlvDailyNewsAdapter(Context context, ArrayList<DailyNewsBean.StoriesBean> mStoriesBeans, ArrayList<DailyNewsBean.TopStoriesBean> mTopStoriesBeans) {
        this.context = context;
        this.mStoriesBeans = mStoriesBeans;
        this.mTopStoriesBeans = mTopStoriesBeans;
        //this.beforeList=beforeList;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (i == ITEM_BANNER) {
            return new BannerVH(inflater.inflate(R.layout.item_banner, null));
        } else if (i == ITEM_TIME) {
            return new TimeVH(inflater.inflate(R.layout.item_time, null));
        } else {
            return new NewsVH(inflater.inflate(R.layout.item_daily_news, null));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == ITEM_BANNER) {
            final BannerVH bannerVH = (BannerVH) viewHolder;
            bannerVH.banner.setImages(mTopStoriesBeans)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            DailyNewsBean.TopStoriesBean bean = (DailyNewsBean.TopStoriesBean) path;
                            Glide.with(context).load(bean.getImage()).into(imageView);
                        }
                    }).start();
        } else if (itemViewType == ITEM_TIME) {
            TimeVH timeVH = (TimeVH) viewHolder;
            timeVH.tv_time.setText(mDate);
        } else {
            int newPosition = i - 1;
            if (mTopStoriesBeans.size() > 0) {
                newPosition -= 1;
            }
            DailyNewsBean.StoriesBean storiesBean = mStoriesBeans.get(newPosition);
            NewsVH newsVH= (NewsVH) viewHolder;
            newsVH.title.setText(storiesBean.getTitle());
            Glide.with(context).load(storiesBean.getImages().get(0)).into(newsVH.img);
        }
    }

    @Override
    public int getItemCount() {
        if (mTopStoriesBeans.size() > 0) {
            return 1 + 1 + mStoriesBeans.size();
        } else {
            return 1 + mStoriesBeans.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mTopStoriesBeans.size() > 0) {
            if (position == 0) {
                return ITEM_BANNER;
            } else if (position == 1) {
                return ITEM_TIME;
            } else {
                return ITEM_DAILY_NEWS;
            }
        } else {
            if (position == 0) {
                return ITEM_TIME;
            } else {
                return ITEM_DAILY_NEWS;
            }
        }
    }


    public  void setData(DailyNewsBean bean){
        mDate  = bean.getDate();
        mTopStoriesBeans.clear();
        if (bean.getTop_stories()!=null&&bean.getTop_stories().size()>0){
            mTopStoriesBeans.addAll(bean.getTop_stories());
        }
        mStoriesBeans.clear();
        if (bean.getStories()!=null&&bean.getTop_stories().size()>0){
            mStoriesBeans.addAll(bean.getStories());
        }
        notifyDataSetChanged();

    }

    public class BannerVH extends RecyclerView.ViewHolder {
        private Banner banner;

        public BannerVH(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    public class TimeVH extends RecyclerView.ViewHolder {
        private TextView tv_time;

        public TimeVH(@NonNull View itemView) {
            super(itemView);
            tv_time = itemView.findViewById(R.id.tv_time);
        }

    }

    public class NewsVH extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        public NewsVH(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
        }
    }
}
