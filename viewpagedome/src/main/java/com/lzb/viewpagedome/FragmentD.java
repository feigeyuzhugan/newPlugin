package com.lzb.viewpagedome;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/31.
 */

public class FragmentD extends Fragment {

    @BindView(R.id.textview)
    TextView textview;
    Unbinder unbinder;

    private int name;
    private int[] color={Color.GREEN,Color.BLUE,Color.WHITE,Color.GREEN,Color.RED,};

    public static FragmentD newInstance(int tag) {
        Bundle args = new Bundle();
        args.putInt("name", tag);
        FragmentD fragment = new FragmentD();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setArguments(Bundle args) {
//        super.setArguments(args);
        name=args.getInt("name");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);
        unbinder = ButterKnife.bind(this, view);
        textview.setText(name+"aaaaaaaaa");
        textview.setBackgroundColor(color[name]);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
