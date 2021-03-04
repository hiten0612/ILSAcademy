package com.ils.ilsacademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

public class ContentActivity extends AppCompatActivity {

    Toolbar cnToolbar;
    AppCompatTextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        String value = getIntent().getStringExtra("contentType");

        cnToolbar = findViewById(R.id.cnToolbar);
        txtContent = findViewById(R.id.txtContent);

        if (value.equals("About")) {
            cnToolbar.setTitle("About Us");
            txtContent.setText(getResources().getString(R.string.dummy_description));
        } else if (value.equals("Terms")) {
            cnToolbar.setTitle("Terms & Conditions");
            txtContent.setText("Terms & Conditions content Data");
        }

        cnToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}