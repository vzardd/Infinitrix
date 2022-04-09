package com.androidaura.infinitrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    TextView btnRate,btnShare;
    public MediaPlayer buttonsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        buttonsound=MediaPlayer.create(this,R.raw.buttonclick);
        btnRate = findViewById(R.id.btnRate);
        btnShare = findViewById(R.id.btnShare);
        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.cs.infinitrixtwo"));
                startActivity(intent);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hey! Can you beat my high score in this superfun mind game? Try out the challenge.\nhttps://play.google.com/store/apps/details?id=com.cs.infinitrixtwo");
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }
}