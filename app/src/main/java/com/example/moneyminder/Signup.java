package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
                String name = binding.name.getText().toString().trim();
                String username = binding.username.getText().toString().trim();
                String email = binding.emailSignUp.getText().toString().trim();
                String password = binding.password.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (!isValidEmail(email)) {
                        Toast.makeText(Signup.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!databaseHelper.checkEmail(email)) {
                            boolean insert = databaseHelper.insertData(name, username, email, password);
                            if (insert) {
                                Toast.makeText(Signup.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Login_page.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Signup.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Signup.this, "User already exists, please login", Toast.LENGTH_SHORT).show();
                        }
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

    // Helper method to validate email format
    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
