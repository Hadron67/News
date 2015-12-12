package com.xiao.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.xiao.news.R.id.pushitem_title;

/**
 * Created by cfy on 15-12-7.
 */
public class PushItemAdapter extends BaseAdapter{
    private ArrayList<PushData> data;

    private Context ctx;
    public PushItemAdapter(Context ctx){
        this.ctx = ctx;
        data = new ArrayList<>();
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.layout_pushlistitem,null);
        }
        TextView time = (TextView) convertView.findViewById(R.id.pushitem_time);
        TextView title = (TextView) convertView.findViewById(pushitem_title);

        time.setText(data.get(position).time);
        title.setText(data.get(position).title);

        return convertView;
    }

    public void addItem(PushData data){
        this.data.add(data);
    }
}
