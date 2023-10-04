package com.omeducation.cbscclass10board;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class FolderActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;
    String title;
    String[] filesnamelist;
    private int subject_position;
    private int content_position;


    private String[] maths_rdsharma_10_1kq = {"EX:-1.1","EX:-1.2","EX:-1.3","EX:-1.4","EX:-1.5","EX:-1.6"};
    private String[] maths_rdsharma_10_2kq= {"EX:-2.1","EX:-2.2","EX:-2.3"};
    private String[] maths_rdsharma_10_3kq= {"ALL EX:-3"};
    private String[] maths_rdsharma_10_4kq= {"EX:-4.1","EX:-4.2","EX:-4.3","EX:-4.4","EX:-4.5","EX:-4.6","EX:-4.7"};
    private String[] maths_rdsharma_10_5kq= {"EX:-5.1","EX:-5.2","EX:-5.3"};
    private String[] maths_rdsharma_10_6kq= {"EX:-6.1","EX:-6.2"};
    private String[] maths_rdsharma_10_7kq= {"EX:-7.1","EX:-7.2","EX:-7.3","EX:-7.4","EX:-7.5","EX:-7.6","EX:-7.7"};
    private String[] maths_rdsharma_10_8kq= {"All EX:-8"};
    private String[] maths_rdsharma_10_9kq= {"EX:-9.1","EX:-9.2","EX:-9.3","EX:-9.4","EX:-9.5","EX:-9.6"};
    private String[] maths_rdsharma_10_10kq= {"EX:-10.1","EX:-10.2"};
    private String[] maths_rdsharma_10_11kq= {"EX:-11.1","EX:-11.2","EX:-11.3"};
    private String[] maths_rdsharma_10_12kq= {"EX:-12.1"};
    private String[] maths_rdsharma_10_13kq= {"EX:-13.1","EX:-13.2"};
    private String[] maths_rdsharma_10_14kq= {"EX:-14.1","EX:-14.2","EX:-14.3","EX:-14.4","EX:-14.5"};
    private String[] maths_rdsharma_10_15kq= {"EX:-15.1","EX:-15.2","EX:-15.3","EX:-15.4"};
    private String[] maths_rdsharma_10_16kq= {"EX:-16.1","EX:-16.2","EX:-16.3"};

    private String[][] maths_10standars = {maths_rdsharma_10_1kq,maths_rdsharma_10_2kq,maths_rdsharma_10_3kq,maths_rdsharma_10_4kq,maths_rdsharma_10_5kq,maths_rdsharma_10_6kq,maths_rdsharma_10_7kq,maths_rdsharma_10_8kq,maths_rdsharma_10_9kq,maths_rdsharma_10_10kq,maths_rdsharma_10_11kq,maths_rdsharma_10_12kq,maths_rdsharma_10_13kq,maths_rdsharma_10_14kq,maths_rdsharma_10_15kq,maths_rdsharma_10_16kq};


    private String[] maths_rdsharma_10_1k = {"https://drive.google.com/open?id=1IP3YIS6JQ06r6y56hYLt5dwCGgmuT3pf","https://drive.google.com/open?id=1_jdiM874Q0a-glhur6vGZZ8KKUoTABw3","https://drive.google.com/open?id=1wpcfJoYILtNuiK6N8-8WNpVz4gIG4Svw","https://drive.google.com/open?id=19-5zEpitw_CAuVDjCs_YNeuxicJdz39j","https://drive.google.com/open?id=16Xz1iXdIoza9Z-J3fz1gSuNfGb7NYUeK","https://drive.google.com/open?id=1MtgJsxgAfNQnvEaEj39azFjdRe70VPp3"};
    private String[] maths_rdsharma_10_2k = {"https://drive.google.com/open?id=1hD9oeSE8HOWHiQdMTyUaprNFUtBU9raI","https://drive.google.com/open?id=14fXSMZukp_paOyRKH_2ckpWqXGcnuhIM","https://drive.google.com/open?id=1iqnqg8L7K-EUVo-lzVJwA9G4hF_-cJXA"};
    private String[] maths_rdsharma_10_3k= {"https://drive.google.com/open?id=1Yylx0G-KWzuUGP2Bz7tutNNTkChVRo4U"};
    private String[] maths_rdsharma_10_4k = {"https://drive.google.com/open?id=1xbaknwFMUkxEjYW80VHgLS_1_7Z8O9fX","https://drive.google.com/open?id=1htnL9I85bt04mYBxDynIO_GmLthy1oIL","https://drive.google.com/open?id=1szQ109N-uxSKB001YMUM-g2JxIWW-EZi","https://drive.google.com/open?id=1ZGFsf14lI-iLIOAlGX4gS7Z_RGm7myXE","https://drive.google.com/open?id=1ocHRb0PGh6JXFRr7nuEdfNLFPXN14yoU","https://drive.google.com/open?id=1qR-KXGCZfB9vW3SsfD_CQXjEXEHQmJBu","https://drive.google.com/open?id=1PTs6ogSupFbOw823X_WmzTJYirHy7amX","https://drive.google.com/open?id=1bm7GmmvR8vaTWk1SzSG08aEicg7RS7Ln"};
    private String[] maths_rdsharma_10_5k = {"https://drive.google.com/open?id=1kI9GLn863zCfOQbTaBMNMKgw-ZJwcU8k","https://drive.google.com/open?id=1-hB21SQI7qXB6Vtv2No880O0-XTB61vP","https://drive.google.com/open?id=13IqXXiLbC8ckUDHIRPwYl9e5bsHx4x_s"};
    private String[] maths_rdsharma_10_6k = {"https://drive.google.com/open?id=1Uc9hQw3B9W10DxfKxLpF4Am5_pAZkv47","https://drive.google.com/open?id=1drWd075k_DFCINnSFGZ0A5cQmUHV3azk"};
    private String[] maths_rdsharma_10_7k = {"https://drive.google.com/open?id=12zOTij7-_DHBUWul6mVflzJdqxvXGA2w","https://drive.google.com/open?id=12OglDdo9w1o5QnBG8gbRwhUCkiLsahNh","https://drive.google.com/open?id=1O2J-IBvKZVn7eUHiCKt7aesdPLTTOdAb","https://drive.google.com/open?id=1znHgXjwJ6871baNRyVoatVyRta-u-c1o","https://drive.google.com/open?id=1qS_YSsTdEYcC9H3sb7J9Gd4nKlb90KOk","https://drive.google.com/open?id=1k25p2-Z5yCN2U_gtuJEIkk8Nt10fesKv"};
    private String[] maths_rdsharma_10_8k = {"https://drive.google.com/open?id=1cJy292pKnRK1VNOnfB4Z7qPEMBbSm9LS"};
    private String[] maths_rdsharma_10_9k = {"https://drive.google.com/open?id=1fVHHdTm_L1Ms35maNKAQUZbuNtPGntQd","https://drive.google.com/open?id=1bStQVmwafAN2dcaYVpDRwmlDC-IaKJV2","https://drive.google.com/open?id=1q2Rna8utSZRnPJwWZMWcDGKtv6swZBsY","https://drive.google.com/open?id=1emCHoVV1hPWtAjC7E7G8eAerdbe58EVL","https://drive.google.com/open?id=15EOcaSoX-l3PUUVgxJQBUDVhXylJqol0","https://drive.google.com/open?id=1Z5vPBnJzvRgKAcbyLD_4MpGup3LnytRy"};
    private String[] maths_rdsharma_10_10k = {"https://drive.google.com/open?id=1Gh626bJW33egSH1xjq17_oiYYtQCTKwd","https://drive.google.com/open?id=1MSssb_8PACisAnyXU4yzNT7vXAVF_EUv"};
    private String[] maths_rdsharma_10_11k = {"https://drive.google.com/open?id=1c3bmUQrJikxtwN8I6hjO2u495A1hNhwa","https://drive.google.com/open?id=1rIqX-OtkWFj1yEtS68xv0cyfQ4vgw-H1","https://drive.google.com/open?id=12fJ00skQ4V0_IjMaaA7u60tMyWXLU1UO"};
    private String[] maths_rdsharma_10_12k = {"https://drive.google.com/open?id=1YdtNF0Q7zCHMtw0zPH7_Wg0pDNYisNX6"};
    private String[] maths_rdsharma_10_13k = {"https://drive.google.com/open?id=1VI4Icp3LSthrtsZD8rAfdYjNBOX_DOhx","https://drive.google.com/open?id=1QjdWc9fQwUJ3n3J4OhfpFkpNwjbPoRZT"};
    private String[] maths_rdsharma_10_14k = {"https://drive.google.com/open?id=1LCxN8-OKvvDlG8TBMEdlHDo2Zi5kCAuC","https://drive.google.com/open?id=1OugWWuPQBaJJwe6qOuM_Kok46Z71Owwu","https://drive.google.com/open?id=1eRrCQML2KrzCP2iur_axS1CMHkYxem_t","https://drive.google.com/open?id=1NATJW0ty6Avn11ogxfS6UfmZKlJQQ0Z_","https://drive.google.com/open?id=1OKG72OSdFU3t0tRvWC_n-lJvRw3DTiuL"};
    private String[] maths_rdsharma_10_15k = {"https://drive.google.com/open?id=1uPpxEBtaiQ5vPa4n1g5mk4Oqz-5xFNql","https://drive.google.com/open?id=18hnsKx4S-doGiVP2WxCpm3qPBY1Clo9P","https://drive.google.com/open?id=1Oc20R-RmqmLpgWtKIFDcHrCcwEC16Qmw","https://drive.google.com/open?id=13UPZ5OukVMlRCnjT2GS7E82d8PRkUlXW"};
    private String[] maths_rdsharma_10_16k = {"https://drive.google.com/open?id=1nMtoTrytEwbRbPN7MsEQsDMM6WdRfzSq","https://drive.google.com/open?id=17eFJhoeeJ0QcZC9gvMJut_YI7v0j2RsG","https://drive.google.com/open?id=1Vi6nKuoYEU3IB3661XpMja-5M6LfRr8l"};



    private String[][] maths_10standarsurl = {maths_rdsharma_10_1k,maths_rdsharma_10_2k,maths_rdsharma_10_3k,maths_rdsharma_10_4k,maths_rdsharma_10_5k,maths_rdsharma_10_6k,maths_rdsharma_10_7k,maths_rdsharma_10_8k,maths_rdsharma_10_9k,maths_rdsharma_10_10k,maths_rdsharma_10_11k,maths_rdsharma_10_12k,maths_rdsharma_10_13k,maths_rdsharma_10_14k,maths_rdsharma_10_15k,maths_rdsharma_10_16k};



    String[] sanskrit_title = {"मनिका(X)"};
    String[] sanskrit_path = {"प्रथमः पाठः – शुचिपर्यावरणम",
            "द्वितीयः पाठः – गुणवती कन्या",
            "तृतीयः पाठः – शिशुलालनम",
            "चतुर्थः पाठः – व्यायामः सर्वदा पथ्यः",
            "पञ्चमः पाठः – बुद्धिर्बलवती सदा",
            "षष्ठः पाठः – सुभाषितानि",
            "सप्तमः पाठः – भूकम्पविभीषिका",
            "अष्टमः पाठः – प्रश्नत्रयम",
            "नवमः पाठः – प्राणेभ्योपि प्रियः सुहृद",
            "दशमः पाठः – अन्योक्तयः",
            "एकादशः पाठः – विचित्रः साक्षी",
            "द्वादशः पाठः – जीवनं विभवं विना"};
    String[] sanskrit_textbook_manika = {"https://drive.google.com/open?id=1m5Zd1gOKduKshOX44mDRvhhJB2yqNGxG"};
    String[] sanskrit_textbook_saminucha = {"https://drive.google.com/open?id=1DBAe1EPpy7IOpif6leFBy6QfhkKcSCm7","https://drive.google.com/open?id=1g3Gl0jWmiauJVYXyg1v5reWzTmiiYdhg","https://drive.google.com/open?id=1bKsNfKqZ94hMWzLSroD921CZRttdXIsj","https://drive.google.com/open?id=1kRLfgt6erVT828GIPVkAPmUukZy9Awid","https://drive.google.com/open?id=13xwcZamJbFxcqnDN8xqCqxGWLGGZi48V","https://drive.google.com/open?id=1v4HZXGCdSmeP6NUIgmtSV08Z6J8Mi3HX","https://drive.google.com/open?id=1E7GUN4-MzETAm7uAlUuh5Cc-ICR0AV5x","https://drive.google.com/open?id=1Z3Fb8ZbjAFbb5KWGc8iNpDNVrcN4kOzY","https://drive.google.com/open?id=1dbkcEUxh9RBB7lj4PW06iJQmTaeC-MGD","https://drive.google.com/open?id=1c-ms8rJ0NIcITfzs6gViVvP9o_Pai9Mg","https://drive.google.com/open?id=1fx2Oeh6hu9GCWhxXkeszw1-8kbiySJLX","https://drive.google.com/open?id=1tFf-oRz9IPADSF3GignEvwYUwpwFnKyK"};

    String[][] sanskrit_textbook_manika1_question = {sanskrit_title,sanskrit_path};
    String[][] sanskrit_textbook_manika1 = {sanskrit_textbook_manika,sanskrit_textbook_saminucha};



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
        setContentView(R.layout.activity_folder);

        listView = (ListView) findViewById(R.id.listview);

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
        mTracker.setScreenName("screen name:" + "FolderActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "FolderActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "FolderActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        title = getIntent().getStringExtra("title");
        subject_position = getIntent().getIntExtra("subject_position", 0);
        content_position = getIntent().getIntExtra("content_position", 0);
        filesnamelist = getIntent().getStringArrayExtra("filesnamelist");
        if (title != null) {
            getSupportActionBar().setTitle(title);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_folder, R.id.filetitle,
                filesnamelist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //Maths
                if (subject_position == 7) {


                    if (content_position == 1) {
                        Intent intent = new Intent(FolderActivity.this, FileActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", content_position);
                        intent.putExtra("filesnamelist", sanskrit_textbook_manika1_question[position]);
                        intent.putExtra("fileurls", sanskrit_textbook_manika1[position]);
                        startActivity(intent);
                    }


                }


                //Chemistry
                if (subject_position == 0) {


                    if (content_position == 9) {
                        Intent intent = new Intent(FolderActivity.this, FileActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", content_position);
                        intent.putExtra("filesnamelist", maths_10standars[position]);
                        intent.putExtra("fileurls", maths_10standarsurl[position]);
                        startActivity(intent);
                    }

                    if (content_position == 10) {
                        Intent intent = new Intent(FolderActivity.this, VideoListActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        startActivity(intent);
                    }

                }


                //Physics
                if (subject_position == 1) {
                    if (content_position == 8) {
                        Intent intent = new Intent(FolderActivity.this, VideoListActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        startActivity(intent);
                    }


                }
                if (subject_position == 2) {
                    if (content_position == 6) {
                        Intent intent = new Intent(FolderActivity.this, VideoListActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        startActivity(intent);
                    }


                }

                if (subject_position == 3) {
                    if (content_position == 4) {
                        Intent intent = new Intent(FolderActivity.this, VideoListActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        startActivity(intent);
                    }


                }
                if (subject_position == 4) {
                    if (content_position == 5) {
                        Intent intent = new Intent(FolderActivity.this, VideoListActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        startActivity(intent);
                    }


                }

                if (subject_position == 5) {
                    if (content_position == 5) {
                        Intent intent = new Intent(FolderActivity.this, VideoListActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        startActivity(intent);
                    }
                }

                if (subject_position == 6) {
                    if (content_position == 5) {
                        Intent intent = new Intent(FolderActivity.this, VideoListActivity.class);
                        intent.putExtra("title", filesnamelist[position]);
                        intent.putExtra("subject_position", subject_position);
                        intent.putExtra("content_position", position);
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
