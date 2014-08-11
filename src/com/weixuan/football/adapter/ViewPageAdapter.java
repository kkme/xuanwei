package com.weixuan.football.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.weixuan.football.R;
import com.weixuan.football.fragment.LiveMainFragment;
import com.weixuan.football.fragment.MachanakysisFragment;
import com.weixuan.football.ui.MainActivity;

import java.util.List;

/**
 * Created by Hua on 2014/7/31.
 */
public class ViewPageAdapter extends PagerAdapter {
    private List<View> lsData;
    private MainActivity activity;
    public ViewPageAdapter (List<View> lsData,MainActivity activity){
        this.activity=activity;
        this.lsData=lsData;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)   {
        container.removeView(lsData.get(position));
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(lsData.get(position), 0);
        lsData.get(position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.page_0:
                        activity.turnToFragment(activity.getSupportFragmentManager(),LiveMainFragment.class,null);
                         break;
                    case R.id.page_1:
                        activity.turnToFragment(activity.getSupportFragmentManager(),MachanakysisFragment.class,null);
                        break;
                }
            }
        });
        return lsData.get(position);
    }


    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }
}
