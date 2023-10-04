package com.omeducation.cbscclass10board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class VideoAdapter extends BaseAdapter {

    private Context context;
    public ArrayList<String> video_icons;
    public ArrayList<String> video_names;
    private static LayoutInflater inflater=null;

    public VideoAdapter(Context context, ArrayList<String> video_icons, ArrayList<String> video_names) {
        this.context = context;
        this.video_icons = video_icons;
        this.video_names = video_names;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class Holder
    {
        TextView tvtitle;
        ImageView ivthumblain;
    }

    @Override
    public int getCount() {
        return video_names.size();
    }

    @Override
    public Object getItem(int position) {
        return video_names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.video_item, null);
        holder.tvtitle=(TextView) rowView.findViewById(R.id.textView1);
        holder.ivthumblain=(ImageView) rowView.findViewById(R.id.imageView1);

        if (video_names.get(position) != null){
            holder.tvtitle.setText(video_names.get(position));
        }else {
            holder.tvtitle.setText(String.format("%d", position + 1));
        }

        Picasso.with(context).load(video_icons.get(position)).into(holder.ivthumblain);

        return rowView;
    }
}
