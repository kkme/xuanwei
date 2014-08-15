package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.weixuan.football.R;
import com.weixuan.football.adapter.SpinnerAdapter;
import com.weixuan.football.util.Util;

/****
 * 新闻/公告
 *
 */
public class ClubTeamHistoryFragment extends Fragment{
    private RadioGroup rgGroup;
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
        this.rgGroup=(RadioGroup)view.findViewById(R.id.rg_group);
        rgGroup.check(R.id.rbtn_left_menu_0);

        Util.turnToFragment(getChildFragmentManager(), ClubTeamHistoryAFragment.class, null, R.id.fl_m_content);
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbtn_left_menu_0:
                        Util.turnToFragment(getChildFragmentManager(),ClubTeamHistoryAFragment.class, null, R.id.fl_m_content);
                        break;
                    case R.id.rbtn_left_menu_1:
                        Util.turnToFragment(getChildFragmentManager(), ClubTeamHistoryBFragment.class, null, R.id.fl_m_content);
                        break;
                    case R.id.rbtn_left_menu_2:
                        Util.turnToFragment(getChildFragmentManager(), ClubTeamHistoryCFragment.class, null, R.id.fl_m_content);
                        break;
                }
            }
        });
	}


}
