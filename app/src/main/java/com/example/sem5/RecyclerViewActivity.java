package com.example.sem5;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "RecyclerView & CardView");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> list = new ArrayList<>();
        list.add("Unit 1: Introduction to Android");
        list.add("Unit 2: Activities and Intents");
        list.add("Unit 3: Fragments");
        list.add("Unit 4: Action Bar and Menus");
        list.add("Unit 5: Broadcast and Services");

        StudentAdapter adapter = new StudentAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}

