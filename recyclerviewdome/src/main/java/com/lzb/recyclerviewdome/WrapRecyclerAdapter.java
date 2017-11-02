package com.lzb.recyclerviewdome;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/2.
 * 可以添加头部和底部的
 */

public class WrapRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView.Adapter adapter;
    private ArrayList<View> headerList;//装头部的集合；
    private ArrayList<View> footerList;//装底部的集合；

    public WrapRecyclerAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        this.footerList=new ArrayList<>();
        this.headerList=new ArrayList<>();
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        int headerCount =getHeaderViewsCount();
        if (position<headerCount){
            return createFooterAndHeaderView(headerList.get(position));
        }
        //adapter
        final int adjPosition=position-headerCount;
        int adapterCount=0;
        if (adapter!=null){
            adapterCount=adapter.getItemCount();
            if (adjPosition<adapterCount){
                return adapter.onCreateViewHolder(parent,getItemViewType(adjPosition));
            }
        }
        return createFooterAndHeaderView(footerList.get(adjPosition-adapterCount));
    }

    private RecyclerView.ViewHolder createFooterAndHeaderView(View view) {
        return new RecyclerView.ViewHolder(view){
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int headerCount =getHeaderViewsCount();
        if (position<headerCount){
            return;
        }
        int adjPosition=position-headerCount;
        if (adapter!=null){
            int adapterCount=adapter.getItemCount();
            if (adjPosition<adapterCount){
                adapter.onBindViewHolder(holder,adjPosition);
            }
        }
    }
    //添加底部
    public void addFooterView(View view){
        if (!footerList.contains(view)){
            footerList.add(view);
            notifyDataSetChanged();
        }
    }
    //删除底部
    public void removeFooterView(View view){
        if (!footerList.contains(view)){
            footerList.remove(view);
            notifyDataSetChanged();
        }
    }
    //添加头部
    public void addHeaderView(View view){
        if (!headerList.contains(view)){
            headerList.add(view);
            notifyDataSetChanged();
        }
    }

    //删除头部
    public void removeHeaderView(View view){
        if (!headerList.contains(view)){
            headerList.remove(view);
            notifyDataSetChanged();
        }
    }

    //获取头view的数目
    public int getHeaderViewsCount() {
        return headerList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return footerList.size()+headerList.size()+adapter.getItemCount();
    }
}
