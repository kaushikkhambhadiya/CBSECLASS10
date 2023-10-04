package com.omeducation.cbscclass10board;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

import static com.omeducation.cbscclass10board.Config.clickNumber;


public class TabActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    String title;
    String contenturl;
    String contenturlsolution;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        AppController.getInstance().showinterstitialad(TabActivity.this);

        title = getIntent().getStringExtra("title");
        contenturl = getIntent().getStringExtra("contenturl");
        contenturlsolution = getIntent().getStringExtra("contenturlsolution");

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



        

        AppController application = (AppController) this.getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "TabActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "TabActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "TabActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (title!=null){
            getSupportActionBar().setTitle(title);
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Paper"));
        tabLayout.addTab(tabLayout.newTab().setText("Solution"));
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        viewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        tabLayout.getTabAt(position).select();
                    }
                });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PaperTab(), "Paper");
        adapter.addFragment(new SolutionTab(), "Solution");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
//            return mFragmentList.get(position);
            switch (position) {
                case 0:
                    Bundle bundle = new Bundle();
                    bundle.putString("contenturl", contenturl);
                    PaperTab fragobj1 = new PaperTab();
                    fragobj1.setArguments(bundle);
                    return fragobj1;
                case 1:
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("contenturlsolution", contenturlsolution);
                    SolutionTab fragobj = new SolutionTab();
                    fragobj.setArguments(bundle1);
                    return fragobj;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
