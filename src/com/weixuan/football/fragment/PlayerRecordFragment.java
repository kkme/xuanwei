package com.weixuan.football.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.weixuan.football.R;

/**
 * Created by Hua on 2014/8/13.
 */
public class PlayerRecordFragment extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_player_record, container,false);
        initView(view, inflater);
        return view;
    }

    @Override
    protected void initView(View view, LayoutInflater inflater) {

    }
}
