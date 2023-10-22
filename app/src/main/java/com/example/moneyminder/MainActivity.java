package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String logVariable = "logFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(logVariable,"On create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(logVariable,"onStart");
    }
}