package com.omeducation.cbscclass10board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SubAdapter extends BaseAdapter {

    private Context context;
    private String[] subjnames;
    private int[] subicons;
    private static LayoutInflater inflater=null;

    public SubAdapter(Context context, String[] subjnames, int[] subicons) {
        this.context = context;
        this.subjnames = subjnames;
        this.subicons = subicons;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return subjnames.length;
    }

    @Override
    public Object getItem(int i) {
        return subjnames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder
    {
        TextView tvsubject;
        ImageView ivsubject;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.subject_item, null);
        holder.tvsubject=(TextView) rowView.findViewById(R.id.textView1);
        holder.ivsubject=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tvsubject.setText(subjnames[position]);
        holder.ivsubject.setImageResource(subicons[position]);

        return rowView;
    }
}
