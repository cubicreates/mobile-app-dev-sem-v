package com.example.sem5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirebaseActivity extends BaseActivity {

    EditText etName;
    Button btnAdd, btnShow;
    TextView tvNames;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Firebase Database");

        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAddFirebase);
        btnShow = findViewById(R.id.btnShowFirebase);
        tvNames = findViewById(R.id.tvFirebaseNames);

        dbHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Enter a name", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.addName(name);
                Toast.makeText(this, "Added to Firebase", Toast.LENGTH_SHORT).show();
                etName.setText("");
            }
        });

        btnShow.setOnClickListener(v -> {
            ArrayList<String> list = dbHelper.getAllNames();
            if (list.isEmpty()) {
                tvNames.setText("No names found");
            } else {
                String names = "";
                for (String n : list) {
                    names = names + n + "\n";
                }
                tvNames.setText(names);
            }
        });
    }
}
