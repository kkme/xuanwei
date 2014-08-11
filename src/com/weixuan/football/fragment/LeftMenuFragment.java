package com.weixuan.football.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.weixuan.football.R;
import com.weixuan.football.ui.MainActivity;

/****
 * 新闻/公告
 *
 */
public class LeftMenuFragment extends Fragment{
    public RadioGroup rgGroup;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.left_menu, container,false);
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
       final   MainActivity activity =(MainActivity)getActivity();
        activity.turnToFragment(getFragmentManager(),NewsMainFragment.class,null);
       rgGroup.check(R.id.rbtn_left_menu_1);
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbtn_left_menu_0:
                        break;
                    case R.id.rbtn_left_menu_1:
                        activity.turnToFragment(getFragmentManager(),NewsMainFragment.class,null);
                        break;
                    case R.id.rbtn_left_menu_2:
                        activity.turnToFragment(getFragmentManager(),ScheduleFragment.class,null);
                        break;
                    case R.id.rbtn_left_menu_3:
                        activity.turnToFragment(getFragmentManager(),ClubFragment.class,null);
                        break;
                    case R.id.rbtn_left_menu_4:
                        activity.turnToFragment(getFragmentManager(),TeamMainFragment.class,null);
                        break;
                }
            }
        });
	}


}
