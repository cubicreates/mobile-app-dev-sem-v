package com.example.sem5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Implicit Intent");

        EditText etUrl = findViewById(R.id.etUrl);
        EditText etPhone = findViewById(R.id.etPhone);
        Button btnWeb = findViewById(R.id.btnOpenWeb);
        Button btnCall = findViewById(R.id.btnMakeCall);

        btnWeb.setOnClickListener(v -> {
            String url = etUrl.getText().toString();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        btnCall.setOnClickListener(v -> {
            String phone = etPhone.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            startActivity(intent);
        });
    }
}

