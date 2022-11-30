package com.koban.randombutton.Game_UI;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koban.randombutton.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Level_04 extends AppCompatActivity {

    private Button btnRetry;
    private Button[] m_EzBtns = new Button[30];
    private TextView m_NumberGuide;
    private TextView tv_Clear;
    private TextView tv_Timer;
    private LinearLayout linearLayout = null;

    private TimerTask mTimerTask = null;
    private Timer mTimer = new Timer();

    private int m_Timer_min = 0;
    private int m_Timer_sec = -1;

    private Animation animation ;

    // 눌러야 할 번호
    private int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level04);
        btnRetry = findViewById(R.id.reset_btn);
        m_NumberGuide = findViewById(R.id.tv_num);
        tv_Clear = findViewById(R.id.clear);
        linearLayout = findViewById(R.id.touch_lin);
        tv_Timer = findViewById(R.id.ez_timer);

        // 애니메이션
        animation = AnimationUtils.loadAnimation(Level_04.this, R.anim.levle04);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i < 31; i ++){
            arrayList.add(i);
        }

        // 배열위치 섞기
        Collections.shuffle(arrayList);


        for(int i = 0; i < m_EzBtns.length; i++){
            int p = 0;
            m_EzBtns[i] = findViewById(R.id.ez_btn_01 + i);
//            Log.e("qqqq", m_EzBtns[i] + "");
//            Log.e("aaaa", arrayList.get(i) + "");

            m_EzBtns[i].setText(arrayList.get(i) + "");
            m_EzBtns[i].setTag(arrayList.get(i) + "");

            // 애니메이션 무한 루프
            animation.setRepeatCount(Animation.INFINITE);
            m_EzBtns[i].startAnimation(animation);
        }



        // pass 버튼
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayout.setVisibility(View.VISIBLE);
                tv_Clear.setVisibility(View.GONE);

                tv_Timer.setText("00 : 00");

                ArrayList<Integer> arrayList1= new ArrayList<>();
                for(int i = 1; i < 31; i ++){
                    arrayList1.add(i);
                }
                Collections.shuffle(arrayList1);

                for(int i = 0; i < m_EzBtns.length; i ++){
                    m_EzBtns[i].setText(arrayList1.get(i) + "");
                    m_EzBtns[i].setTag(arrayList1.get(i));

                    m_EzBtns[i].setBackgroundResource(R.drawable.btnevent);
                    m_EzBtns[i].setTextColor(Color.parseColor("#000000"));
                }

                num = 1;
                m_NumberGuide.setText(num + "");

                btnRetry.setEnabled(false);
            }
        });

    } // on Create

    // 30개의 버튼들
    public void clickBtn (View v) {

        Button click_Btn = (Button) v;
        String str_num = click_Btn.getTag().toString();
        int btn_num = Integer.parseInt(str_num);

        if(btn_num == num){
            // 버튼 / 텍스트 스타일 변경
            click_Btn.setText("OK");
            click_Btn.setBackground(null);
            click_Btn.setBackgroundResource(R.drawable.clickbtn_ez);
            click_Btn.setTextColor(Color.parseColor("#FFFFFF"));
//            click_Btn.startAnimation(animation);

            num ++;
            m_NumberGuide.setText(num + "");
            Log.i("[Number] ...", num - 1 + "");

            try {
                if (btn_num == 1) {
                    startTimer();
                }
            }catch (Exception e) {

            }
        }

        //게임종료
        if(num > 30){
            //리트라이 버튼을  활성화 .
//            m_NumberGuide.setText("Clear");
            linearLayout.setVisibility(View.GONE);
            tv_Clear.setVisibility(View.VISIBLE);

            btnRetry.setEnabled(true);

            m_Timer_sec = -1;
            m_Timer_min = 0;

//            mTimer.cancel();
            mTimerTask.cancel();
        }
    }

    public void startTimer() {
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                m_Timer_sec ++ ;

                if (m_Timer_sec > 59) {
                    m_Timer_min ++;
                    m_Timer_sec = 0;
                }

                final String minute = String.format(Locale.getDefault(),"%02d", m_Timer_min);
                final String second = String.format(Locale.getDefault(),"%02d", m_Timer_sec);

                tv_Timer.post(new Runnable() {
                    @Override
                    public void run() {
                        tv_Timer.setText(minute + " : " + second);
                        if (m_Timer_min >= 1) {
                            tv_Timer.setTextColor(Color.parseColor("#FF3636"));
                        }
                    }
                });

            }
        };
        mTimer.schedule(mTimerTask, 0, 1000);
    }
}