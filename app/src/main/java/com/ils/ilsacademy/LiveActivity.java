package com.ils.ilsacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LiveActivity extends AppCompatActivity {

    private Toolbar etToolbar;
    private TextInputLayout tilTit ,tilDes ,tilLink;
    private EditText etTitle ,etDes,etLink;
    Button etSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        tilTit = findViewById(R.id.tilTit);
        tilDes = findViewById(R.id.tilDes);
        tilLink = findViewById(R.id.tilLink);
        etTitle = findViewById(R.id.etTitle);
        etDes = findViewById(R.id.etDes);
        etLink = findViewById(R.id.etLink);
        etSubmit = findViewById(R.id.etSubmit);

        etToolbar = findViewById(R.id.etToolbar);
        etToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        etTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilTit.setError("please enter title");
                    return;
                } else {
                    tilTit.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etDes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilDes.setError("please enter description");
                    return;
                } else {
                    tilDes.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etLink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilLink.setError("please enter Link");
                    return;
                } else {
                    tilLink.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meeting(etTitle.getText().toString(), etDes.getText().toString(),etLink.getText().toString());

            }

        });

    }

    private void meeting(String title, String description ,String link) {
        if (title.isEmpty()) {
            tilTit.setError("please enter title");
            return;
        } else {
            tilTit.setError("");
        }

        if (description.isEmpty()) {
            tilDes.setError("please enter description");
            return;
        } else {
            tilDes.setError("");
        }

        if (link.isEmpty()) {
            tilLink.setError("please enter link");
            return;
        } else {
            tilLink.setError("");
        }

        if (title.equals("sunday") && description.equals("holiday") && link.equals("link")) {
            Intent inte = new Intent(LiveActivity.this, DeshBoard.class);
            startActivity(inte);
            finish();

        }else {
            Toast.makeText(LiveActivity.this, "this is not valid title , description or link", Toast.LENGTH_SHORT).show();
        }
    }


}
