package com.example.sem5;

import android.os.Bundle;

public class PassDataFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_data_fragment);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Pass Data Fragments");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.senderContainer, new SenderFragment())
                    .replace(R.id.receiverContainer, new ReceiverFragment())
                    .commit();
        }
    }
}

