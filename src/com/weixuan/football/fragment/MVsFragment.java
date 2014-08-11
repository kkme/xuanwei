package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ListVsAdapater;
import com.weixuan.football.entity.RecentGameTeam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/****
 * 交战历史
 *
 */
public class MVsFragment extends BaseFragment{

    private TextView title_vs;
    private List<RecentGameTeam> data;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_m_vs, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    protected void initView(View view, LayoutInflater inflater) {
        title_vs=(TextView)view.findViewById(R.id.title_vs);
        listView=(ListView)view.findViewById(R.id.ls_data);

        data=new ArrayList<RecentGameTeam>();
        RecentGameTeam gameTeam=new RecentGameTeam();
        gameTeam.setSeason(2014);
        gameTeam.setDate(new Date());
        gameTeam.setRound(12);
        gameTeam.setScore("0-0");
        gameTeam.setTeamAName("上海申鑫");
        gameTeam.setTeamBName("大连阿尔滨");
        gameTeam.setStatus("I");
        gameTeam.setTeamAId(22);
        gameTeam.setTeamBId(22);
        data.add(gameTeam);
        data.add(gameTeam);
        data.add(gameTeam);

        adapter=new ListVsAdapater(getActivity(),data);
        listView.setAdapter(adapter);

	}


}
