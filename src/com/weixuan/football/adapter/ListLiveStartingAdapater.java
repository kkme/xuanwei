package com.weixuan.football.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.weixuan.football.R;

import java.util.List;

/**
 * Created by Hua on 2014/8/7.
 */
public class ListLiveStartingAdapater extends BaseAdapter {
    private List data;
    private Context context;
    private LayoutInflater inflater;
    public ListLiveStartingAdapater(Context context, List data){
        this.context=context;
        this.data=data;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (null==convertView){
            convertView=inflater.inflate(R.layout.list_item_live_starting, null);
            holder=new ViewHolder();
            holder.tv_item_0=(TextView)convertView.findViewById(R.id.tv_item_0);
            holder.tv_item_1=(TextView)convertView.findViewById(R.id.tv_item_1);
            holder.tv_item_2=(TextView)convertView.findViewById(R.id.tv_item_2);
            holder.tv_item_3=(TextView)convertView.findViewById(R.id.tv_item_3);

            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        if (position==0){
            View view1=new View(context);
            view1.setBackgroundResource(R.drawable.icon_down_arrow);
            LinearLayout layout= (LinearLayout) convertView;
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(0,0);
            params.gravity= Gravity.CENTER_VERTICAL;
            view1.setLayoutParams(params);
            layout.addView(view1);
        }
        LinearLayout layout= (LinearLayout) convertView;
        int count=layout.getChildCount();
        if(count>=5){
            layout.removeViews(5,count-5);
        }
        View view=new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.red));
        LinearLayout.LayoutParams  params=new LinearLayout.LayoutParams(8,40);
        params.width=40;
        params.height=70;
        params.gravity= Gravity.CENTER_VERTICAL;
        view.setLayoutParams(params);
        layout.addView(view);
        return convertView;
    }

   static class ViewHolder{
        TextView tv_item_0,tv_item_1,tv_item_2,tv_item_3;
        View iv_item_0,iv_item_1,iv_item_2;
    }

}
