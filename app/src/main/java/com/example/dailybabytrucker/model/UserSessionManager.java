package com.example.dailybabytrucker.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.dailybabytrucker.UI.activities.LoginActivity;

import static android.content.Context.MODE_PRIVATE;

public class UserSessionManager {

    // Shared Preferences reference
    SharedPreferences sp;

    // Editor reference for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;


    // Constructor
    public UserSessionManager(Context context){
        this._context = context;
        sp = _context.getSharedPreferences("login",MODE_PRIVATE);
        editor = sp.edit();
    }



     //Clear session details

    public void logoutUser(){

        // Clearing all user data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Login Activity
        Intent i = new Intent(_context, LoginActivity.class);

        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }
}
