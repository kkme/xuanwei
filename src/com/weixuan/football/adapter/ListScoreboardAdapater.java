package com.weixuan.football.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.entity.Standings;
import com.weixuan.football.util.Util;

import java.util.List;

/**
 * Created by Hua on 2014/8/7.
 */
public class ListScoreboardAdapater extends BaseAdapter {
    private List<Standings> data;
    private Context context;

    public ListScoreboardAdapater(Context context, List<Standings> data){
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
            convertView=LayoutInflater.from(context).inflate(R.layout.list_item_scoreboard, null);
            holder=new ViewHolder();
            holder.tv_item_0=(TextView)convertView.findViewById(R.id.tv_item_0);
            holder.tv_item_1=(TextView)convertView.findViewById(R.id.tv_item_1);
            holder.tv_item_2=(TextView)convertView.findViewById(R.id.tv_item_2);
            holder.tv_item_3=(TextView)convertView.findViewById(R.id.tv_item_3);
            holder.tv_item_4=(TextView)convertView.findViewById(R.id.tv_item_4);
            holder.tv_item_5=(TextView)convertView.findViewById(R.id.tv_item_5);
            holder.tv_item_6=(TextView)convertView.findViewById(R.id.tv_item_6);
            holder.tv_item_7=(TextView)convertView.findViewById(R.id.tv_item_7);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        Standings standings=data.get(position);
        holder.tv_item_0.setText(String.valueOf(standings.getNo()));
        holder.tv_item_1.setText(standings.getTeam());
        holder.tv_item_2.setText(String.valueOf(standings.getSession()));
        holder.tv_item_3.setText(String.valueOf(standings.getWin()));
        holder.tv_item_4.setText(String.valueOf(standings.getDraw()));
        holder.tv_item_5.setText(String.valueOf(standings.getLose()));
        holder.tv_item_6.setText(standings.getJsq());
        holder.tv_item_7.setText(String.valueOf(standings.getScore()));

        Util.setTeamIconBg(holder.tv_item_1,0);
        return convertView;
    }

   static class ViewHolder{
        TextView tv_item_0,tv_item_1,tv_item_2,tv_item_3,tv_item_4,tv_item_5,tv_item_6,tv_item_7;
    }

}
