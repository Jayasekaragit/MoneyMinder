package com.example.moneyminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {

        super(context, "SignUp.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDatabase){
        MyDatabase.execSQL("create table allusers(name TEXT,username TEXT, email TEXT primary key,password TEXT)");
        MyDatabase.execSQL("create table expenses(id INTEGER primary key AUTOINCREMENT,amount INTEGER,category TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1){
        MyDatabase.execSQL("drop Table if exists allusers");

    }

    public Boolean insertData(String name, String username, String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("username",username);
        values.put("email",email);
        values.put("password",password);
        long result = MyDatabase.insert("allusers",null,values);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean addExpense(int amount, String category){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues expense = new ContentValues();
        expense.put("amount",amount);
        expense.put("category",category);
        long resultExpense = MyDatabase.insert("expenses",null,expense);
        if(resultExpense == -1){
            return false;
        }
        else {
            return true;
        }
    }




    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ?",new String[]{email});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ? and password = ?",new String[]{email,password});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }

    public Cursor getExpenseData() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =  db.rawQuery("SELECT amount,category FROM expenses", null);
        return cursor;
    }




}
