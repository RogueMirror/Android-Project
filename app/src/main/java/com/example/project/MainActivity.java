package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);

        /*try {
            SQLiteDatabase myDB = this.openOrCreateDatabase("HelloWT", 0, null);
            myDB.execSQL("CREATE TABLE IF NOT EXISTS login (wtmail TEXT PRIMARY KEY, password TEXT)");
            myDB.execSQL("INSERT INTO login (wtmail, password) VALUES ('alice@wtamu.edu', 'password')");
            myDB.execSQL("INSERT INTO login (wtmail, password) VALUES ('jlcurrie1@buffs.wtamu.edu', 'password')");
        }catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void loginCheck(View view) {
        try {
            if (textEmail.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Please input username and password", Toast.LENGTH_LONG).show();
            } else {
                SQLiteDatabase myDB = this.openOrCreateDatabase("HelloWT", 0, null);
                String loginQuery = "SELECT * FROM login WHERE login.wtmail ='" + textEmail.getText() + "' AND login.Password = '" + textPassword.getText() + "'";
                Cursor c = myDB.rawQuery(loginQuery, null);

                if (c.getCount() > 0) {
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MainActivityDashboard.class);
                    String userEmail = textEmail.getText().toString();
                    intent.putExtra("userEmail", userEmail);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Email or password", Toast.LENGTH_LONG).show();
                }
            }
        }
        catch(
                Exception e) {
            Log.i("SQLError", e.toString());
            Toast.makeText(MainActivity.this, "Database Errors", Toast.LENGTH_LONG).show();
        }
    }

    /*public void createAccount(View view) {
        if (textEmail.getText().toString().equals("") || textPassword.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Please input username and password", Toast.LENGTH_LONG).show();
        } else {
            try {
                String createAccountQuery = "INSERT INTO login (wtmail, password) VALUES ('" + textEmail.getText() + "','" + textPassword.getText() + "')";
                SQLiteDatabase myDB = this.openOrCreateDatabase("HelloWT", 0, null);
                myDB.execSQL(createAccountQuery);
            } catch (SQLiteConstraintException e) {
                Toast.makeText(MainActivity.this, "This email is already taken. Please choos another email", Toast.LENGTH_LONG).show();
            }
        }
    }*/
}