package com.example.sem5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MusicServiceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_service);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Music Service");

        Button btnStart = findViewById(R.id.btnStartMusic);
        Button btnStop = findViewById(R.id.btnStopMusic);

        btnStart.setOnClickListener(v -> {
            startService(new Intent(this, MusicService.class));
            Toast.makeText(this, "Music Started", Toast.LENGTH_SHORT).show();
        });

        btnStop.setOnClickListener(v -> {
            stopService(new Intent(this, MusicService.class));
            Toast.makeText(this, "Music Stopped", Toast.LENGTH_SHORT).show();
        });
    }
}

