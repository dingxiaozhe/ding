package com.example.geeknew.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.geeknew.R;
import com.example.geeknew.bean.GoldTitleBean;
import com.example.geeknew.widget.TouchCallBack;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvShowAdapter extends RecyclerView.Adapter implements TouchCallBack {
    private ArrayList<GoldTitleBean> mTitles;

    public RlvShowAdapter(ArrayList<GoldTitleBean> mTitles) {
        this.mTitles = mTitles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_show, null);
        return new VH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            VH vh= (VH) viewHolder;
        final GoldTitleBean bean = mTitles.get(i);
        vh.mTv.setText(bean.title);
        vh.mSc.setChecked(bean.isChecked);
        vh.mSc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                bean.isChecked=b;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    @Override
    public void onItemMove(int formPosition, int toPosition) {
        //交换位置
        Collections.swap(mTitles,formPosition,toPosition);
        //局部刷新(移动)
        notifyItemMoved(formPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
            //删除数据
        mTitles.remove(position);
        //局部刷新（移除）
        notifyItemRemoved(position);
    }

    class  VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView mTv;
        @BindView(R.id.sc)
        SwitchCompat mSc;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
