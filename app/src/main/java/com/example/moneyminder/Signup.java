package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moneyminder.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {
    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.name.getText().toString();
                String username = binding.username.getText().toString();
                String email = binding.emailSignUp.getText().toString();
                String password = binding.password.getText().toString();

                if (email.equals("") || password.equals("") || username.equals("") || name.equals("")) {
                    Toast.makeText(Signup.this, "please fill all the feilds", Toast.LENGTH_SHORT).show();
                }else{
                    if (password != ("")) {
                        Boolean checkUserEmail = databaseHelper.checkEmailPassword(email,password);
                        if (checkUserEmail == false) {
                            Boolean insert = databaseHelper. insertData(name,username,email, password);
                            if (insert == true){
                                Toast.makeText(Signup.this,"SignUp Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login_page.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Signup.this,"Sign Up failed",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Signup.this,"User already exist, please login",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Signup.this,"invalid email or password ", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
        binding.loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login_page.class);
                startActivity(intent);
            }
        });

    }

}