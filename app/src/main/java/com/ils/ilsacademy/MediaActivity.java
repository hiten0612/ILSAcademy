package com.ils.ilsacademy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.util.ArrayList;

import abhishekti7.unicorn.filepicker.UnicornFilePicker;
import abhishekti7.unicorn.filepicker.utils.Constants;

public class MediaActivity extends AppCompatActivity {
    private final ArrayList<Uri> photoPaths = new ArrayList<>();
    private final int REQUEST_CODE_PERMISSIONS = 101;
    private final String[] REQUIRED_PERMISSIONS = new String[]{
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE",
    };
    private Toolbar mdToolbar;
    private TextInputLayout tilTitle, tilDescription;
    private EditText mdTitle, mdDes;
    private Button mdSubmit;
    private AppCompatTextView txtFileName;
    private AppCompatImageView mdUpload, imgFileIcon;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        tilTitle = findViewById(R.id.tilTitle);
        tilDescription = findViewById(R.id.tilDescription);
        mdTitle = findViewById(R.id.mdTitle);
        mdDes = findViewById(R.id.mdDes);
        mdSubmit = findViewById(R.id.mdSubmit);
        txtFileName = findViewById(R.id.txtFileName);
        imgFileIcon = findViewById(R.id.imgFileIcon);

        mdToolbar = findViewById(R.id.mdToolbar);

        mdSubmit.setOnClickListener(view -> {
            init();
        });


        mdTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilTitle.setError("please enter Title");
                    return;
                } else {
                    tilTitle.setError("");
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mdDes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()) {
                    tilDescription.setError("please enter Description");
                    return;
                } else {
                    tilDescription.setError("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mdToolbar.setNavigationOnClickListener(view -> finish());

        mdUpload = findViewById(R.id.mdUpload);

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }

        mdUpload.setOnClickListener(view -> {
            if (allPermissionsGranted()) {
                UnicornFilePicker.from(MediaActivity.this)
                        .addConfigBuilder()
                        .selectMultipleFiles(false)
                        .setRootDirectory(Environment.getExternalStorageDirectory().getAbsolutePath())
                        .showHiddenFiles(false)
                        .setFilters(new String[]{"pdf", "png", "jpg", "jpeg", "mp4", "doc", "docx", "ppt", "pptx"})
                        .addItemDivider(true)
                        .theme(R.style.UnicornFilePicker_Default)
                        .build()
                        .forResult(Constants.REQ_UNICORN_FILE);
            } else {
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQ_UNICORN_FILE && resultCode == RESULT_OK) {
            if (data != null) {
                ArrayList<String> files = data.getStringArrayListExtra("filePaths");
                if (files != null && !files.isEmpty()) {
                    file = new File(files.get(0));
                    if (file != null && file.exists()) {
                        txtFileName.setText(file.getName());
                        String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("."));
                        switch (extension) {
                            case ".pdf":
                                imgFileIcon.setImageResource(R.drawable.ic_pdf);
                                break;
                            case ".png":
                            case ".jpg":
                            case ".jpeg":
                                imgFileIcon.setImageResource(R.drawable.ic_gallery);
                                break;
                            case ".mp4":
                                imgFileIcon.setImageResource(R.drawable.ic_audio);
                                break;
                            case ".doc":
                            case ".docx":
                                imgFileIcon.setImageResource(R.drawable.ic_docx);
                                break;
                            case ".ppt":
                            case ".pptx":
                                imgFileIcon.setImageResource(R.drawable.ic_ppt);
                                break;
                        }
                    } else {
                        txtFileName.setText("");
                    }
                }
            }
        }
    }

    private boolean allPermissionsGranted() {
        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(MediaActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                Toast.makeText(MediaActivity.this, "Permissions granted by the user.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MediaActivity.this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void init() {
        String sTitle = mdTitle.getText().toString().trim();
        String sDes = mdDes.getText().toString().trim();

        if (sTitle.isEmpty()) {
            tilTitle.setError("please enter Title");
        } else {
            tilTitle.setError("");
        }

        if (sDes.isEmpty()) {
            tilDescription.setError("please enter Description");
        } else {
            tilDescription.setError("");
        }
        if (file == null || !file.exists()) {
            Toast.makeText(MediaActivity.this, "please select file", Toast.LENGTH_SHORT).show();
        }

    }
}