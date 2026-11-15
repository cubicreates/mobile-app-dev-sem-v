package com.example.sem5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class BroadcastActivity extends BaseActivity {

    String ACTION_CUSTOM = "com.example.sem5.CUSTOM_BROADCAST";
    TextView tvStatus;

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra("msg");
            tvStatus.setText("Received: " + msg);
            Toast.makeText(context, "Broadcast Received: " + msg, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Custom Broadcast");

        tvStatus = findViewById(R.id.tvBroadcastStatus);
        Button btnSend = findViewById(R.id.btnSendBroadcast);

        btnSend.setOnClickListener(v -> {
            Intent intent = new Intent(ACTION_CUSTOM);
            intent.setPackage(getPackageName());
            intent.putExtra("msg", "Hello from Custom Broadcast!");
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ACTION_CUSTOM);
        ContextCompat.registerReceiver(this, receiver, filter, ContextCompat.RECEIVER_NOT_EXPORTED);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }
}

