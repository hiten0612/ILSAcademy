package com.ils.ilsacademy;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ContentActivity extends AppCompatActivity {

    Toolbar cnToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        cnToolbar = findViewById(R.id.cnToolbar);
        cnToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }
}