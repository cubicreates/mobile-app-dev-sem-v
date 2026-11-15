package com.example.sem5;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LifecycleActivity extends BaseActivity {

    TextView tvLog;
    String logText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Activity Lifecycle");

        tvLog = findViewById(R.id.tvLifecycle);
        addState("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        addState("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        addState("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        addState("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        addState("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        addState("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    void addState(String state) {
        logText = logText + state + "\n";
        tvLog.setText(logText);
        Toast.makeText(this, state, Toast.LENGTH_SHORT).show();
    }
}

