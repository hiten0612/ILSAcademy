package com.ils.ilsacademy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class ForgotPassword extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText etEmail;
    private TextInputLayout tilEmail;
    private Button etSubmit;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        toolbar = findViewById(R.id.etToolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tilEmail = findViewById(R.id.tilEmail);
        etSubmit = findViewById(R.id.etSubmit);
        etSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation(etEmail.getText().toString());
            }
        });

        etEmail = findViewById(R.id.etEmail);

    }

    private void validation(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.isEmpty()) {
            tilEmail.setError("please enter email");
        }
        else if (!email.matches(emailPattern))
        {
            tilEmail.setError("please enter valid email");
        }
        else {
            tilEmail.setError("");
        }
    }
}