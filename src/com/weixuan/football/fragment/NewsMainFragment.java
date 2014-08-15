package com.weixuan.football.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.weixuan.football.R;
import com.weixuan.football.adapter.ViewPageAdapter;
import com.weixuan.football.ui.MainActivity;
import com.weixuan.football.util.Dict;
import com.weixuan.football.util.Util;
import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

/****
 * 新闻/公告
 *
 */
public class NewsMainFragment extends BaseFragment{

    private SwipeRefreshLayout srl_refresh;
    private ListView lsData;
    private ViewPager viewPager;
    private RadioGroup rgGroup;
    private TextView tv_title;
    /** 轮播左方view   */
    private LinearLayout ll_lunbo,ll_lunbo_page;
    /** 轮播页总数   */
    private int pageCount=2;
    /*** 轮播部分     **/
    private TextView tv_type,tv_benlun,tv_benlun_against0,tv_benlun_against1,
            tv_benlun_date,tv_benlun_score0,tv_benlun_score1;
    private ImageView iv_against_icon0,iv_against_icon1;

    private  Animation mAnimationRight;
    private int flag=0;

    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_news, container,false);
		initView(view, inflater);
		return view;
	}

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case Dict.HANDLER_CHENGE_PAGE:
                   changePage(msg.arg1);
                    break;
            }
        }
    };

    /****
     * 初始化
     * @param view
     * @param inflater
     */
    @Override
	public void initView(final View view, LayoutInflater inflater) {
        tv_title=(TextView)view.findViewById(R.id.tv_title);
        ll_lunbo=(LinearLayout)view.findViewById(R.id.ll_lunbo);
        ll_lunbo_page=(LinearLayout)view.findViewById(R.id.ll_lunbo_page);

        tv_type=(TextView)view.findViewById(R.id.tv_type);
        tv_benlun=(TextView)view.findViewById(R.id.tv_benlun);
        tv_benlun_against0=(TextView)view.findViewById(R.id.tv_benlun_against0);
        tv_benlun_against1=(TextView)view.findViewById(R.id.tv_benlun_against1);
        tv_benlun_date=(TextView)view.findViewById(R.id.tv_benlun_date);
        tv_benlun_score0=(TextView)view.findViewById(R.id.tv_benlun_score0);
        tv_benlun_score1=(TextView)view.findViewById(R.id.tv_benlun_score1);
        iv_against_icon0=(ImageView)view.findViewById(R.id.iv_against_icon0);
        iv_against_icon1=(ImageView)view.findViewById(R.id.iv_against_icon1);
        Util.turnToFragment(getChildFragmentManager(),NewsFragment.class,null,R.id.fl_news_content);
        ll_lunbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==0){
                    Util.turnToFragment(getChildFragmentManager(),LiveMainFragment.class,null,R.id.fl_news_content);
                    setTitle(R.string.title_first_list);
                }else if(flag==1){
                    Util.turnToFragment(getChildFragmentManager(),MachanakysisFragment.class,null,R.id.fl_news_content);
                    setTitle(R.string.title_matchanalysis);
                }
            }
        });

        tv_title.setText(getString(R.string.title_shouye));

        TimerTask timerTask=new TimerTask() {
            int index=0;
            @Override
            public void run() {
                index++;
                if (index>=pageCount){
                    index=0;
                }
                Message msg=new Message();
                msg.arg1=index;
                msg.what=Dict.HANDLER_CHENGE_PAGE;
               handler.sendMessage(msg);

            }
        };
        mAnimationRight = AnimationUtils.loadAnimation( getActivity(), R.anim.scale);

        Timer timer=new Timer();
        timer.schedule(timerTask,0,6000);



	}

    /***
     * 改变圆点页
     * @param index
     */
    private void changePage(int index){
        for (int i=0;i<2;i++){
              ll_lunbo_page.getChildAt(i).setBackgroundResource(R.drawable.page_no);
        }
        ll_lunbo_page.getChildAt(index).setBackgroundResource(R.drawable.page_select);
        switch (index){
            case 0:
                tv_type.setText("直播中");
                tv_type.setAnimation(mAnimationRight);
                flag=0;
                break;
            case 1:
                tv_type.setText("赛事分析");
                tv_type.setAnimation(mAnimationRight);
                flag=1;
                break;

        }
    }

    /***
     * 设置标题
     * @param resId
     */
    public void setTitle(int resId){
        tv_title.setText(getString(resId));
    }

}
