package com.androidaura.infinitrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView btnAboutus,btnHighscore,btnPlay;
    public static final String FILENAME="com.androidaura.infinitrix.data";
    public MediaPlayer buttonsound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        btnAboutus = findViewById(R.id.btnAbout);
        btnHighscore = findViewById(R.id.btnHighscore);
        buttonsound=MediaPlayer.create(this,R.raw.buttonclick);
        btnPlay = findViewById(R.id.btnPlay);
        btnAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();
                Intent intent = new Intent(MainActivity.this,com.androidaura.infinitrix.AboutUsActivity.class);
                startActivity(intent);
            }
        });
        btnHighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();
                Intent intent = new Intent(MainActivity.this,com.androidaura.infinitrix.HighScoreActivity.class);
                startActivity(intent);
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();
                Intent intent = new Intent(MainActivity.this,com.androidaura.infinitrix.GamePlayActivity.class);
                startActivity(intent);
            }
        });
    }
}