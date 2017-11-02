package com.lzb.recyclerviewdome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * 用于测试添加顶部和底部的类
 */
public class MainActivity extends AppCompatActivity {

    WrapRecyclerView recyclerView;
    TestAdapter adapter;
    private WrapRecyclerAdapter wrapRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (WrapRecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter=new TestAdapter(this);
        wrapRecyclerAdapter=new WrapRecyclerAdapter(adapter);
        recyclerView.setAdapter(wrapRecyclerAdapter);
        View head= LayoutInflater.from(this).inflate(R.layout.item_header,null);
        recyclerView.addHeaderView(head);
        View head3= LayoutInflater.from(this).inflate(R.layout.item_header,null);
        recyclerView.addHeaderView(head3);
        View head2= LayoutInflater.from(this).inflate(R.layout.item_header,null);
        recyclerView.addHeaderView(head2);
        View head1= LayoutInflater.from(this).inflate(R.layout.item_header,null);
        recyclerView.addHeaderView(head1);
    }
}
