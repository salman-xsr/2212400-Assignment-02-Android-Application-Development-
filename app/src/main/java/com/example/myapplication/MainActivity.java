package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Find Reset Button
        Button btnReset = findViewById(R.id.btnReset);

        // Reset button clears fields
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = findViewById(R.id.etName);
                EditText etPassword = findViewById(R.id.etPassword);
                TextView tvMessage = findViewById(R.id.tvMessage);

                etName.setText("");
                etPassword.setText("");
                tvMessage.setText("");

                Toast.makeText(MainActivity.this, "Fields are cleared!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Login Button Click Function
    public void login(View v) {
        EditText etName = findViewById(R.id.etName);
        String strName = etName.getText().toString().trim();

        EditText etPassword = findViewById(R.id.etPassword);
        String strPassword = etPassword.getText().toString().trim();

        if (strName.isEmpty()) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            return;
        } else if (strPassword.isEmpty()) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        } else {
            // Hard-coded credentials (example)
            if (strName.equals("admin") && strPassword.equals("1234")) {
                TextView tvMessage = findViewById(R.id.tvMessage);
                tvMessage.setText("Welcome " + strName + "!");
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
