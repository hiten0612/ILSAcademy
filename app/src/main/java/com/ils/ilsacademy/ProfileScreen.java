package com.ils.ilsacademy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class ProfileScreen extends AppCompatActivity {
    private Toolbar pfToolbar;
    private ImageView pfLogOut;
    private ImageView terms;
    private ImageView about;
    private ImageView feed;
    private SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        pfToolbar = findViewById(R.id.pfToolbar);

        pfToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());


        pfLogOut = findViewById(R.id.pfLogOut);
        pfLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileScreen.this);
                builder.setMessage("Are You Sure Want to Logout?");
                //builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        sharedPreferenceConfig.clearData();
                        Intent logout = new Intent(ProfileScreen.this, Login.class);
                        logout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(logout);
                        finish();
                    }
                });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });
        terms = findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileScreen.this, ContentActivity.class);
                startActivity(intent);
                finish();
            }
        });
        about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab = new Intent(ProfileScreen.this, ContentActivity.class);
                startActivity(ab);
                finish();
            }
        });
        feed = findViewById(R.id.feed);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedback = new Intent(ProfileScreen.this,FeedBack_Activity.class);
                startActivity(feedback);
                finish();
            }
        });


    }
}