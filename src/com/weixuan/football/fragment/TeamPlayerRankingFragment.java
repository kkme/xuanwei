package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import com.weixuan.football.R;
import com.weixuan.football.adapter.SpinnerAdapter;
import com.weixuan.football.util.Util;

/****
 * 新闻/公告
 *
 */
public class TeamPlayerRankingFragment extends Fragment{

    private Spinner spinnerTeam,spinnerRound;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_team_player_ranking, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
	private void initView(View view, LayoutInflater inflater) {
        spinnerTeam=(Spinner)view.findViewById(R.id.spinner_team);
        spinnerRound=(Spinner)view.findViewById(R.id.spinner_round);

        SpinnerAdapter adapterTeam=new SpinnerAdapter(Util.getYearList(2000),inflater);
        spinnerTeam.setAdapter(adapterTeam);
        spinnerTeam.setSelection(0);
        SpinnerAdapter adapterRound=new SpinnerAdapter(getResources().getStringArray(R.array.type),inflater);
        spinnerRound.setAdapter(adapterRound);
        spinnerRound.setSelection(1);


    }


}
