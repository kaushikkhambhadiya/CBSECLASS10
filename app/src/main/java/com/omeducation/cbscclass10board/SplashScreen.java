package com.omeducation.cbscclass10board;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    Thread splashTread;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);

//        StartAnimation();
    }

//    private void StartAnimation() {
//
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
//        anim.reset();
//        RelativeLayout l = (RelativeLayout) findViewById(R.id.relative);
//        l.clearAnimation();
//        l.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.scale);
//        anim.reset();
//
//
//        final ImageView wellcome = (ImageView) findViewById(R.id.wellcome);
//        wellcome.clearAnimation();
//        wellcome.startAnimation(anim);
//
//        final ImageView logo = (ImageView) findViewById(R.id.splashlogo);
//        logo.clearAnimation();
//        logo.startAnimation(anim);
//
//
//        splashTread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    int waited = 0;
//                    // Splash screen pause time
//                    while (waited < 3500) {
//                        sleep(100);
//                        waited += 100;
//                    }
//                    Intent intent = new Intent(SplashScreen.this,
//                            HomeActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                    startActivity(intent);
//                    SplashScreen.this.finish();
//                } catch (InterruptedException e) {
//                    // do nothing
//                } finally {
//                    SplashScreen.this.finish();
//                }
//
//            }
//        };
//        splashTread.start();

//    }

}


