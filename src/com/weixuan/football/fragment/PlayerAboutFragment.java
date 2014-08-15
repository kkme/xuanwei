package com.weixuan.football.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.weixuan.football.R;

/**
 * Created by Hua on 2014/8/13.
 */
public class PlayerAboutFragment extends BaseFragment{

    private TextView tv_tv_item_0,tv_tv_item_1,tv_tv_item_2,tv_tv_item_3,tv_tv_item_4,tv_tv_item_5,tv_tv_item_6,tv_tv_item_7
            ,tv_tv_item_8,tv_tv_item_9,tv_tv_item_10,tv_tv_item_11;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_player_about, container,false);
        initView(view, inflater);
        return view;
    }

    @Override
    protected void initView(View view, LayoutInflater inflater) {
        tv_tv_item_0=(TextView)view.findViewById(R.id.tv_item_0);
        tv_tv_item_1=(TextView)view.findViewById(R.id.tv_item_1);
        tv_tv_item_2=(TextView)view.findViewById(R.id.tv_item_2);
        tv_tv_item_3=(TextView)view.findViewById(R.id.tv_item_3);
        tv_tv_item_4=(TextView)view.findViewById(R.id.tv_item_4);
        tv_tv_item_5=(TextView)view.findViewById(R.id.tv_item_5);
        tv_tv_item_6=(TextView)view.findViewById(R.id.tv_item_6);
        tv_tv_item_7=(TextView)view.findViewById(R.id.tv_item_7);
        tv_tv_item_8=(TextView)view.findViewById(R.id.tv_item_8);
        tv_tv_item_9=(TextView)view.findViewById(R.id.tv_item_9);
        tv_tv_item_10=(TextView)view.findViewById(R.id.tv_item_10);
        tv_tv_item_11=(TextView)view.findViewById(R.id.tv_item_11);

        tv_tv_item_0.setText("yangjia wei");
        tv_tv_item_1.setText("中国");
        tv_tv_item_2.setText("中国");
        tv_tv_item_3.setText("中国");
        tv_tv_item_4.setText("中国");
        tv_tv_item_5.setText("中国");
        tv_tv_item_6.setText("中国");
        tv_tv_item_7.setText("中国");
        tv_tv_item_8.setText("中国");
        tv_tv_item_9.setText("中国");
        tv_tv_item_10.setText("中国");
        tv_tv_item_11.setText("中国");



    }
}
