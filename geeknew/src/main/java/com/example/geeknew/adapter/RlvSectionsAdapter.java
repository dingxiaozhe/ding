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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.geeknew.R;
import com.example.geeknew.bean.SectionsBean;
import com.example.geeknew.net.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class RlvSectionsAdapter extends RecyclerView.Adapter<RlvSectionsAdapter.ViewHolder> {
    private ArrayList<SectionsBean.DataBean> list;
    private Context context;



    public RlvSectionsAdapter(ArrayList<SectionsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<SectionsBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_sections, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final SectionsBean.DataBean dataBean = list.get(i);
        viewHolder.description.setText(dataBean.getDescription());
        viewHolder.name.setText(dataBean.getName());
        //RoundedCorners roundedCorners= new RoundedCorners(15);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        //RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(new RoundedCorners(20));
        Glide.with(context).load(dataBean.getThumbnail()).apply(requestOptions).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick!=null){
                    onItemClick.send(i,dataBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(SectionsBean bean){
        List<SectionsBean.DataBean> data = bean.getData();
        if (bean.getData()!=null&&bean.getData().size()>0){
            list.addAll(bean.getData());
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView description;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            description=itemView.findViewById(R.id.description);
            name=itemView.findViewById(R.id.name);

        }
    }
    private  onItemClick onItemClick;

    public void setOnItemClick(RlvSectionsAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public  interface onItemClick{
        void send(int position,SectionsBean.DataBean dataBean);
    }
}
