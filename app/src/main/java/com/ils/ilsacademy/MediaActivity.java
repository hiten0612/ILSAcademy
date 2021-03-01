package com.ils.ilsacademy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class MediaActivity extends AppCompatActivity {
    private Toolbar mdToolbar;
    private TextInputLayout tilTitle, tilDescription;
    private EditText mdTitle, mdDes;
    private Button mdSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        tilTitle = findViewById(R.id.tilTitle);
        tilDescription = findViewById(R.id.tilDescription);
        mdTitle = findViewById(R.id.mdTitle);
        mdDes = findViewById(R.id.mdDes);
        mdSubmit = findViewById(R.id.mdSubmit);

        mdToolbar = findViewById(R.id.mdToolbar);
        mdToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}