package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.weixuan.football.R;
import com.weixuan.football.view.FormationView;

/****
 *
 *
 */
public class TeamAFragment extends Fragment{
    private RadioGroup rgGroup;

    private FormationView fl_view;
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_team_a, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
	private void initView(View view, LayoutInflater inflater) {
        rgGroup=(RadioGroup)view.findViewById(R.id.rg_group);
        rgGroup.check(R.id.rbtn_left_menu_0);
        fl_view=(FormationView)view.findViewById(R.id.fl_view);


        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        fl_view.measure(w, h);
        int height =fl_view.getMeasuredHeight();
        int width =fl_view.getMeasuredWidth();
        fl_view.initData(width,height);
        fl_view.setOnItemClickListener(new FormationView.OnItemClickListener() {
            @Override
            public void onItemClick(String number, boolean flag) {

            }
        });


	}


}
