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
import com.example.geeknew.bean.HotBean;

import java.util.ArrayList;

public class RlvHotAdapter extends RecyclerView.Adapter<RlvHotAdapter.ViewHolder> {
    private ArrayList<HotBean.RecentBean> list;
    private Context context;

    public RlvHotAdapter(ArrayList<HotBean.RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<HotBean.RecentBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hot, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        HotBean.RecentBean recentBean = list.get(i);
        viewHolder.title.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
public void  setData(HotBean bean){
        if (bean.getRecent()!=null&&bean.getRecent().size()>0){
            list.addAll(bean.getRecent());
        }
        notifyDataSetChanged();
}
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
        }
    }
}
