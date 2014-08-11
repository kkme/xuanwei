package com.weixuan.football.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.weixuan.football.R;
import com.weixuan.football.entity.News;
import com.weixuan.football.entity.RecentGameTeam;
import com.weixuan.football.util.DateUtil;

import java.util.List;

/**
 * Created by Hua on 2014/8/7.
 */
public class ListNewsAdapater extends BaseAdapter {
    private List<News> data;
    private Context context;

    public ListNewsAdapater(Context context, List<News> data){
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
            convertView=LayoutInflater.from(context).inflate(R.layout.list_item_news,null);
            holder=new ViewHolder();
            holder.tv_item_0=(TextView)convertView.findViewById(R.id.tv_item_0);
            holder.tv_item_1=(TextView)convertView.findViewById(R.id.tv_item_1);
            holder.tv_item_2=(TextView)convertView.findViewById(R.id.tv_item_2);

            holder.iv_item_0=(ImageView)convertView.findViewById(R.id.iv_item_0);
            holder.iv_item_1=(ImageView)convertView.findViewById(R.id.iv_item_1);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        News news=data.get(position);
        holder.tv_item_0.setText(news.getTitle());
        holder.tv_item_1.setText(Html.fromHtml(news.getContent()));

        holder.tv_item_2.setText(news.getCommentCount().toString());
        holder.iv_item_0.setImageResource(R.drawable.test_img);
        holder.iv_item_1.setImageResource(R.drawable.icon_comment);
        return convertView;
    }

   static class ViewHolder{
        TextView tv_item_0,tv_item_1,tv_item_2;
        ImageView iv_item_0,iv_item_1;
    }

}
