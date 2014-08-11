package com.weixuan.football.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ViewPageAdapter;
import com.weixuan.football.ui.MainActivity;
import com.weixuan.football.util.Dict;
import com.weixuan.football.util.Util;

import java.util.Timer;
import java.util.TimerTask;

/****
 * 赛事直播
 *
 */
public class LiveMainFragment extends Fragment{

    private RadioGroup rgGroupM;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_live_main, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
	private void initView(View view, LayoutInflater inflater) {

        this.rgGroupM = (RadioGroup) view.findViewById(R.id.rg_group_m);
        rgGroupM.check(R.id.rbtn_left_menu_0);
        Util.turnToFragment(getChildFragmentManager(), LiveStartingFragment.class, null, R.id.fl_m_content);
        rgGroupM.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtn_left_menu_0:
                        Util.turnToFragment(getChildFragmentManager(), LiveStartingFragment.class, null, R.id.fl_m_content);
                        break;
                    case R.id.rbtn_left_menu_1:
                        Util.turnToFragment(getChildFragmentManager(), LiveLanqiuFragment.class, null, R.id.fl_m_content);
                    break;
                    case R.id.rbtn_left_menu_2:
                        Util.turnToFragment(getChildFragmentManager(), LiveDataFragment.class, null, R.id.fl_m_content);
                        break;
                }
            }
        });

    }
}
