package com.weixuan.football.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.weixuan.football.R;
import com.weixuan.football.adapter.SpinnerAdapter;
import com.weixuan.football.util.Util;

/**
 * Created by Hua on 2014/8/13.
 */
public class PlayerGameStatsFragment extends BaseFragment{
    private Spinner spinner_round;
    private RadioGroup rgGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_player_game_stats, container,false);
        initView(view, inflater);
        return view;
    }

    @Override
    protected void initView(View view, LayoutInflater inflater) {
        spinner_round=(Spinner)view.findViewById(R.id.spinner_round);
        rgGroup=(RadioGroup)view.findViewById(R.id.rg_group);
        rgGroup.check(R.id.rbtn_left_menu_0);
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbtn_left_menu_0:
                        break;
                    case R.id.rbtn_left_menu_1:
                        break;
                    case R.id.rbtn_left_menu_2:
                        break;
                    case R.id.rbtn_left_menu_3:
                        break;
                }
            }
        });
        SpinnerAdapter adapterRound=new SpinnerAdapter(Util.getYearList(2008),inflater);
        spinner_round.setAdapter(adapterRound);
        spinner_round.setSelection(0);
    }
}
