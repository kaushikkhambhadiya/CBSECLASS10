package com.omeducation.cbscclass10board;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    GridView gvsublist;
    int[] subicons = {R.drawable.maths,R.drawable.science,R.drawable.socialscience,R.drawable.english,R.drawable.english,R.drawable.hindi,R.drawable.hindi,R.drawable.sanskr};
    String[] subnames = {"Maths","Science","Social Science","English Commutative","English Language","Hindi-A","Hindi-B","Sanskrit"};
    SubAdapter subAdapter;
    private FirebaseAnalytics  mFirebaseAnalytics;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final AdView mAdView = view.findViewById(R.id.adView);
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


        // Obtain the shared Tracker instance.
        AppController application = (AppController) getActivity().getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "Subject List");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "MainActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        gvsublist = view.findViewById(R.id.gvsublist);
        subAdapter = new SubAdapter(getContext(),subnames,subicons);
        gvsublist.setAdapter(subAdapter);

        gvsublist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(),ContentActivity.class);
                intent.putExtra("subject_position",position);
                intent.putExtra("subject_name",subnames[position]);
                startActivity(intent);
            }
        });

        return view;
    }

}
