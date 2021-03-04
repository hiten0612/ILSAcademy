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

public class LiveActivity extends AppCompatActivity {

    Button liveSubmit;
    private Toolbar etToolbar;
    private TextInputLayout tilTit, tilDes, tilLink;
    private EditText etTitle, etDes, etLink;

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
        liveSubmit = findViewById(R.id.liveSubmit);

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


        liveSubmit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              meet(etTitle.getText().toString(),etDes.getText().toString(),etLink.getText().toString());

          }
      });

    }



    private void meet(String title, String description, String link) {
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

        if (title.equals("no") && description.equals("leacture") && link.equals("today")) {
            Intent inte = new Intent(LiveActivity.this, DeshBoard.class);
            startActivity(inte);
            finish();

        } else {
            Toast.makeText(LiveActivity.this, "this is not valid title , description or link", Toast.LENGTH_SHORT).show();
        }
    }


}
