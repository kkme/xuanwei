package com.weixuan.football.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.entity.RecentGameTeam;
import com.weixuan.football.util.DateUtil;
import com.weixuan.football.util.Util;

import java.util.List;

/**
 * Created by Hua on 2014/8/7.
 */
public class ListClubHistoryAdapater extends BaseAdapter {
    private List data;
    private Context context;

    public ListClubHistoryAdapater(Context context, List data){
        this.context=context;
        this.data=data;

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
            convertView=LayoutInflater.from(context).inflate(R.layout.list_item_history,null);
            holder=new ViewHolder();
            holder.tv_item_0=(TextView)convertView.findViewById(R.id.tv_item_0);
            holder.tv_item_1=(TextView)convertView.findViewById(R.id.tv_item_1);
            holder.tv_item_2=(TextView)convertView.findViewById(R.id.tv_item_2);
            holder.tv_item_3=(TextView)convertView.findViewById(R.id.tv_item_3);
            holder.tv_item_4=(TextView)convertView.findViewById(R.id.tv_item_4);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        return convertView;
    }

   static class ViewHolder{
        TextView tv_item_0,tv_item_1,tv_item_2,tv_item_3,tv_item_4;
    }

}
