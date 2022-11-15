package com.koban.randombutton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.koban.randombutton.LeveUI.LevelActivity;

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

        // 게임 시작 버튼
        mGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });

        // 게임 방법 버튼
        mHellpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder gameGuide = new AlertDialog.Builder(MainActivity.this);
                gameGuide.setTitle("게임 방법");
                gameGuide.setMessage("1. 숫자 1 부터 순서대로 맞추기 \n 2. PASS 버튼 누르면 재시작");

                gameGuide.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                gameGuide.show();
            }
        });

    }
}