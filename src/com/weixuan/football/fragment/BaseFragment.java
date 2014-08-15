package com.weixuan.football.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.async.HttpAsyncExecutor;
import com.weixuan.football.ui.FootballApplication;
import com.weixuan.football.view.PullToRefreshListView;

/**
 * Created by Hua on 2014/8/7.
 */
public abstract class BaseFragment extends Fragment {
    protected PullToRefreshListView pullListView=null;
    protected ListView listView=null;
    protected BaseAdapter adapter=null;

    protected FootballApplication application;
    protected LiteHttpClient client;
    protected HttpAsyncExecutor asyncExecutor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application=(FootballApplication)getActivity().getApplication();
        client= LiteHttpClient.getInstance(getActivity());
        asyncExecutor=HttpAsyncExecutor.newInstance(client);
    }

    /***
     * 初始化
     */
    protected    abstract void initView(View view,LayoutInflater inflater);


//    protected void executeRequest(Request<?> request) {
//        RequestManager.addRequest(request, getActivity());
//    }
//
//    protected Response.ErrorListener errorListener() {
//        return new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        };
//    }
}
