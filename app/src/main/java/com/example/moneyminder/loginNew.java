package com.example.moneyminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginNew extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passEditText;
    private Button btnLogin;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);

        registration();
    }
    private void registration(){
         userNameEditText=findViewById(R.id.userName);
         passEditText=findViewById(R.id.password);
         btnLogin=findViewById(R.id.getStartedBtn);
         btnSignUp=findViewById(R.id.signBtn);

         btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String userName = userNameEditText.getText().toString().trim();
                 String password = passEditText.getText().toString().trim();

                 if (TextUtils.isEmpty(userName)){
                     userNameEditText.setError("Email Reqired");
                 }

                 if (TextUtils.isEmpty(password)){
                     passEditText.setError("password Reqired");
                 }
                 if (userName.equals("pasindu") && password.equals("1234")){
                     startActivity(new Intent(loginNew.this,Addexpences.class));
                 }
             }
         });
    };
}
