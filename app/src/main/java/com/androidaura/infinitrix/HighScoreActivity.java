package com.androidaura.infinitrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {
    TextView tvHighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        tvHighscore=findViewById(R.id.tvHighscore);
        SharedPreferences pref = getSharedPreferences(MainActivity.FILENAME,MODE_PRIVATE);
        int s=pref.getInt("highscore",0);
        tvHighscore.setText(Integer.toString(s));
    }
}