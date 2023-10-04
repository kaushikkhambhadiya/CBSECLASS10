package com.omeducation.cbscclass10board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Applist_Adapter extends BaseAdapter {

    private Context context;
    private String[] App_Name;
    private int[] App_icon;
    private static LayoutInflater inflater = null;

    public Applist_Adapter(Context context, String[] App_Name, int[] App_icon) {
        this.context = context;
        this.App_Name = App_Name;
        this.App_icon = App_icon;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return App_Name.length;
    }

    @Override
    public String getItem(int i) {
        return App_Name[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder {
        TextView tvappname;
        ImageView ivappicon;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Applist_Adapter.Holder holder = new Applist_Adapter.Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.app_item, null);
        holder.tvappname = (TextView) rowView.findViewById(R.id.name);
        holder.ivappicon = (ImageView) rowView.findViewById(R.id.list_image);

        holder.tvappname.setText(App_Name[position]);
        holder.ivappicon.setImageResource(App_icon[position]);

        return rowView;
    }
}
