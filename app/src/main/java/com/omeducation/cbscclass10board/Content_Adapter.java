package com.omeducation.cbscclass10board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mahesh on 12-02-2018.
 */

public class Content_Adapter extends BaseAdapter {

    private Context context;
    // Keep all Images in array
    private Integer[] content_icons;
    private String[] content_names;
    private static LayoutInflater inflater=null;

    // Constructor
    public Content_Adapter(Context c){
        context = c;
    }

    public Content_Adapter(Context context, Integer[] content_icons, String[] content_names) {
        this.context = context;
        this.content_icons = content_icons;
        this.content_names = content_names;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return content_names.length;
    }

    @Override
    public Object getItem(int position) {
        return content_names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tvsubject;
        ImageView ivsubject;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.subject_item, null);
        holder.tvsubject=(TextView) rowView.findViewById(R.id.textView1);
        holder.ivsubject=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tvsubject.setText(content_names[position]);
        holder.ivsubject.setImageResource(content_icons[position]);

        return rowView;
    }
}
