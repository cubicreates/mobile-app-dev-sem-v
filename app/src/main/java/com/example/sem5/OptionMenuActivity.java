package com.example.sem5;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class OptionMenuActivity extends BaseActivity {

    TextView tvSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Option Menu");

        tvSelected = findViewById(R.id.tvOptionSelected);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.opt_about) {
            tvSelected.setText("Clicked: About");
        } else if (item.getItemId() == R.id.opt_home) {
            tvSelected.setText("Clicked: Home");
        }
        return super.onOptionsItemSelected(item);
    }
}

