package com.weixuan.football.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ListScheduleAdapater;
import com.weixuan.football.adapter.SpinnerAdapter;
import com.weixuan.football.entity.RecentGameTeam;
import com.weixuan.football.view.PullToRefreshBase;
import com.weixuan.football.view.PullToRefreshListView;

import java.text.SimpleDateFormat;
import java.util.*;

/****
 * 赛程
 *
 */
public class ScheduleFragment extends BaseFragment{


    private Spinner spinnerTeam,spinnerRound;
    private List<RecentGameTeam> data;
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");


    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_schedule, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    protected void initView(View view, LayoutInflater inflater) {

        ((TextView)view.findViewById(R.id.tv_title)).setText(getString(R.string.left_menu_3));
        spinnerTeam=(Spinner)view.findViewById(R.id.spinner_team);
        spinnerRound=(Spinner)view.findViewById(R.id.spinner_round);

        //俱乐部   轮次 选择控件
        SpinnerAdapter adapterTeam=new SpinnerAdapter(getResources().getStringArray(R.array.team),inflater);
        spinnerTeam.setAdapter(adapterTeam);
        spinnerTeam.setSelection(0);
        SpinnerAdapter adapterRound=new SpinnerAdapter(getResources().getStringArray(R.array.round),inflater,getString(R.string.round));
        spinnerRound.setAdapter(adapterRound);
        spinnerRound.setSelection(0);

        pullListView=(PullToRefreshListView)view.findViewById(R.id.ls_data);
        pullListView.setPullLoadEnabled(false);
        pullListView.setScrollLoadEnabled(true);
        listView=pullListView.getRefreshableView();

        data=new ArrayList<RecentGameTeam>();
        RecentGameTeam gameTeam=new RecentGameTeam();
        gameTeam.setDate(new Date());
        gameTeam.setRound(1);
        gameTeam.setScore("0-0");
        gameTeam.setTeamAName("上海申鑫");
        gameTeam.setTeamBName("大连阿尔滨");
        gameTeam.setStatus("I");
        data.add(gameTeam);
        data.add(gameTeam);
        data.add(gameTeam);

        adapter=new ListScheduleAdapater(getActivity(),data);
        listView.setAdapter(adapter);
        listView.setDivider(getResources().getDrawable(R.drawable.ls_divider));

        pullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                pullListView.onPullDownRefreshComplete();
                pullListView.onPullUpRefreshComplete();
                pullListView.setHasMoreData(true);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        pullListView.doPullRefreshing(true, 1000);
        setLastUpdateTime();


	}

    /**
     * 更新刷新时间
     */
    private void setLastUpdateTime() {
        String text = mDateFormat.format(new Date());
        pullListView.setLastUpdatedLabel(text);
    }


}
