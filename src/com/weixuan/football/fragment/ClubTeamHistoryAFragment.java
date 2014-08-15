package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ListClubHistoryAdapater;
import com.weixuan.football.adapter.SpinnerAdapter;
import com.weixuan.football.util.Util;

/****
 * 新闻/公告
 *
 */
public class ClubTeamHistoryAFragment extends BaseFragment{

    private ImageView iv_team;
    private Spinner spinnerYear;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_club_h_menu1, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
	public void initView(View view, LayoutInflater inflater) {
        iv_team=(ImageView)view.findViewById(R.id.iv_item_0);
        spinnerYear=(Spinner)view.findViewById(R.id.spinner_round);
        listView=(ListView)view.findViewById(R.id.ls_data);


        SpinnerAdapter adapterRound=new SpinnerAdapter(Util.getYearList(1990),inflater);
        spinnerYear.setAdapter(adapterRound);
        spinnerYear.setSelection(0);
        //adapter=new ListClubHistoryAdapater(getActivity(),null);


	}


}
