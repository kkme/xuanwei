package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.weixuan.football.data.RequestManager;
import com.weixuan.football.view.PullToRefreshListView;

/**
 * Created by Hua on 2014/8/7.
 */
public abstract class BaseFragment extends Fragment {
    protected PullToRefreshListView pullListView=null;
    protected ListView listView=null;
    protected BaseAdapter adapter=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /***
     * 初始化
     */
    protected    abstract void initView(View view,LayoutInflater inflater);


    protected void executeRequest(Request<?> request) {
        RequestManager.addRequest(request, getActivity());
    }

    protected Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
    }
}
