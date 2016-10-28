package com.dsz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsz.activity.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> listitem1,listitem2;
    private List<String> listitemStr;
    public ListViewAdapter(Context context, List<Integer> listitem1, List<Integer> listitem2, List<String> listitemStr){
        this.context=context;
        this.listitem1=listitem1;
        this.listitem2=listitem2;
        this.listitemStr=listitemStr;
    }
//    public ListViewAdapter(Context context, List<Integer>listitem1, List<String>listitemStr){
//        this.context=context;
//        this.listitem1=listitem1;
//        this.listitemStr=listitemStr;
//    }

    @Override
    public int getCount() {
        return listitem1.size()+1;
    }

    @Override
    public Object getItem(int position) {
        return listitem1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_item_keting,null);
        }
        ImageView imageView_sb=(ImageView)convertView.findViewById(R.id.jujia_sb_btn);
        ImageView imageView_kg=(ImageView)convertView.findViewById(R.id.jujia_kg_btn);
        TextView sb_textView=(TextView)convertView.findViewById(R.id._sb_name);
            imageView_sb.setBackgroundResource(listitem1.get(position));
            imageView_kg.setBackgroundResource(listitem2.get(position));
            sb_textView.setText(listitemStr.get(position));
        return null;
    }
}
