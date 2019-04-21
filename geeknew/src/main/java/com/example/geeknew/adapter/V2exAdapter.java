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
import com.example.geeknew.bean.DocumentBean;

import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V2exAdapter extends RecyclerView.Adapter<V2exAdapter.ViewHolder>{
    private ArrayList<DocumentBean> list;
    private Context context;

    public V2exAdapter(ArrayList<DocumentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_v2ex, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DocumentBean documentBean = list.get(i);
        viewHolder.mVxAuthor.setText(documentBean.getAuthor());
        viewHolder.mVxCount.setText(documentBean.getCount());
        viewHolder.mVxLap.setText(documentBean.getLastPerson());
        viewHolder.mVxTab.setText(documentBean.getTab());
        viewHolder.mVxTime.setText(documentBean.getTime());
        viewHolder.mVxTitle.setText(documentBean.getTitle());
        Glide.with(context).load(documentBean.getPic()).into(viewHolder.mVxImg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener!=null){
                    onItemClickListener.itemClick(documentBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  void setAll(ArrayList<DocumentBean> bean){
        list.addAll(bean);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.vx_img)
        ImageView mVxImg;
        @BindView(R.id.vx_author)
        TextView mVxAuthor;
        @BindView(R.id.vx_time)
        TextView mVxTime;
        @BindView(R.id.vx_lap)
        TextView mVxLap;
        @BindView(R.id.vx_count)
        TextView mVxCount;
        @BindView(R.id.vx_tab)
        TextView mVxTab;
        @BindView(R.id.vx_title)
        TextView mVxTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void itemClick(DocumentBean documentBean);
    }
}
