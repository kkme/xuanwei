package com.weixuan.football.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.weixuan.football.R;

/****
 * 俱乐部简介
 *
 */
public class ClubIntroductionAFragment extends BaseFragment{
    private RadioGroup rgGroup;
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_club_i_menu1, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    @Override
	public void initView(View view, LayoutInflater inflater) {


	}


}
