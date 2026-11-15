package com.example.sem5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitIntentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Explicit Intent");

        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String msg = etMessage.getText().toString();
            Intent intent = new Intent(ExplicitIntentActivity.this, SecondActivity.class);
            intent.putExtra("data", msg);
            startActivity(intent);
        });
    }
}

