package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ListLiveLanqiuAdapater;

import java.util.ArrayList;
import java.util.List;

/****
 * 实力对比
 *
 */
public class MPowerFragment extends BaseFragment{


    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_m_power, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    protected void initView(View view, LayoutInflater inflater) {
        listView=(ListView)view.findViewById(R.id.ls_data);
        List data=new ArrayList();
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        data.add(1);
        adapter=new ListLiveLanqiuAdapater(getActivity(),data);
        listView.setAdapter(adapter);

	}


}
