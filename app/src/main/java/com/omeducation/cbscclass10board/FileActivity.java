package com.omeducation.cbscclass10board;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;

import static com.omeducation.cbscclass10board.Config.clickNumber;

public class FileActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;
    String title;
    String[] filesnamelist;
    String[] fileurls;
    String[] solution_urls;
    private int subject_position;
    private int content_position;


    String[] english22019paper3l = {"https://drive.google.com/open?id=1WnjHx4VcUgWwKtM2hjc7AEP05Ips1-Pm"};
    String[] english22019paper_title3l = {"CBSE 2019 Set Delhi 3 English Language Question Papers With Solution"};
    String[] english22019paper2l = {"https://drive.google.com/open?id=1EDBBEh5yiErUAOWeKZaaWSwPPqWslCDX"};
    String[] english22019paper_title2l = {"CBSE 2019 Set Delhi 2 English Language Question Papers With Solution"};
    String[] english22019paper1l = {"https://drive.google.com/open?id=1AHRrYmCPC8ZFcP-_rl9XdATyCmfBHWgn"};
    String[] english22019paper_title1l = {"CBSE 2019 Set Delhi 1 English Language Question Papers With Solution"};
    String[] english22019paper1c = {"https://drive.google.com/open?id=1Km6FOg1DVJYMO9ILlGafvZm-K3SmYf6K"};
    String[] english22019paper_title1c = {"CBSE 2019 Set Delhi 1 English Commutative Question Papers With Solution"};

    String[] english22019paper3call = {"https://drive.google.com/open?id=1FKhwtLm5F3fWmFptFquLTvY8h_vb3D0h"};
    String[] english22019paper_title3call = {"CBSE 2019 Set All india 3 English Commutative Question Papers With Solution"};
    String[] english22019paper2caboard = {"https://drive.google.com/open?id=1PINvFJ_k0HLj_Eswd9pbRY5BiHdcMGAC"};
    String[] english22019paper_title2caboard = {"CBSE 2019 Set Aboard 2 English Commutative Question Papers With Solution"};


    String[] englishcommut_All_iurl = {"","","","","","","","","","https://drive.google.com/open?id=1Km6FOg1DVJYMO9ILlGafvZm-K3SmYf6K",
    "https://drive.google.com/open?id=1PINvFJ_k0HLj_Eswd9pbRY5BiHdcMGAC","https://drive.google.com/open?id=1FKhwtLm5F3fWmFptFquLTvY8h_vb3D0h"};


    String[] englishlangu_All_iurl = {"","","","","","https://drive.google.com/open?id=1AHRrYmCPC8ZFcP-_rl9XdATyCmfBHWgn",
            "https://drive.google.com/open?id=1EDBBEh5yiErUAOWeKZaaWSwPPqWslCDX","https://drive.google.com/open?id=1WnjHx4VcUgWwKtM2hjc7AEP05Ips1-Pm"};

    //hindi
    String[] HindiB2019paper2 = {"https://drive.google.com/open?id=1wOz_q5KiTuNCxQXc6eV4OM4NAnZmdRgV"};
    String[] HindiB2019paper_title2 = {"CBSE 2019 Set Delhi 2 Hindi Course-B Question Papers With Solution"};
    String[] HindiA2019paper1 = {"https://drive.google.com/open?id=1YDnJLucmyMj47kF-DmwFwGJugnm3NJz6"};
    String[] HindiA2019paper_title1 = {"CBSE 2019 Set Delhi 1 Hindi Course-A Question Papers With Solution"};
    String[] HindiA2019paper2 = {"https://drive.google.com/open?id=1OQkHkpRoAGeaKWeqX73KyoBlxEnRBFi1"};
    String[] HindiA2019paper_title2 = {"CBSE 2019 Set Delhi 2 Hindi Course-A Question Papers With Solution"};
    String[] HindiA2019paper_title3 = {"CBSE 2019 Set Delhi 3 Hindi Course-A Question Papers With Solution"};
    String[] HindiA2019paper3 = {"https://drive.google.com/open?id=1WIlojnF5Vvv1ABSf0b7QL2Re6hK6kGzm"};


    String[] hindiA_All_iurl = {"","","","","","https://drive.google.com/open?id=1YDnJLucmyMj47kF-DmwFwGJugnm3NJz6",
            "https://drive.google.com/open?id=1OQkHkpRoAGeaKWeqX73KyoBlxEnRBFi1","https://drive.google.com/open?id=1WIlojnF5Vvv1ABSf0b7QL2Re6hK6kGzm"};

    String[] hindiB_All_iurl = {"","","","","","","","","https://drive.google.com/open?id=1wOz_q5KiTuNCxQXc6eV4OM4NAnZmdRgV"};
    //science

    String[] Science2019paper1 = {"https://drive.google.com/open?id=1LQ1ctwOS5TMmsGTn4KZh4eRCpec5O0IB"};
    String[] Science2019paper_title1 = {"CBSE 2019 Set Delhi 1 Science Question Papers With Solution"};
    String[]science_delhi2019paper_title3 = {"CBSE 2019 Set Delhi 3 Science Question Papers With Solution"};
    String[]science_delhi2019paper3 = {"https://drive.google.com/open?id=1BwLjV6iATdK8Tx5OHOUBATDTX8Vnyqlp"};
    String[]science_delhi2019paper_title2 = {"CBSE 2019 Set Delhi 2 Science Question Papers With Solution"};
    String[]science_delhi2019paper2 = {"https://drive.google.com/open?id=1I2Lbr6_PTJ0wW2AJhM6oWVslZV6LAVN2"};
    String[] science_All_india2019paper1_title = {"CBSE 2019 Set All india 1 Science Question Papers With Solution"};
    String[] science_All_india2019paper1 = {"https://drive.google.com/open?id=10z1lQCS5hSDQlifhqBzFFvWuStBGCYm9"};
    String[] science_abroad2019paper2_title = {"CBSE 2019 Set Aboard 2 Science Question Papers With Solution"};
    String[] science_abroad2019paper2 = {"https://drive.google.com/open?id=17xhyaZwaWhf68aObV5BN8Kzx7PsPRWW-"};

    String[] science_All_iurl = {"","","","","","","","","","","","","","","","",
            "https://drive.google.com/open?id=1LQ1ctwOS5TMmsGTn4KZh4eRCpec5O0IB",
            "https://drive.google.com/open?id=1I2Lbr6_PTJ0wW2AJhM6oWVslZV6LAVN2","https://drive.google.com/open?id=1BwLjV6iATdK8Tx5OHOUBATDTX8Vnyqlp",
            "https://drive.google.com/open?id=10z1lQCS5hSDQlifhqBzFFvWuStBGCYm9",
            "https://drive.google.com/open?id=17xhyaZwaWhf68aObV5BN8Kzx7PsPRWW-"};
    //maths

    String[] maths_abroad2019paper_title2 = {"CBSE 2019 Set Abroad 2 Maths Question Papers With Solution"};
    String[] maths_abroad2019paper2= {"https://drive.google.com/open?id=1CurgBTCWy4g1ucXJFedXA3szH9WCHz8K"};
    String[] maths_abroad2019paper_title3 = {"CBSE 2019 Set Aboard 3 Maths Question Papers With Solution"};
    String[] maths_abroad2019paper3 = {"https://drive.google.com/open?id=1hQOLmFpTDZ_XEoxR0BbQfduSW6_Ja-pg"};
    String[] maths_delhi2019paper3 = {"https://drive.google.com/open?id=1vdyCCcBYZcIwn_rthAKSbfQ6qhgY08ma"};
    String[] maths_delhi2019paper_title3 = {"CBSE 2019 Set Delhi 3 Maths Question Papers With Solution"};
    String[] maths_delhi2019paper2 = {"https://drive.google.com/open?id=1uxnzaMY1GrR9yJF86VIIxny5fbn9Qoke"};
    String[] maths_delhi2019paper_title2 = {"CBSE 2019 Set Delhi 2 Maths Question Papers With Solution"};
    String[] maths_delhi2019paper1 = {"https://drive.google.com/open?id=1Hlz_153MZPyB5Wngk60nVXPq6gBr5xGH"};
    String[] maths_delhi2019paper_title1 = {"CBSE 2019 Set Delhi 1 Maths Question Papers With Solution"};
    String[] maths_All_india2019paper2 = {"https://drive.google.com/open?id=1cN1h4lRUnx7U33SdwVGrzgcPhNR-UHA5"};
    String[] maths_All_india2019paper2_title = {"CBSE 2019 Set All India 2 Maths Question Papers With Solution"};

    String[] maths_All_iurl = {"","","","","","","","","","https://drive.google.com/open?id=1Hlz_153MZPyB5Wngk60nVXPq6gBr5xGH",
            "https://drive.google.com/open?id=1uxnzaMY1GrR9yJF86VIIxny5fbn9Qoke",
            "https://drive.google.com/open?id=1vdyCCcBYZcIwn_rthAKSbfQ6qhgY08ma",
            "https://drive.google.com/open?id=1CurgBTCWy4g1ucXJFedXA3szH9WCHz8K",
            "https://drive.google.com/open?id=1hQOLmFpTDZ_XEoxR0BbQfduSW6_Ja-pg","https://drive.google.com/open?id=1cN1h4lRUnx7U33SdwVGrzgcPhNR-UHA5"};
    //social_science

    String[]socialscience_delhi2019paper2 = {"https://drive.google.com/open?id=1j4t7ApYCFYEXd4RXF_6NfBjgKKzO-raq"};
    String[]socialscience_delhi2019paper_title2 = {"CBSE 2019 Set Delhi 2 Social Science Question Papers With Solution"};
    String[]socialscience_delhi2019paper1 = {"https://drive.google.com/open?id=1Jd9HouQTKpxYUdh3Unka8pNx72KIwLVy"};
    String[]socialscience_delhi2019paper_title1 = {"CBSE 2019 Set Delhi 1 Social Science Question Papers With Solution"};
    String[]socialscience_delhi2019paper3 = {"https://drive.google.com/open?id=1DycfFJj6cr0tUhmnfKWjl0PI8fxpdWG7"};
    String[]socialscience_delhi2019paper_title3 = {"CBSE 2019 Set Delhi 3 Social Science Question Papers With Solution"};
    String[]socialscience_allindia2019paper2 = {"https://drive.google.com/open?id=1nfO58WzahRegnhIL--5EbeQKOVNca9p1"};
    String[]socialscience_allindia2019paper_title2 = {"CBSE 2019 Set All india 2 Social Science Question Papers With Solution"};
    String[]socialscience_allindia2019paper3 = {"https://drive.google.com/open?id=1saPhp7T8E6TCoYH1-K3vT5TL26CpMv75"};
    String[]socialscience_allindia2019paper_title3 = {"CBSE 2019 Set Aboard 3 Social Science Question Papers With Solution"};
    String[]socialscience_Aboard2019paper2 = {"https://drive.google.com/open?id=14CCdfN6YK2ANSvbuxA_Ab3WAtaaHfHJ_"};
    String[]socialscience_Aboard2019paper_title2 = {"CBSE 2019 Set Aboard 2 Social Science Question Papers With Solution"};

    String[] social_All_iurl = {"","","","","","","","","","",
            "https://drive.google.com/open?id=1Jd9HouQTKpxYUdh3Unka8pNx72KIwLVy",
            "https://drive.google.com/open?id=1j4t7ApYCFYEXd4RXF_6NfBjgKKzO-raq",
            "https://drive.google.com/open?id=1DycfFJj6cr0tUhmnfKWjl0PI8fxpdWG7","https://drive.google.com/open?id=14CCdfN6YK2ANSvbuxA_Ab3WAtaaHfHJ_",
            "https://drive.google.com/open?id=1nfO58WzahRegnhIL--5EbeQKOVNca9p1","https://drive.google.com/open?id=1saPhp7T8E6TCoYH1-K3vT5TL26CpMv75"};
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (clickNumber < 5) {
            clickNumber++;
        } else {
            clickNumber = 1;
            // show ad here
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        listView = (ListView) findViewById(R.id.listview);

        AppController.getInstance().initializeInterstialAd();

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


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        AppController application = (AppController) this.getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "FileActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "FileActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "FileActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        title = getIntent().getStringExtra("title");
        subject_position = getIntent().getIntExtra("subject_position", 0);
        content_position = getIntent().getIntExtra("content_position", 0);
        filesnamelist = getIntent().getStringArrayExtra("filesnamelist");
        fileurls = getIntent().getStringArrayExtra("fileurls");
        solution_urls = getIntent().getStringArrayExtra("solution_urls");
        if (title != null) {
            getSupportActionBar().setTitle(title);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_row, R.id.filetitle,
                filesnamelist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String file_name = adapter.getItem(position);
                Intent intent = null;

                if(subject_position==0){

                    if(content_position==2 || content_position==3) {

                        if(position >=9){

                            intent = new Intent(FileActivity.this, OpenFile.class);
                            intent.putExtra("title", file_name);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", maths_All_iurl[position]);

                        }else {

                            intent = new Intent(FileActivity.this, TabActivity.class);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", fileurls[position]);
                            intent.putExtra("contenturlsolution", solution_urls[position]);
                            intent.putExtra("title", file_name);
                        }
                    }else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }


                }
                if(subject_position==1) {
                    if (content_position == 2 || content_position == 3) {
                        if (position >= 16) {

                            intent = new Intent(FileActivity.this, OpenFile.class);
                            intent.putExtra("title", file_name);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", science_All_iurl[position]);

                        } else {

                            intent = new Intent(FileActivity.this, TabActivity.class);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", fileurls[position]);
                            intent.putExtra("contenturlsolution", solution_urls[position]);
                            intent.putExtra("title", file_name);
                        }


                    }else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }
                }
                if(subject_position==2){
                    if (content_position == 2 || content_position == 3) {
                        if (position >= 10) {

                            intent = new Intent(FileActivity.this, OpenFile.class);
                            intent.putExtra("title", file_name);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", social_All_iurl[position]);

                        } else {

                            intent = new Intent(FileActivity.this, TabActivity.class);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", fileurls[position]);
                            intent.putExtra("contenturlsolution", solution_urls[position]);
                            intent.putExtra("title", file_name);
                        }
                    }
                    else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }

                }
                if(subject_position==3){
                    if (content_position == 1 || content_position == 2) {
                        if (position >= 9) {

                            intent = new Intent(FileActivity.this, OpenFile.class);
                            intent.putExtra("title", file_name);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", englishcommut_All_iurl[position]);

                        } else {

                            intent = new Intent(FileActivity.this, TabActivity.class);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", fileurls[position]);
                            intent.putExtra("contenturlsolution", solution_urls[position]);
                            intent.putExtra("title", file_name);
                        }
                    }
                    else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }

                }
                if(subject_position==4){

                    if (content_position == 2 || content_position == 3) {
                        if (position >= 5) {

                            intent = new Intent(FileActivity.this, OpenFile.class);
                            intent.putExtra("title", file_name);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", englishlangu_All_iurl[position]);

                        } else {

                            intent = new Intent(FileActivity.this, TabActivity.class);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", fileurls[position]);
                            intent.putExtra("contenturlsolution", solution_urls[position]);
                            intent.putExtra("title", file_name);
                        }
                    }else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }


                }
                if(subject_position==5){
                    if (content_position == 2 || content_position == 3) {
                        if (position >= 5) {

                            intent = new Intent(FileActivity.this, OpenFile.class);
                            intent.putExtra("title", file_name);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", hindiA_All_iurl[position]);

                        } else {

                            intent = new Intent(FileActivity.this, TabActivity.class);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", fileurls[position]);
                            intent.putExtra("contenturlsolution", solution_urls[position]);
                            intent.putExtra("title", file_name);
                        }
                    }else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }

                }
                if(subject_position==6){
                    if (content_position == 2 || content_position == 3) {
                        if (position >= 8) {

                            intent = new Intent(FileActivity.this, OpenFile.class);
                            intent.putExtra("title", file_name);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", hindiB_All_iurl[position]);

                        } else {

                            intent = new Intent(FileActivity.this, TabActivity.class);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", fileurls[position]);
                            intent.putExtra("contenturlsolution", solution_urls[position]);
                            intent.putExtra("title", file_name);
                        }
                    }else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }


                }
                if(subject_position==7){

                    if(content_position==2 || content_position==3) {

                        intent = new Intent(FileActivity.this, TabActivity.class);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);
                        intent.putExtra("contenturlsolution", solution_urls[position]);
                        intent.putExtra("title", file_name);
                    }else{
                        intent = new Intent(FileActivity.this, OpenFile.class);
                        intent.putExtra("title", file_name);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        intent.putExtra("contenturl", fileurls[position]);

                    }


                }
                if (intent != null) {
                    startActivity(intent);
                }

            }
        });
    }
}
