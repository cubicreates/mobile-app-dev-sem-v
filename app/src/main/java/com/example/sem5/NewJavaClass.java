package com.example.sem5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewJavaClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TextView tvDetails = findViewById(R.id.tvDetails);
        Button btnBack = findViewById(R.id.btnBack);

        String details = getIntent().getStringExtra("student_details");
        if (details != null) {
            tvDetails.setText(details);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}