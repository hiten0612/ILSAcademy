package com.ils.ilsacademy;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class FeedBack_Activity extends AppCompatActivity {

    Toolbar fdToolbar;
    TextInputEditText fdTitle;
    TextInputLayout filTitle;
    Button fdSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_);

        fdToolbar = findViewById(R.id.fdToolbar);
        fdToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedBack_Activity.this, ProfileScreen.class);
                startActivity(intent);

            }
        });
        fdTitle = findViewById(R.id.fdTitle);
        filTitle = findViewById(R.id.filTitle);
        fdTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    filTitle.setError("please enter feedback");
                } else {
                    filTitle.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fdSubmit = findViewById(R.id.fdSubmit);
        fdSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init(fdTitle.getText().toString());
            }
        });
    }

    private void init(String feedback) {
        if (feedback.isEmpty()) {
            filTitle.setError("please enter feedback");
            return;
        } else {
            filTitle.setError("");
        }
    }
}