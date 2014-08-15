package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.util.Util;

/****
 * 新闻/公告
 *
 */
public class ClubTeamHistoryBFragment extends BaseFragment{
    private TextView tv_type;
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_club_h_menu2, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
	public void initView(View view, LayoutInflater inflater) {
        tv_type=(TextView)view.findViewById(R.id.tv_type);
        listView=(ListView)view.findViewById(R.id.ls_data);
	}


}
