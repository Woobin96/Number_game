package com.koban.randombutton.LeveUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.koban.randombutton.Game_UI.HardRandomApp;
import com.koban.randombutton.Game_UI.RandomApp;
import com.koban.randombutton.R;

public class LevelActivity extends AppCompatActivity {

    private Button mLevel_01;
    private Button mLevel_02;
    private Button mLevel_03;
    private Button mLevel_04;
    private Button mLevel_05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        mLevel_01 = findViewById(R.id.level_btn01);
        mLevel_02 = findViewById(R.id.level_btn02);
        mLevel_03 = findViewById(R.id.level_btn03);
        mLevel_04 = findViewById(R.id.level_btn04);
        mLevel_05 = findViewById(R.id.level_btn05);


        setLevelBtn();

    }

    public void setLevelBtn () {
        mLevel_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, RandomApp.class);
                startActivity(level_01);
            }
        });

        mLevel_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, RandomApp.class);
                startActivity(level_01);
            }
        });

        mLevel_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, RandomApp.class);
                startActivity(level_01);
            }
        });


        mLevel_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent level_01 = new Intent(LevelActivity.this, HardRandomApp.class);
                startActivity(level_01);
            }
        });
    }
}