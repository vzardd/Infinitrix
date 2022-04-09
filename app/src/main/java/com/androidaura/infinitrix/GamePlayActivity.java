package com.androidaura.infinitrix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GamePlayActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar pbLong,pbShort;
    ImageView ivPresentColor,dummy,ivInfo;
    public MediaPlayer buttonsound;
    MediaPlayer victory,tilebreak,incorrect,ticktick;
    CountDownTimer countDownTimer;
    CountDownTimer shortTimer;
    CountDownTimer delay;
    boolean visible;
    LinearLayout llblur,playground;
    MediaPlayer bomb;
    ConstraintLayout scorecard;
    ImageView ivClose,ivRelay,ivShare;
    TextView displayScore;
    CardView toHide,cvInfo;
    ImageView [][]b;
    int [][]arr;
    int unii=-1,unij=-1;
    TextView tvScore;
    boolean uniflag=false;
    int progress,num,currentscore=0;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDownTimer.cancel();
        shortTimer.cancel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
        dummy=findViewById(R.id.dummy);
        visible=false;
        llblur=findViewById(R.id.llblur);
        bomb=MediaPlayer.create(this,R.raw.explode);
        victory = MediaPlayer.create(this,R.raw.victory);
        buttonsound=MediaPlayer.create(this,R.raw.buttonclick);
        tilebreak=MediaPlayer.create(this,R.raw.tilebreaking);
        incorrect=MediaPlayer.create(this,R.raw.incorrect);
        ticktick=MediaPlayer.create(this,R.raw.alarm);
        tvScore = findViewById(R.id.tvScore);
        pbLong=findViewById(R.id.pbLong);
        toHide=findViewById(R.id.toHide);
        playground=findViewById(R.id.playground);
        pbShort=findViewById(R.id.pbShort);
        displayScore=findViewById(R.id.tvDisplayScore);
        ivPresentColor=findViewById(R.id.ivPresentColor);
        ivInfo=findViewById(R.id.ivInfo);
        cvInfo=findViewById(R.id.cvInfo);
        b= new ImageView[7][7];
        ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!visible)
                {
                    visible=true;
                    cvInfo.setVisibility(View.VISIBLE);
                }
                else
                {
                    visible=false;
                    cvInfo.setVisibility(View.GONE);
                }
            }
        });
        b[0][0] = findViewById(R.id.b00);
        b[0][1] = findViewById(R.id.b01);
        b[0][2] = findViewById(R.id.b02);
        b[0][3] = findViewById(R.id.b03);
        b[0][4] = findViewById(R.id.b04);
        b[0][5] = findViewById(R.id.b05);
        b[0][6] = findViewById(R.id.b06);
        b[1][0] = findViewById(R.id.b10);
        b[1][1] = findViewById(R.id.b11);
        b[1][2] = findViewById(R.id.b12);
        b[1][3] = findViewById(R.id.b13);
        b[1][4] = findViewById(R.id.b14);
        b[1][5] = findViewById(R.id.b15);
        b[1][6] = findViewById(R.id.b16);
        b[2][0] = findViewById(R.id.b20);
        b[2][1] = findViewById(R.id.b21);
        b[2][2] = findViewById(R.id.b22);
        b[2][3] = findViewById(R.id.b23);
        b[2][4] = findViewById(R.id.b24);
        b[2][5] = findViewById(R.id.b25);
        b[2][6] = findViewById(R.id.b26);
        b[3][0] = findViewById(R.id.b30);
        b[3][1] = findViewById(R.id.b31);
        b[3][2] = findViewById(R.id.b32);
        b[3][3] = findViewById(R.id.b33);
        b[3][4] = findViewById(R.id.b34);
        b[3][5] = findViewById(R.id.b35);
        b[3][6] = findViewById(R.id.b36);
        b[4][0] = findViewById(R.id.b40);
        b[4][1] = findViewById(R.id.b41);
        b[4][2] = findViewById(R.id.b42);
        b[4][3] = findViewById(R.id.b43);
        b[4][4] = findViewById(R.id.b44);
        b[4][5] = findViewById(R.id.b45);
        b[4][6] = findViewById(R.id.b46);
        b[5][0] = findViewById(R.id.b50);
        b[5][1] = findViewById(R.id.b51);
        b[5][2] = findViewById(R.id.b52);
        b[5][3] = findViewById(R.id.b53);
        b[5][4] = findViewById(R.id.b54);
        b[5][5] = findViewById(R.id.b55);
        b[5][6] = findViewById(R.id.b56);
        b[6][0] = findViewById(R.id.b60);
        b[6][1] = findViewById(R.id.b61);
        b[6][2] = findViewById(R.id.b62);
        b[6][3] = findViewById(R.id.b63);
        b[6][4] = findViewById(R.id.b64);
        b[6][5] = findViewById(R.id.b65);
        b[6][6] = findViewById(R.id.b66);
        arr = new int[7][7];
        Random choose = new Random();
        for(int i=0;i<7;++i)
        {
            for(int j=0;j<7;++j)
            {
                int n=choose.nextInt(8)+1;
                switch (n)
                {
                    case 1: b[i][j].setImageResource(R.mipmap.black); arr[i][j]=0;
                        break;
                    case 2: b[i][j].setImageResource(R.mipmap.blue);arr[i][j]=1;
                        break;
                    case 3: b[i][j].setImageResource(R.mipmap.brown);arr[i][j]=2;
                        break;
                    case 4: b[i][j].setImageResource(R.mipmap.green);arr[i][j]=3;
                        break;
                    case 5: b[i][j].setImageResource(R.mipmap.pink);arr[i][j]=4;
                        break;
                    case 6: b[i][j].setImageResource(R.mipmap.red);arr[i][j]=5;
                        break;
                    case 7: b[i][j].setImageResource(R.mipmap.violet);arr[i][j]=6;
                        break;
                    case 8: b[i][j].setImageResource(R.mipmap.yellow);arr[i][j]=7;
                        break;
                    default:b[i][j].setImageResource(R.mipmap.empty);
                }
            }
        }
        changeColor();
        b[0][0].setOnClickListener(this);
        b[0][1].setOnClickListener(this);
        b[0][2].setOnClickListener(this);
        b[0][3].setOnClickListener(this);
        b[0][4].setOnClickListener(this);
        b[0][5].setOnClickListener(this);
        b[0][6].setOnClickListener(this);
        b[1][0].setOnClickListener(this);
        b[1][1].setOnClickListener(this);
        b[1][2].setOnClickListener(this);
        b[1][3].setOnClickListener(this);
        b[1][4].setOnClickListener(this);
        b[1][5].setOnClickListener(this);
        b[1][6].setOnClickListener(this);
        b[2][0].setOnClickListener(this);
        b[2][1].setOnClickListener(this);
        b[2][2].setOnClickListener(this);
        b[2][3].setOnClickListener(this);
        b[2][4].setOnClickListener(this);
        b[2][5].setOnClickListener(this);
        b[2][6].setOnClickListener(this);
        b[3][0].setOnClickListener(this);
        b[3][1].setOnClickListener(this);
        b[3][2].setOnClickListener(this);
        b[3][3].setOnClickListener(this);
        b[3][4].setOnClickListener(this);
        b[3][5].setOnClickListener(this);
        b[3][6].setOnClickListener(this);
        b[4][0].setOnClickListener(this);
        b[4][1].setOnClickListener(this);
        b[4][2].setOnClickListener(this);
        b[4][3].setOnClickListener(this);
        b[4][4].setOnClickListener(this);
        b[4][5].setOnClickListener(this);
        b[4][6].setOnClickListener(this);
        b[5][0].setOnClickListener(this);
        b[5][1].setOnClickListener(this);
        b[5][2].setOnClickListener(this);
        b[5][3].setOnClickListener(this);
        b[5][4].setOnClickListener(this);
        b[5][5].setOnClickListener(this);
        b[5][6].setOnClickListener(this);
        b[6][0].setOnClickListener(this);
        b[6][1].setOnClickListener(this);
        b[6][2].setOnClickListener(this);
        b[6][3].setOnClickListener(this);
        b[6][4].setOnClickListener(this);
        b[6][5].setOnClickListener(this);
        b[6][6].setOnClickListener(this);
        pbLong.getProgressDrawable().setColorFilter(ContextCompat.getColor(GamePlayActivity.this,R.color.colorProgressLong), PorterDuff.Mode.SRC_IN);
        countDownTimer = new CountDownTimer(120000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                progress=(int)millisUntilFinished/1200;
                pbLong.setProgress(progress);
                if(progress<10)
                    ticktick.start();
            }

            @Override
            public void onFinish() {
                victory.start();
                gameOver();
            }
        }.start();
        shortTimer = new CountDownTimer(3000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress=(int)millisUntilFinished/30;
                pbShort.setProgress(progress);
            }

            @Override
            public void onFinish() {
                changeColor();
                shortTimer.start();
            }
        }.start();
    }
    public void changeColor(){
        int [] carr = new int[8];
        for(int i=0;i<7;++i)
        {
            for(int j=0;j<7;++j)
            {
                carr[arr[i][j]]++;
            }
        }
        num=0;
        for(int i=0;i<8;++i)
        {
            if(carr[i]>carr[num])
            {
                num=i;
            }
        }
        num++;
        switch (num)
        {
            case 1: ivPresentColor.setImageResource(R.mipmap.black);
            break;
            case 2: ivPresentColor.setImageResource(R.mipmap.blue);
            break;
            case 3: ivPresentColor.setImageResource(R.mipmap.brown);
            break;
            case 4: ivPresentColor.setImageResource(R.mipmap.green);
            break;
            case 5: ivPresentColor.setImageResource(R.mipmap.pink);
            break;
            case 6: ivPresentColor.setImageResource(R.mipmap.red);
            break;
            case 7: ivPresentColor.setImageResource(R.mipmap.violet);
            break;
            case 8: ivPresentColor.setImageResource(R.mipmap.yellow);
            break;
            default:ivPresentColor.setImageResource(R.mipmap.empty);
        }
    }

    @Override
    public void onClick(View v) {
        boolean flag=false;
        if(unii!=-1 && unij!=-1 && uniflag==true)
        {
            Random choose = new Random();
            int n=choose.nextInt(8)+1;
            arr[unii][unij]=n-1;
            if(currentscore==99 || currentscore==270 || currentscore==354)
            {
                n=9;
            }
            switch (n)
            {
                case 1: b[unii][unij].setImageResource(R.mipmap.black);
                    break;
                case 2: b[unii][unij].setImageResource(R.mipmap.blue);
                    break;
                case 3: b[unii][unij].setImageResource(R.mipmap.brown);
                    break;
                case 4: b[unii][unij].setImageResource(R.mipmap.green);
                    break;
                case 5: b[unii][unij].setImageResource(R.mipmap.pink);
                    break;
                case 6: b[unii][unij].setImageResource(R.mipmap.red);
                    break;
                case 7: b[unii][unij].setImageResource(R.mipmap.violet);
                    break;
                case 8: b[unii][unij].setImageResource(R.mipmap.yellow);
                    break;
                default:b[unii][unij].setImageResource(R.mipmap.bomb);
            }
        }
        for(int i=0;i<7;++i)
        {
            for(int j=0;j<7;++j)
            {
                if(b[i][j].getId()==v.getId())
                {
                    if(b[i][j].getDrawable().getConstantState()==ivPresentColor.getDrawable().getConstantState())
                    {
                        //tilebreak.stop();
                        //tilebreak=MediaPlayer.create(this,R.raw.tilebreaking);
                        tilebreak.start();
                        currentscore+=1;
                        tvScore.setText("Score : "+Integer.toString(currentscore));
                        switch (num)
                        {
                            case 1: b[i][j].setImageResource(R.mipmap.brokenblack);
                                break;
                            case 2: b[i][j].setImageResource(R.mipmap.brokenblue);
                                break;
                            case 3: b[i][j].setImageResource(R.mipmap.brokenbrown);
                                break;
                            case 4: b[i][j].setImageResource(R.mipmap.brokengreen);
                                break;
                            case 5: b[i][j].setImageResource(R.mipmap.brokenpink);
                                break;
                            case 6: b[i][j].setImageResource(R.mipmap.brokenred);
                                break;
                            case 7: b[i][j].setImageResource(R.mipmap.brokenviolet);
                                break;
                            case 8: b[i][j].setImageResource(R.mipmap.brokenyellow);
                                break;
                            default:b[i][j].setImageResource(R.mipmap.empty);
                        }
                        //delay here
                        unii=i;
                        unij=j;
                        uniflag=true;
                    }
                    else if(b[i][j].getDrawable().getConstantState().equals(dummy.getDrawable().getConstantState()))
                    {
                        b[i][j].setImageResource(R.mipmap.burst);
                        bomb.start();
                        gameOver();
                    }
                    else
                    {
                        incorrect.start();
                        uniflag=false;
                        currentscore-=1;
                        tvScore.setText("Score : "+Integer.toString(currentscore));
                    }
                    flag=true;
                    break;
                }
            }
            if(flag==true) {
                break;
            }
        }
    }
    public void gameOver()
    {
        countDownTimer.cancel();
        shortTimer.cancel();
        scorecard=findViewById(R.id.scoreCard);
        ivClose=findViewById(R.id.ivClose);
        ivRelay=findViewById(R.id.ivReplay);
        ivShare=findViewById(R.id.ivShare);
        scorecard.setVisibility(View.VISIBLE);
        pbShort.setVisibility(View.INVISIBLE);
        llblur.setVisibility(View.VISIBLE);
        toHide.setVisibility(View.INVISIBLE);
        displayScore.setText(Integer.toString(currentscore));
        playground.setVisibility(View.INVISIBLE);
        SharedPreferences pref = getSharedPreferences(MainActivity.FILENAME,MODE_PRIVATE);
        int highscore=pref.getInt("highscore",0);
        if(currentscore>highscore) {
            SharedPreferences.Editor editor = getSharedPreferences(MainActivity.FILENAME, MODE_PRIVATE).edit();
            editor.putInt("highscore",currentscore);
            editor.commit();
        }
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();onBackPressed();
            }
        });
        ivRelay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsound.start();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"Hey! Can you beat my High Score in this mind game? Try out this brain storming game. \nhttps://play.google.com/store/apps/details?id=com.androidaura.infinitrix");
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}