package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = (EditText) findViewById(R.id.etName);
                EditText etPassword = (EditText) findViewById(R.id.etPassword);
                TextView tvMessage = findViewById(R.id.tvMessage);
                etName.setText("");
                etPassword.setText("");
                tvMessage.setText("");
                Toast.makeText(MainActivity.this, "Fields are cleared!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void login(View v) {
        EditText etName = findViewById(R.id.etName);
        String strName = etName.getText().toString();
        EditText etPassword = findViewById(R.id.etPassword);
        String strPassword = etPassword.getText().toString();
        if(strName.equals("")) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(strPassword.equals("")) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        }
        else {
            // Hard-code username and password in if condition here for displaying login success or failed message.
            // Later on you can modify this code and add database connectivity for login authentication.
            TextView tvMessage = findViewById(R.id.tvMessage);
            tvMessage.setText("Welcom " + strName + "!");
        }
    }
}