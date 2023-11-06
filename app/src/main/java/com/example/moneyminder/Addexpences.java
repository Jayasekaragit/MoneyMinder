package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.moneyminder.databinding.ActivityAddexpencesBinding;
import com.example.moneyminder.databinding.ActivitySignupBinding;

import java.io.Serializable;

public class Addexpences extends AppCompatActivity {
    String appendedText = "";
    ActivityAddexpencesBinding binding;
    DatabaseHelper databaseHelperExpense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddexpencesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        databaseHelperExpense = new DatabaseHelper(this);

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = Integer.parseInt(binding.amount.getText().toString());
                String catergory = appendedText.toString();
                if (amount != 0) {
                    Boolean insert = databaseHelperExpense. addExpense(amount,catergory);
                    appendedText = null;
                }else {
                    Toast.makeText(Addexpences.this,"adding failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.shoping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendedText = "Shopping";
            }
        });
        binding.food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendedText = "Food";
            }
        });
        binding.health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendedText = "Health";
            }
        });
        binding.transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendedText = "Transport";
            }
        });
        binding.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendedText = "Home";
            }
        });
        binding.expensebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Addexpences.this, ExpensesActivity.class));

            }
        });
    }



}



