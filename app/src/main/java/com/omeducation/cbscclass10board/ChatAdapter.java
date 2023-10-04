package com.omeducation.cbscclass10board;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private Context mcontex;
    private String shusername;
    private ArrayList<Message_Model> chat_message_list;
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;

    public ChatAdapter(Context mcontex, ArrayList<Message_Model> chat_message_list) {
        this.chat_message_list = chat_message_list;
        this.mcontex = mcontex;
        SharedPreferences prefs = mcontex.getSharedPreferences("MY_USER_NAME", MODE_PRIVATE);
        shusername = prefs.getString("USERNAME", null);
    }

    // determine which layout to use for the row
    @Override
    public int getItemViewType(int position) {
        Message_Model item = chat_message_list.get(position);
        if (item.getStundet_name().equals(shusername)) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.message_item, parent, false);
//
//        return new MyViewHolder(itemView);

        if (viewType == TYPE_ONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_message_item, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == TYPE_TWO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
            return new MyViewHolder(view);
        } else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message_Model message_model = chat_message_list.get(position);
        holder.message_text.setText(message_model.getStudent_Message());
        holder.tvusername.setText(message_model.getStundet_name());
        holder.tvtime.setText(message_model.getMsg_Time());

    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return chat_message_list == null ? 0 : chat_message_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView message_text,tvusername,tvtime;

        public MyViewHolder(View view) {
            super(view);
            message_text = (TextView) view.findViewById(R.id.tvmessage);
            tvusername = (TextView) view.findViewById(R.id.tvusername);
            tvtime = (TextView) view.findViewById(R.id.tvtime);
        }
    }

}
