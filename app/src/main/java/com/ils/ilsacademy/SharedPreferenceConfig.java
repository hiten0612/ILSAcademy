package com.ils.ilsacademy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {

    private final SharedPreferences sharedPreferences;
    private final Context context;

    public SharedPreferenceConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_shared_preference), Context.MODE_PRIVATE);
    }

    public void setLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", status);
        editor.apply();
    }

    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    public void saveUserData(String username,String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    public String getUserName() {
        return sharedPreferences.getString("username", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }

    @SuppressLint("CommitPrefEdits")
    public void clearData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
