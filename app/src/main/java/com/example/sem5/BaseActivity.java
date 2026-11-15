package com.example.sem5;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    protected ActionBarDrawerToggle toggle;

    protected void setupDrawer(int drawerId, int navViewId, String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = findViewById(drawerId);
        NavigationView navigationView = findViewById(navViewId);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_hello) {
                startActivity(new Intent(this, MainActivity.class));
            } else if (id == R.id.nav_login) {
                startActivity(new Intent(this, LoginActivity.class));
            } else if (id == R.id.nav_recycler) {
                startActivity(new Intent(this, RecyclerViewActivity.class));
            } else if (id == R.id.nav_lifecycle) {
                startActivity(new Intent(this, LifecycleActivity.class));
            } else if (id == R.id.nav_explicit) {
                startActivity(new Intent(this, ExplicitIntentActivity.class));
            } else if (id == R.id.nav_implicit) {
                startActivity(new Intent(this, ImplicitIntentActivity.class));
            } else if (id == R.id.nav_add_fragment) {
                startActivity(new Intent(this, AddFragmentActivity.class));
            } else if (id == R.id.nav_replace_fragment) {
                startActivity(new Intent(this, ReplaceFragmentActivity.class));
            } else if (id == R.id.nav_pass_fragment) {
                startActivity(new Intent(this, PassDataFragmentActivity.class));
            } else if (id == R.id.nav_option_menu) {
                startActivity(new Intent(this, OptionMenuActivity.class));
            } else if (id == R.id.nav_context_popup) {
                startActivity(new Intent(this, ContextPopupMenuActivity.class));
            } else if (id == R.id.nav_tabs) {
                startActivity(new Intent(this, TabViewPagerActivity.class));
            } else if (id == R.id.nav_broadcast) {
                startActivity(new Intent(this, BroadcastActivity.class));
            } else if (id == R.id.nav_notification) {
                startActivity(new Intent(this, NotificationActivity.class));
            } else if (id == R.id.nav_music_service) {
                startActivity(new Intent(this, MusicServiceActivity.class));
            }
            drawerLayout.closeDrawers();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle != null && toggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.opt_home) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        } else if (id == R.id.opt_about) {
            Toast.makeText(this, "Sem5 Android Practical App", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.opt_exit) {
            finishAffinity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

