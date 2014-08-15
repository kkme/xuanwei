package com.weixuan.football.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;
import com.litesuits.http.response.handler.HttpModelHandler;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ListScoreboardAdapater;
import com.weixuan.football.entity.Standings;
import com.weixuan.football.util.Dict;
import com.weixuan.football.util.UrlApi;
import com.weixuan.football.util.Util;

import java.util.ArrayList;
import java.util.List;

/****
 * 积分榜
 *
 */
public class MScoreboardFragment extends BaseFragment{
    private List<Standings> data;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_m_scoreboard, container,false);
		initView(view, inflater);
        requestList();
		return view;
	}


    private void requestList(){
        Request req = new Request(Util.jointUrl(UrlApi.LIST,UrlApi.WEB_MODEL_CSL)).setMethod(HttpMethod.Get).
                addUrlParam(Dict.ACCESS_TOKEN, application.getToken().getAccess_token());

        asyncExecutor.execute(req,new HttpModelHandler<String>() {
            @Override
            protected void onSuccess(String str, Response res) {
                System.out.println(str+"========");
             List<Standings> ls=new ArrayList<Standings>();
              JSONArray array=JSON.parseArray(str) ;   //parseArray(str,Standings.class);

             ls.add(array.getObject(0,Standings.class));
              //  System.out.println(ls);
              adapter.notifyDataSetInvalidated();
            }

            @Override
            protected void onFailure(HttpException e, Response res) {

            }
        });

    }


    @Override
	protected void initView(View view, LayoutInflater inflater) {
        listView=(ListView)view.findViewById(R.id.ls_data);
        data=new ArrayList<Standings>();
        adapter=new ListScoreboardAdapater(getActivity(),data);
        listView.setAdapter(adapter);


	}

}
