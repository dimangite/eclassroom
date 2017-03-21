package com.example.mengsroinheng.practice1.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mengsroinheng.practice1.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    Button button_login;
    EditText editText_username, editText_password;
    CheckBox checkBox_rememberMe;
    String username , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_login= (Button) findViewById(R.id.button_login);
        editText_password= (EditText) findViewById(R.id.editText_password);
        editText_username= (EditText) findViewById(R.id.editText_username);
        checkBox_rememberMe= (CheckBox) findViewById(R.id.checkbox_rememberMe);
        onRunning();
    }

    private void onRunning(){
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                username= editText_username.getText().toString();
                password= editText_password.getText().toString();
                if (checkUser(username,password)) {
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Username and password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private boolean checkUser(String uname, String pword){
        String username= "Mengsroin";
        String password= "12345";
        return Objects.equals(uname, username) && Objects.equals(password, pword);
    }
}
