package com.sgupta.databsehandling;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class activity_b extends AppCompatActivity {

    private TextView mUsername;
    private TextView mPassword;
    private static final String mDefault ="default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);

        mUsername = (TextView) findViewById(R.id.usernameTextView2);
        mPassword = (TextView) findViewById(R.id.passwordTextView2);
    }

    public void load(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("name",mDefault);
        String password = sharedPreferences.getString("password",mDefault);
        mUsername.setText(username);
        mPassword.setText(password);
        if(username.equals(mDefault) || password.equals(mDefault)){
            Toast.makeText(this,"data not saved", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"data found",Toast.LENGTH_LONG).show();
        }
    }

    public void previous(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
