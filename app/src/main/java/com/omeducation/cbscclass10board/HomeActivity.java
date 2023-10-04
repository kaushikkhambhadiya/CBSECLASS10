package com.omeducation.cbscclass10board;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.tasks.OnSuccessListener;

public class HomeActivity extends AppCompatActivity {

    ImageView Share,Start,Fav;
    ListView applist;
    String[] App_Name = {"CBSE Class 7","CBSE Class 8","CBSE Class 9","CBSE Class 10","CBSE Class 11 commerce","CBSE Class 12 commerce","CBSE Class 11 Science", "CBSE Class 12 Science","GSEB NCERT ENG-GUJ Medium Textbook","GSEB Class 10","GTU Engineering"};
    int[] App_icon = {R.drawable.c7,R.drawable.c8,R.drawable.class_9,R.drawable.cbse_class10,R.drawable.comag,R.drawable.com_12, R.drawable.class11sci, R.drawable.class12sci,R.drawable.gseb_txtbook,R.drawable.class10_logo, R.drawable.gtu_logo};
    String[] packge_names = {"com.omeducation.cbse_class_7","com.omeducation.cbse_class_8","com.omeducation.cbse_class_9","com.cbscboard.cbscclass10board","com.omeducation.cbseclass11","com.omeducation.cbseclass12","com.omeducation.cbseclass11science", "com.omeducation.cbseclass12", "com.omeducation.gsebncerttextbooks", "com.mrkk.boardpapers","com.omeducation.gtuengineering"};


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Close Application")
                .setMessage("Are you sure you want to close this Application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNeutralButton("Rate Us", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        MobileAds.initialize(this, getString(R.string.App_Id));

//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(HomeActivity.this,  new OnSuccessListener<InstanceIdResult>() {
//            @Override
//            public void onSuccess(InstanceIdResult instanceIdResult) {
//                String newToken = instanceIdResult.getToken();
//                Log.e("newToken",newToken);
//                SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
//                SharedPreferences.Editor editor = pref.edit();
//                editor.putString("regId", newToken);
//                editor.apply();
//
//            }
//        });

        Share = (ImageView) findViewById(R.id.share);
        Start = (ImageView) findViewById(R.id.start);
        Fav = (ImageView) findViewById(R.id.rate);


        applist = (ListView) findViewById(R.id.applist);

        Applist_Adapter adapter = new Applist_Adapter(this, App_Name, App_icon);
        applist.setAdapter(adapter);

        applist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packge_names[i])));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packge_names[i])));
                }
            }
        });


        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int applicationNameId = getApplication().getApplicationInfo().labelRes;
                final String appPackageName = getApplication().getPackageName();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, getString(applicationNameId));
                String text = "Install this application To Get Good Marks in Exams: ";
                String link = "https://play.google.com/store/apps/details?id=" + appPackageName;
                i.putExtra(Intent.EXTRA_TEXT, text + " " + link);
                startActivity(Intent.createChooser(i, "Share via:"));
            }
        });

        Fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
            }
        });
    }


}
