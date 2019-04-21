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
import com.example.geeknew.bean.WeChatBean;

import java.util.ArrayList;

public class RlvWeChatAdapter extends RecyclerView.Adapter<RlvWeChatAdapter.ViewHolder> {
    private ArrayList<WeChatBean.NewslistBean> list;
    private Context context;

    public RlvWeChatAdapter(ArrayList<WeChatBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_wechat, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        WeChatBean.NewslistBean newslistBean = list.get(i);
        viewHolder.title.setText(newslistBean.getTitle());
        viewHolder.description.setText(newslistBean.getDescription());
        viewHolder.ctime.setText(newslistBean.getCtime());
        Glide.with(context).load(newslistBean.getPicUrl()).into(viewHolder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  void setData(WeChatBean bean){
        list.clear();
        if (bean.getNewslist()!=null&&bean.getNewslist().size()>0){
            list.addAll(bean.getNewslist());
        }
        notifyDataSetChanged();
    }






    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private TextView description;
        private TextView ctime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            ctime=itemView.findViewById(R.id.ctime);

        }
    }
}
