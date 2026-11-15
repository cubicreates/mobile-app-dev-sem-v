package com.example.sem5;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ContextPopupMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_popup_menu);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Context & Popup Menu");

        TextView tvContext = findViewById(R.id.tvContext);
        registerForContextMenu(tvContext);

        Button btnPopup = findViewById(R.id.btnPopup);
        btnPopup.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(ContextPopupMenuActivity.this, btnPopup);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(ContextPopupMenuActivity.this, "Popup: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
            popup.show();
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "Context: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}

