package com.example.testprofiler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mCount;
    private TextView mWelcome;
    private int counter;
    private Timer mTimer;
    private String[] mHellos = {"Hello !", "Bonjour !", "Hola !", "Hi", "Konnichiwa !", "Hej !"};
    public Random mRandom = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = 0;
        setContentView(R.layout.activity_main);

        mWelcome = (TextView) findViewById(R.id.activity_main_welcome);
        mButton = (Button) findViewById(R.id.activity_main_button);
        mCount = (TextView) findViewById(R.id.activity_main_counter);
        mCount.setText(String.valueOf(counter));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                mCount.setText(String.valueOf(counter));
            }
        });

        final Handler handler = new Handler();
        final Runnable sayHi = new Runnable() {
            @Override
            public void run() {
                String welcome = mHellos[mRandom.nextInt(mHellos.length)];
                mWelcome.setText(welcome);
                handler.postDelayed(this, 17);
            }
        };
        handler.postDelayed(sayHi, 17);


    }
}
