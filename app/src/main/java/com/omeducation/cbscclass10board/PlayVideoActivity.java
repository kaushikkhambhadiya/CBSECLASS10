package com.omeducation.cbscclass10board;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.jetbrains.annotations.NotNull;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;


public class PlayVideoActivity extends AppCompatActivity {
    //implements YouTubePlayer.OnInitializedListener
    TextView tvtitle;
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    String youtube_apikey = "AIzaSyDnoJgor8Z7JLFDUSU8YwPC8f__JTeUX7Q";
    String videoobjects;
    String videotitle;
    Toolbar toolbar;
    private YouTubePlayerView youTubePlayerView;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        AppController application = (AppController) this.getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "PlayVideoActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "PlayVideoActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "PlayVideoActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        videoobjects = getIntent().getStringExtra("videoobjects");
        videotitle = getIntent().getStringExtra("videotitle");

        tvtitle = (TextView) findViewById(R.id.tvtitlevideo);


        if (videotitle != null) {
            tvtitle.setText(videotitle);
            getSupportActionBar().setTitle(videotitle);
        }


        youTubePlayerView = findViewById(R.id.main_youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

        IFramePlayerOptions iFramePlayerOptions = new IFramePlayerOptions.Builder()
                .controls(1)
                // enable full screen button
                .fullscreen(1)
                .build();

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NotNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                try {
                    String videoId = videoobjects;
                    youTubePlayer.loadVideo(videoId, 0);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

//        YouTubePlayerSupportFragmentX frag =
//                (YouTubePlayerSupportFragmentX) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
//        frag.initialize(youtube_apikey, this);

    }


//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider,
//                                        YouTubeInitializationResult errorReason) {
//        if (errorReason.isUserRecoverableError()) {
//            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
//        } else {
//            String errorMessage = String.format(
//                    getString(R.string.error_player));
//            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider,
//                                        YouTubePlayer player, boolean wasRestored) {
//        if (!wasRestored) {
//
//            // loadVideo() will auto play video
//            // Use cueVideo() method, if you don't want to play it automatically
//            player.loadVideo(videoobjects);
//
//            // Hiding player controls
//            player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }


}
