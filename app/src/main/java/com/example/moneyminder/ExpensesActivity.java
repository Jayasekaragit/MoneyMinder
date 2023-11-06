package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ExpensesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> catergory, amount;
    DatabaseHelper DB;
    ExpenseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        DB = new DatabaseHelper(this);
        catergory = new ArrayList<>();
        amount = new ArrayList<>();
        recyclerView = findViewById(R.id.recycle);
        adapter = new ExpenseAdapter(this,catergory,amount);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

    }
    public void displayData(){
        Cursor cursor = DB.getExpenseData();
        if (cursor.getCount()==0){
            Toast.makeText(ExpensesActivity.this,"No entry Exhist",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                catergory.add(cursor.getString(1));
                amount.add(cursor.getString(2));

            }
        }
    }




}