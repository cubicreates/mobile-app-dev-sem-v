package com.example.sem5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseActivity extends BaseActivity {

    EditText etName;
    Button btnAdd, btnShow;
    TextView tvNames;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        setupDrawer(R.id.drawerLayout, R.id.navigationView, "Firebase Database");

        etName = findViewById(R.id.etName);
        btnAdd = findViewById(R.id.btnAddFirebase);
        btnShow = findViewById(R.id.btnShowFirebase);
        tvNames = findViewById(R.id.tvFirebaseNames);

        dbRef = FirebaseDatabase.getInstance().getReference("Users");

        btnAdd.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Enter a name", Toast.LENGTH_SHORT).show();
            } else {
                dbRef.push().setValue(name).addOnSuccessListener(unused -> {
                    Toast.makeText(this, "Added to Firebase", Toast.LENGTH_SHORT).show();
                    etName.setText("");
                });
            }
        });

        btnShow.setOnClickListener(v -> {
            dbRef.get().addOnSuccessListener(snapshot -> {
                String names = "";
                for (DataSnapshot child : snapshot.getChildren()) {
                    names = names + child.getValue(String.class) + "\n";
                }
                if (names.isEmpty()) {
                    tvNames.setText("No names found");
                } else {
                    tvNames.setText(names);
                }
            });
        });
    }
}
