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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaperTab extends Fragment {

    WebView wv_webview;
    ProgressBar progressBar;
    String contenturl;

    public PaperTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paper_tab, container, false);

        contenturl = getArguments().getString("contenturl");
        Log.i("cp", String.valueOf(contenturl));


        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        wv_webview = (WebView) view.findViewById(R.id.webview);
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
