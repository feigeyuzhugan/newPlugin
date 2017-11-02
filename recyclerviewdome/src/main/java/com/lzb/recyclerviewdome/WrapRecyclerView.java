package com.lzb.recyclerviewdome;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/2.
 */

public class WrapRecyclerView extends RecyclerView {
    private WrapRecyclerAdapter wrapRecyclerAdapter;

    public WrapRecyclerView(Context context) {
        super(context);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter==null){
           throw new NullPointerException("需要传递一个adapter");
        }
        this.wrapRecyclerAdapter=new WrapRecyclerAdapter(adapter);
        super.setAdapter(wrapRecyclerAdapter);
    }

    /**
     * 添加一个底部view
     * @param view
     */
    public void addFooterView(View view){
        if (wrapRecyclerAdapter!=null){
            wrapRecyclerAdapter.addFooterView(view);
        }
    }
    /**
     * 删除一个底部view
     * @param view
     */
    public void removeFooterView(View view){
        if (wrapRecyclerAdapter!=null){
            wrapRecyclerAdapter.removeFooterView(view);
        }
    }
    /**
     * 添加一个顶部view
     * @param view
     */
    public void addHeaderView(View view){
        if (wrapRecyclerAdapter!=null){
            wrapRecyclerAdapter.addHeaderView(view);
        }
    }
    /**
     * 删除一个顶部view
     * @param view
     */
    public void removeHeaderView(View view){
        if (wrapRecyclerAdapter!=null){
            wrapRecyclerAdapter.removeHeaderView(view);
        }
    }
}
