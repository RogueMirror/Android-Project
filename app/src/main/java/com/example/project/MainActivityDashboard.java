package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityDashboard extends AppCompatActivity {
    TextView textView;
    Button buttonWTClass, buttonNotes, buttonWeather, signoutCheck;
    Intent intentWTClass, intentNotes, intentWeather, intentSignout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        Intent intent = getIntent();

        String userEmail = intent.getStringExtra("userEmail");
        textView = findViewById(R.id.textPassedEmail);
        textView.setText("Username: " + userEmail);

        buttonWTClass = findViewById(R.id.buttonWTClass);
        buttonNotes = findViewById(R.id.buttonNotes);
        buttonWeather = findViewById(R.id.buttonWeather);
        signoutCheck = findViewById(R.id.signoutCheck);
        intentWTClass = new Intent(this, MainActivityWTClass.class);
        intentNotes = new Intent(this, MainActivityNotes.class);
        intentWeather = new Intent(this, MapsActivityWeather.class);
        intentSignout = new Intent(this, MainActivity.class);

        buttonWTClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentWTClass);
            }
        });

        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentNotes);
            }
        });

        buttonWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentNotes);
            }
        });

        signoutCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSignout);
            }
        });
    }
}
