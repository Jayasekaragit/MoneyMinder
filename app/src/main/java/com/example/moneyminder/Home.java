package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView income;
    Button expenseBtn, incomeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        income = findViewById(R.id.income);
        incomeBtn = findViewById(R.id.incomebutton);
        expenseBtn = findViewById(R.id.expensebutton);

        // Set OnClickListener for the "INCOME" button
        incomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement the logic for the "INCOME" button here
                // For example, update the incomeEditText with new data
                startActivity(new Intent(Home.this, AddIncome.class));

            }
        });

        // Set OnClickListener for the "EXPENSES" button
        expenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement the logic for the "EXPENSES" button here
                // For example, update the incomeEditText with new data
                startActivity(new Intent(Home.this, Addexpences.class));

            }
        });
    }


}