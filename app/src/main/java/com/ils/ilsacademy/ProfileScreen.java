package com.ils.ilsacademy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileScreen extends AppCompatActivity {
    private Button pfLogOut;
    private Toolbar pfToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

    

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
                                Intent logout = new Intent(ProfileScreen.this,Login.class);
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
    }

}