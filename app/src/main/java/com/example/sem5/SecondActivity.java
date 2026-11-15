package com.example.sem5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvReceived = findViewById(R.id.tvReceived);
        Button btnBack = findViewById(R.id.btnBack);

        String data = getIntent().getStringExtra("data");
        tvReceived.setText("Received: " + data);

        btnBack.setOnClickListener(v -> finish());
    }
}

