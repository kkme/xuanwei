package com.weixuan.football.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.weixuan.football.R;

/**
 * Created by Hua on 2014/7/30.
 */
public class LeftMenuAdapter extends BaseAdapter {

    private String[] data;
    private LayoutInflater inflater;
    public LeftMenuAdapter(String[] data,LayoutInflater inflater){
        this.data=data;
        this.inflater=inflater;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView=null;
        if(null==convertView){
            View  view=inflater.inflate(R.layout.left_menu_list_item,null);
            convertView=view;
        }
        ((TextView)convertView).setText(data[position]);
        return convertView;
    }
}
