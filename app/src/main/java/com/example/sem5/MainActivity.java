package com.example.sem5;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etAddress, etPhone;
    TextView tvAirplaneModeBanner;
    RadioGroup rgGender;
    CheckBox cbAndroid, cbJava, cbKotlin, cbXML, cbFirebase;
    Button btnSubmit, btnClear, btnGithub, btnCall, btnMap, btnFile, btnBattery;
    private boolean isReceiverRegistered = false;
    private boolean isAirplaneReceiverRegistered = false;

    private final BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                int batteryPct = BatteryHelper.calculatePercentage(level, scale);
                if (batteryPct >= 0) {
                    Toast.makeText(context, "Battery Level: " + batteryPct + "%", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    private final BroadcastReceiver airplaneModeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null && Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
                boolean state = intent.getBooleanExtra("state", AirplaneModeHelper.isAirplaneModeOn(context));
                updateAirplaneModeBanner(state);
            }
        }
    };

    private static final int REQUEST_CALL_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Student Form");

        etName = findViewById(R.id.etName);
        tvAirplaneModeBanner = findViewById(R.id.tvAirplaneModeBanner);
        updateAirplaneModeBanner(AirplaneModeHelper.isAirplaneModeOn(this));
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        rgGender = findViewById(R.id.rgGender);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbJava = findViewById(R.id.cbJava);
        cbKotlin = findViewById(R.id.cbKotlin);
        cbXML = findViewById(R.id.cbXML);
        cbFirebase = findViewById(R.id.cbFirebase);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);
        btnGithub = findViewById(R.id.btnGithub);
        btnCall = findViewById(R.id.btnCall);
        btnMap = findViewById(R.id.btnMap);
        btnFile = findViewById(R.id.btnFile);
        btnBattery = findViewById(R.id.btnBattery);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/cubicreates"));
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        btnFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileManager();
            }
        });

        btnBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBatteryLevel();
            }
        });
    }

    private void openFileManager() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivity(Intent.createChooser(intent, "Open File Manager"));
    }

    private void openMap() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=K.R.+Mangalam+University");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // Fallback: try without package in case Maps is not installed
            Intent fallbackIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(fallbackIntent);
        }
    }

    private void makePhoneCall() {
        String number = etPhone.getText().toString().trim();
        if (number.isEmpty()) {
            Toast.makeText(this, "Enter a phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        } else {
            String phoneNumber = "tel:" + number;
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(phoneNumber));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_adit) {
            Toast.makeText(this, "adit selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_harsh) {
            Toast.makeText(this, "harsh selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_ghosh) {
            Toast.makeText(this, "ghosh selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_pancha) {
            Toast.makeText(this, "pancha selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void submitForm() {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String address = etAddress.getText().toString();

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        String gender = "";
        if (selectedGenderId != -1) {
            RadioButton rb = findViewById(selectedGenderId);
            gender = rb.getText().toString();
        }

        ArrayList<String> skills = new ArrayList<>();
        if (cbAndroid.isChecked()) skills.add("Android");
        if (cbJava.isChecked()) skills.add("Java");
        if (cbKotlin.isChecked()) skills.add("Kotlin");
        if (cbXML.isChecked()) skills.add("XML");
        if (cbFirebase.isChecked()) skills.add("Firebase");

        StringBuilder skillsBuilder = new StringBuilder();
        for (int i = 0; i < skills.size(); i++) {
            skillsBuilder.append(skills.get(i));
            if (i < skills.size() - 1) {
                skillsBuilder.append(", ");
            }
        }
        String skillsString = skillsBuilder.toString();

        if (name.isEmpty() || age.isEmpty() || address.isEmpty() || gender.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String details = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Skills: " + skillsString + "\n" +
                "Address: " + address;

        Intent intent = new Intent(MainActivity.this, NewJavaClass.class);
        intent.putExtra("student_details", details);
        startActivity(intent);
    }

    private void clearForm() {
        etName.setText("");
        etAge.setText("");
        etAddress.setText("");
        etPhone.setText("");
        rgGender.clearCheck();
        cbAndroid.setChecked(false);
        cbJava.setChecked(false);
        cbKotlin.setChecked(false);
        cbXML.setChecked(false);
        cbFirebase.setChecked(false);
    }

    private void showBatteryLevel() {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, ifilter);
        if (batteryStatus != null) {
            int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int batteryPct = BatteryHelper.calculatePercentage(level, scale);
            if (batteryPct >= 0) {
                Toast.makeText(this, "Battery Level: " + batteryPct + "%", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(this, "Unable to read battery level", Toast.LENGTH_SHORT).show();
    }

    private void updateAirplaneModeBanner(boolean isActive) {
        if (tvAirplaneModeBanner != null) {
            tvAirplaneModeBanner.setText(AirplaneModeHelper.getStatusText(isActive));
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(16f);
            drawable.setColor(AirplaneModeHelper.getStatusColor(isActive));
            tvAirplaneModeBanner.setBackground(drawable);
            tvAirplaneModeBanner.setTextColor(Color.WHITE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isReceiverRegistered) {
            registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            isReceiverRegistered = true;
        }
        if (!isAirplaneReceiverRegistered) {
            registerReceiver(airplaneModeReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
            isAirplaneReceiverRegistered = true;
        }
        updateAirplaneModeBanner(AirplaneModeHelper.isAirplaneModeOn(this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isReceiverRegistered) {
            unregisterReceiver(batteryReceiver);
            isReceiverRegistered = false;
        }
        if (isAirplaneReceiverRegistered) {
            unregisterReceiver(airplaneModeReceiver);
            isAirplaneReceiverRegistered = false;
        }
    }
}