package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDowload;
    ProgressBar pbXuLy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDowload = (Button) findViewById(R.id.buttonDowload);
        pbXuLy = (ProgressBar) findViewById(R.id.progressBarXuLy);
        btnDowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //60000 = 60 giây -> tổng time đếm ngc
                //1000 : 1 giây -> thời gian lặp lại 1 hành động
                CountDownTimer countDownTimer = new CountDownTimer(60000,1000) {
                    //mỗi 1 giây làm hành động trong onTick
                    @Override
                    public void onTick(long l) {
                        int current = pbXuLy.getProgress();
                        if(current>=pbXuLy.getMax())
                        {
                            current=0;
                        }
                        pbXuLy.setProgress(current+1);
                    }

                    @Override
                    public void onFinish() {
                        //this.start();
                        //Toast.makeText(Bai_ProgressBar.this,"Hết giờ",Toast.LENGTH_SHORT).show();

                    }
                };
                countDownTimer.start();

            }
        });
    }
}