package com.omeducation.cbscclass10board;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    WebView wv_webview;
    ProgressBar progressBar;
    String result_url = "https://cbseresults.nic.in/";
    AdRequest adRequest1;


    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        wv_webview = (WebView) view.findViewById(R.id.webview);
        wv_webview.getSettings().setJavaScriptEnabled(true);
        wv_webview.getSettings().setUseWideViewPort(true);
        wv_webview.getSettings().setBuiltInZoomControls(true);
        wv_webview.setInitialScale(1);

        wv_webview .loadUrl(result_url);

        wv_webview.setWebViewClient(new SSLTolerentWebViewClient());

        return view;
    }

    private boolean isInternetOn() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    // SSL Error Tolerant Web View Client
    private class SSLTolerentWebViewClient extends WebViewClient {

        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.INVISIBLE);
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

