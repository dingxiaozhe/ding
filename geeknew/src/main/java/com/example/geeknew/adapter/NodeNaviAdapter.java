package com.example.geeknew.adapter;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geeknew.R;
import com.example.geeknew.bean.V2ExBean;
import com.example.geeknew.util.ToastUtil;
import com.example.geeknew.widget.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NodeNaviAdapter extends RecyclerView.Adapter<NodeNaviAdapter.ViewHolder>{
  private ArrayList<V2ExBean.DataBean> list;
  private Context context;

    public NodeNaviAdapter(ArrayList<V2ExBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_navi, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List<V2ExBean.DataBean.ArticlesBean> articles = list.get(i).getArticles();
        if (articles != null && articles.size() > 0) {
            for (int j = 0; j < articles.size(); j++) {
                final String title = articles.get(j).getTitle();
                TextView lable = (TextView) View.inflate(context, R.layout.item_label, null);
                lable.setText(title);
                lable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showLong(title);
                    }
                });
                viewHolder.mFl.addView(lable);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setAll(List<V2ExBean.DataBean> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fl)
        FlowLayout mFl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
