package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moneyminder.databinding.ActivityLoginPageBinding;
import com.example.moneyminder.databinding.ActivitySignupBinding;

public class Login_page extends AppCompatActivity {
    ActivityLoginPageBinding binding;
    DatabaseHelper databaseHelper;
    private EditText userNameEditText;
    private EditText passEditText;
    private Button btnLogin;
    private TextView btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.emailLogin.getText().toString();
                String password = binding.password.getText().toString();

                if(email.equals("")|| password.equals("")){
                    Toast.makeText(Login_page.this,"All feilds are mandatory",Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email,password);
                    if(checkCredentials == true){
                        Toast.makeText(Login_page.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }
                }

            }

        });
        binding.RedirectReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_page.this, Signup.class);
            }
        });

    }

    /* registration onclick event for login button */

}
