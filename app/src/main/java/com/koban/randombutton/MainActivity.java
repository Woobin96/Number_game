package com.koban.randombutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mGameBtn ;
    private Button mHellpBtn ;


    SharedPreferences sharedPreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGameBtn = findViewById(R.id.game_start);
        mHellpBtn = findViewById(R.id.game_hellp);

//        mHardMode.setEnabled(false);

        mGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RandomApp.class);
                startActivity(intent);
            }
        });

        mHellpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, HardRandomApp.class);
                startActivity(intent);
            }
        });

    }
}