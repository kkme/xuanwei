package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import com.weixuan.football.R;
import com.weixuan.football.adapter.SpinnerAdapter;

/****
 * 新闻/公告
 *
 */
public class ClubTeamHistoryFragment extends Fragment{
    private Spinner spinnerTeam;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_club_team_history, container,false);
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
        SpinnerAdapter adapterTeam=new SpinnerAdapter(getResources().getStringArray(R.array.team_history),inflater);
        spinnerTeam.setAdapter(adapterTeam);
        spinnerTeam.setSelection(11);
	}


}
