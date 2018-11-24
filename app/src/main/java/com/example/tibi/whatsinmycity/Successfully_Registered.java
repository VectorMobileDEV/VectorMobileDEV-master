package com.example.tibi.whatsinmycity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

public class Successfully_Registered extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully__registered);
        new CountDownTimer(3000, 1000)
        {

            public void onTick(long millisUntilFinished)
            {

            }

            public void onFinish()
            {
                Intent intent = new Intent(Successfully_Registered.this,  MapsActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
