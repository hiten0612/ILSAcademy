package com.ils.ilsacademy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class NoticeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextInputLayout tilTitle, tilDescription;
    private EditText title, des;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        tilTitle = findViewById(R.id.tilTitle);
        tilDescription = findViewById(R.id.tilDescription);
        title = findViewById(R.id.title);
        des = findViewById(R.id.des);
        submit = findViewById(R.id.submit);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilTitle.setError("please enter title");
                    return;
                } else {
                    tilTitle.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        des.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilDescription.setError("please enter description");
                    return;
                } else {
                    tilDescription.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valid(title.getText().toString(), des.getText().toString());

            }

        });

    }

    private void valid(String title, String description) {
        if (title.isEmpty()) {
            tilTitle.setError("please enter title");
            return;
        } else {
            tilTitle.setError("");
        }

        if (description.isEmpty()) {
            tilDescription.setError("please enter description");
            return;
        } else {
            tilDescription.setError("");
        }

        if (title.equals("holiday") && description.equals("sunday means holiday")) {
            Intent intent = new Intent(NoticeActivity.this, DeshBoard.class);
            startActivity(intent);
            finish();


        } else {
            Toast.makeText(NoticeActivity.this, "this is not valid title or description", Toast.LENGTH_SHORT).show();
        }
    }
}