package com.example.sem5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class ReplaceFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_fragment);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Replace Fragment");

        loadFragment(new FirstFragment());

        findViewById(R.id.btnFrag1).setOnClickListener(v -> loadFragment(new FirstFragment()));
        findViewById(R.id.btnFrag2).setOnClickListener(v -> loadFragment(new SecondFragment()));
    }

    void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}

