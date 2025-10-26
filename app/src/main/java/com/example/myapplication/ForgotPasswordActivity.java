package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText email;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.email);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(v -> {
            String emailText = email.getText().toString().trim();
            if (emailText.isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            } else {
                // Simulate reset logic
                Toast.makeText(this, "Reset link sent to " + emailText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
