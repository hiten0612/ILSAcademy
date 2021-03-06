package com.ils.ilsacademy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button login;
    private TextView click;
    private AppCompatCheckBox chkRemember;
    private TextInputLayout tilUserName, tilPassword;
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        click = findViewById(R.id.click);
        tilUserName = findViewById(R.id.tilUserName);
        tilPassword = findViewById(R.id.tilPassword);
        chkRemember = findViewById(R.id.chkRemember);

        sharedPreferenceConfig = new SharedPreferenceConfig(Login.this);

        user.setText(sharedPreferenceConfig.getUserName());
        pass.setText(sharedPreferenceConfig.getPassword());

//        if(sharedPreferenceConfig.getUserName().isEmpty()){
//           chkRemember.setChecked(false);
//        }else{
//            chkRemember.setChecked(true);
//        }
        chkRemember.setChecked(!sharedPreferenceConfig.getUserName().isEmpty());

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilUserName.setError("please enter username");
                    return;
                } else {
                    tilUserName.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilPassword.setError("please enter password");
                    return;
                } else {
                    tilPassword.setError("");
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        login.setOnClickListener(view -> validate(user.getText().toString().trim(), pass.getText().toString().trim()));

        click.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, ForgotPassword.class);
            startActivity(intent);
        });
    }


    private void validate(String username, String password) {
        if (username.isEmpty()) {
            tilUserName.setError("please enter username");
            return;
        } else {
            tilUserName.setError("");
        }

        if (password.isEmpty()) {
            tilPassword.setError("please enter password");
            return;
        } else {
            tilPassword.setError("");
        }

        if (username.equals("Admin") && password.equals("12345")) {
            sharedPreferenceConfig.setLoginStatus(true);
            if (chkRemember.isChecked()) {
                sharedPreferenceConfig.saveUserData(username, password);
            } else {
                sharedPreferenceConfig.saveUserData("", "");
            }
            Intent intent = new Intent(this, DeshBoard.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(Login.this, "incorret usename or password", Toast.LENGTH_SHORT).show();
        }
    }
}