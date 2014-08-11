package com.weixuan.football.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ListLiveStartingAdapater;
import com.weixuan.football.adapter.ViewPageAdapter;
import com.weixuan.football.ui.MainActivity;
import com.weixuan.football.util.Dict;
import com.weixuan.football.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/****
 *直播-->---首发
 *
 */
public class LiveStartingFragment extends BaseFragment{

    private ListView teamList;
    private ListLiveStartingAdapater liveAdapater;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_live_starting, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    protected void initView(View view, LayoutInflater inflater) {

        teamList=(ListView)view.findViewById(R.id.ls_team);
        listView=(ListView)view.findViewById(R.id.ls_round);

        List data=new ArrayList();
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        adapter= new ListLiveStartingAdapater(getActivity(),data);
        listView.setAdapter(adapter);
        teamList.setAdapter(adapter);


	}


}
