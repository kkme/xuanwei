package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ListScoreboardAdapater;
import com.weixuan.football.entity.Standings;

import java.util.ArrayList;
import java.util.List;

/****
 * 积分榜
 *
 */
public class MScoreboardFragment extends BaseFragment{
    private List<Standings> data;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_m_scoreboard, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    @Override
	protected void initView(View view, LayoutInflater inflater) {
        listView=(ListView)view.findViewById(R.id.ls_data);

        data=new ArrayList<Standings>();
        Standings standings=new Standings();
        standings.setNo(1);
        standings.setJsq("22/13");
        standings.setDraw(2);
        standings.setLose(3);
        standings.setScore(55);
        standings.setTeam("上海申鑫");
        standings.setWin(20);
        standings.setSession(12);
        data.add(standings);
        data.add(standings);
        data.add(standings);


        adapter=new ListScoreboardAdapater(getActivity(),data);
        listView.setAdapter(adapter);


	}

}
