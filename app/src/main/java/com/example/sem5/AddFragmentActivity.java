package com.example.sem5;

import android.os.Bundle;

public class AddFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Add Fragment");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new FirstFragment())
                    .commit();
        }
    }
}

