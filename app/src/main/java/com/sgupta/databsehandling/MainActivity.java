package com.sgupta.databsehandling;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    DatabaseAdapter mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.usernameEditText);
        mPassword = (EditText) findViewById(R.id.passwordEditText);
        mDatabase = new DatabaseAdapter(this);

    }

    public void save(View view){
        /*SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",mUsername.getText().toString());
        editor.putString("password",mPassword.getText().toString());
        editor.commit();
        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();*/

        long id = mDatabase.insert(mUsername.getText().toString());
        if(id!=1){
            Toast.makeText(MainActivity.this,""+id,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,""+id,Toast.LENGTH_SHORT).show();
        }
    }

    public void next(View view){
        Intent intent = new Intent(this,activity_b.class);
        startActivity(intent);
    }
}
