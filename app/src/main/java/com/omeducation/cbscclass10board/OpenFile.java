package com.omeducation.cbscclass10board;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;

import static com.omeducation.cbscclass10board.Config.clickNumber;

public class OpenFile extends AppCompatActivity {

    WebView wv_webview;
    Toolbar toolbar;
    String title;
    String contenturl;
    ProgressBar progressBar;
    AdRequest adRequest1;


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
        setContentView(R.layout.activity_open_file);

        AppController.getInstance().showinterstitialad(OpenFile.this);

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


        

        title = getIntent().getStringExtra("title");
        contenturl = getIntent().getStringExtra("contenturl");
        Log.i("titleofcategory",title);

        AppController application = (AppController) this.getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "OpenFile");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "OpenFile");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "OpenFile");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (title!=null){
            getSupportActionBar().setTitle(title);
        }

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        wv_webview = (WebView) findViewById(R.id.webview);
        wv_webview.getSettings().setJavaScriptEnabled(true);
        wv_webview.getSettings().setDomStorageEnabled(true);
        wv_webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        wv_webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);


        if (contenturl!=null && !contenturl.equals("")){
            //"http://drive.google.com/viewerng/viewer?embedded=true&url=" + "https://drive.google.com/uc?id=" + GujPapers[paperposition] + "&export=download"
            wv_webview .loadUrl(contenturl);
        }else{
            wv_webview.loadUrl("https://drive.google.com/open?id=1-JCYpMX1OZPAM9p0i_wqgLv2GGBuNMdu");
        }

        wv_webview.setWebViewClient(new SSLTolerentWebViewClient());
    }

    private boolean isInternetOn() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    // SSL Error Tolerant Web View Client
    private class SSLTolerentWebViewClient extends WebViewClient {

        AlertDialog alertDialog = new AlertDialog.Builder(OpenFile.this).create();

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            wv_webview.loadUrl("javascript:(function() { " +
                    "document.querySelector('[role=\"toolbar\"]').remove();})()");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.INVISIBLE);
            wv_webview.loadUrl("javascript:(function() { " +
                    "document.querySelector('[role=\"toolbar\"]').remove();})()");
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            if (!isInternetOn()) {
                alertDialog.setTitle("Connection Error");
                alertDialog.setMessage("You need to be connected to the internet.");
            } else {
                alertDialog.setTitle("Error");
                alertDialog.setMessage(description);
            }
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            alertDialog.show();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        wv_webview.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        wv_webview.onResume();
    }

}