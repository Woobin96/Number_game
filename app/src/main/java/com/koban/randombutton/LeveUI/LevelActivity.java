package com.koban.randombutton.LeveUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.koban.randombutton.Game_UI.Level_02;
import com.koban.randombutton.Game_UI.Level_03;
import com.koban.randombutton.Game_UI.Level_01;
import com.koban.randombutton.Game_UI.Level_04;
import com.koban.randombutton.Game_UI.Level_05;
import com.koban.randombutton.R;

import java.util.HashMap;

public class LevelActivity extends AppCompatActivity {

    private Button mLevel_01;
    private Button mLevel_02;
    private Button mLevel_03;
    private Button mLevel_04;
    private Button mLevel_05;
    private ImageView imageView ;

    private String mLevel01 ;
    private String KEY_LEVEL_01 = "level_01";
    private Animation animation ;

    public static HashMap<String, Bundle> mHashMap = new HashMap<String, Bundle>();

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private AdView mAdview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        // 광고
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });

        mAdview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        // 여기까지 광고고

        imageView = findViewById(R.id.image);
        animation = AnimationUtils.loadAnimation(LevelActivity.this, R.anim.treeanim);

        // 이미지 애니메이션
//        animation.setRepeatCount(Animation.INFINITE);
//        imageView.startAnimation(animation);

        mLevel_01 = findViewById(R.id.level_btn01);
        mLevel_02 = findViewById(R.id.level_btn02);
        mLevel_03 = findViewById(R.id.level_btn03);
        mLevel_04 = findViewById(R.id.level_btn04);
        mLevel_05 = findViewById(R.id.level_btn05);

//        mLevel_02.setEnabled(false);
//        mLevel_03.setEnabled(false);
//        mLevel_04.setEnabled(false);
//        mLevel_05.setEnabled(false);

        setLevelBtn();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        mHashMap.put(KEY_LEVEL_01, bundle);

        if (bundle != null) {
            mLevel_02.setEnabled(true);
        }

//        mLevel01 = intent.getStringExtra(KEY_LEVEL_01);
//        mHashMap.get(mLevel01);

//        if (mHashMap != null) {
//            mLevel_02.setEnabled(true);
//        }
//        Log.e("a1", "mHashMap : " + mHashMap);
//
//
//        if (mLevel01 != null) {
//            mLevel_02.setEnabled(true);
//            preferences = getSharedPreferences(KEY_LEVEL_01, MODE_PRIVATE);
//            editor = preferences.edit();
//            editor.putString(KEY_LEVEL_01, mLevel01);
//            editor.commit();
//
//            mLevel01 = editor.toString();
//        }

        Log.e("a1", "level : " + mLevel01);
        Log.e("a1", "bundle : " + bundle);


    }

    // 버튼 이벤트 모아두기
    public void setLevelBtn () {
        mLevel_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, Level_01.class);
                startActivity(level_01);
            }
        });

        mLevel_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, Level_02.class);
                startActivity(level_01);
            }
        });

        mLevel_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, Level_03.class);
                startActivity(level_01);
            }
        });

        mLevel_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, Level_04.class);
                startActivity(level_01);
            }
        });

        mLevel_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, Level_05.class);
                startActivity(level_01);
            }
        });
    }
}