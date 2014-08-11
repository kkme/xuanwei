package com.weixuan.football.fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.weixuan.football.R;
import android.support.v4.widget.SwipeRefreshLayout;
import com.weixuan.football.adapter.ListNewsAdapater;
import com.weixuan.football.adapter.ViewPageAdapter;
import com.weixuan.football.entity.News;
import com.weixuan.football.ui.MainActivity;
import com.weixuan.football.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import com.weixuan.football.util.Dict;
import com.weixuan.football.view.PullToRefreshBase;
import com.weixuan.football.view.PullToRefreshListView;

/****
 * 新闻/公告
 *
 */
public class NewsFragment extends BaseFragment{

    private List<News> data;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.public_listview, container,false);
		initView(view, inflater);
		return view;
	}

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    protected void initView(final View view, LayoutInflater inflater) {
        pullListView=(PullToRefreshListView)view.findViewById(R.id.ls_data);
        pullListView.setPullLoadEnabled(false);
        pullListView.setScrollLoadEnabled(true);
        listView=pullListView.getRefreshableView();
        listView.setAdapter(adapter);
        listView.setDivider(getResources().getDrawable(R.drawable.ls_divider));
        pullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                pullListView.onPullDownRefreshComplete();
                pullListView.onPullUpRefreshComplete();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        data=new ArrayList<News>();
        News news=new News();
        news.setCommentCount(99);
        news.setTitle("摩纳哥坦承法尔考未来在皇马");
        news.setContent("如果说皇马攻击阵容还有哪里不完美的话，那就是中锋位置上深度不够。在莫拉塔离队后，皇马只剩下了本泽马这一名中锋，这也正是皇马想要收购法尔考的原因所在。摩纳哥副主席在接受《马卡报》采访时公开宣称，皇马今夏从未求购过法尔考。");
        data.add(news);
        data.add(news);
        data.add(news);
        adapter=new ListNewsAdapater(getActivity(),data);
        listView.setAdapter(adapter);

	}


}
