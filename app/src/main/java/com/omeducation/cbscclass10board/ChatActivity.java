package com.omeducation.cbscclass10board;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {

    RecyclerView chat_recycleview;
    EditText etmsg;
    Button btsend;
    Toolbar toolbar;
    private String username;
    private DatabaseReference mDatabase;
    private ArrayList<Message_Model> chat_list;
    private ChatAdapter mAdapter;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final AdView mAdView = findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdSwipeGestureClicked() {
                super.onAdSwipeGestureClicked();
            }
        });


        mDatabase = FirebaseDatabase.getInstance().getReference();
        SharedPreferences prefs = getSharedPreferences("MY_USER_NAME", MODE_PRIVATE);
        username = prefs.getString("USERNAME", null);

        chat_recycleview = findViewById(R.id.chat_recycleview);
        etmsg = findViewById(R.id.etmsg);
        btsend = findViewById(R.id.btsend);

        AppController application = (AppController) this.getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "ChatActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "ChatActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ChatActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Group Chat");


//        ChildEventListener msgListner = new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                if (dataSnapshot.exists()) {
//                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                        Message_Model messageModel = postSnapshot.getValue(Message_Model.class);
//                        chat_list.add(messageModel);
//                    }
//                    mAdapter = new ChatAdapter(chat_list);
//                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//                    chat_recycleview.setLayoutManager(mLayoutManager);
//                    chat_recycleview.setItemAnimator(new DefaultItemAnimator());
//                    chat_recycleview.setAdapter(mAdapter);
//                    mAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//        mDatabase.child("Chat_Room").addChildEventListener(msgListner);

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    chat_list = new ArrayList<>();
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Message_Model messageModel = postSnapshot.getValue(Message_Model.class);
                        chat_list.add(messageModel);
                    }
                    mAdapter = new ChatAdapter(ChatActivity.this, chat_list);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    chat_recycleview.setLayoutManager(mLayoutManager);
                    chat_recycleview.setItemAnimator(new DefaultItemAnimator());
                    chat_recycleview.setAdapter(mAdapter);
                    chat_recycleview.scrollToPosition(chat_list.size() - 1);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.child("Chat_Room").addValueEventListener(valueEventListener);


        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message_text = etmsg.getText().toString();
                if (!message_text.equals("")) {
//                    Date currentTime = Calendar.getInstance().getTime();
                    Date today = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("dd MMM hh:mm a");
                    String currentTime = format.format(today);
                    Message_Model message_model = new Message_Model(username, message_text, currentTime);
                    mDatabase.child("Chat_Room").push().setValue(message_model);
                    etmsg.setText("");
                } else {
                    Toast.makeText(ChatActivity.this, "Please Write Message before Send", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
