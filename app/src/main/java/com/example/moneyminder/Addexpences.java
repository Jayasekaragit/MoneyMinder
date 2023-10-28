package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Addexpences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexpences);
        int[] myArray = new int[5];
        myArray[0] = 1;
        myArray[1] = 2;
        myArray[2] = 3;
        myArray[3] = 4;

        for(int i = 0; i<myArray.length; i++){
            System.out.println("Element at index " + i + " : " + myArray[i] );
        }

    }
}