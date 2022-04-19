package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button butterfliesButton, movementTest;
    private int startingPosition, targetPosition, finalPosition;
    private ImageView locationPointer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startingPosition = 0;

        butterfliesButton = findViewById(R.id.butterfliesButton);
        butterfliesButton.setBackgroundColor(Color.TRANSPARENT);
        butterfliesButton.setTextColor(Color.TRANSPARENT);
        butterfliesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                targetPosition = 6;
            }
        });

        locationPointer = findViewById(R.id.locationPointer);
        movementTest = findViewById(R.id.movementTest);
        movementTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                if (startingPosition == 0) {
                    switch (targetPosition) {
                        case 6:
                            MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.gostraight5metres);
                            music.start();
                            targetPosition = -1;
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(t,1000,1000);


    }
}