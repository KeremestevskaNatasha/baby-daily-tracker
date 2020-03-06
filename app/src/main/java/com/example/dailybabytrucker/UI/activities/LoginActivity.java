package com.example.dailybabytrucker.UI.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;

import com.example.dailybabytrucker.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final TextInputLayout passwordTextInput = findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = findViewById(R.id.password_edit_text);
        MaterialButton loginButton = findViewById(R.id.login_button);

        sp = getSharedPreferences("login",MODE_PRIVATE);
        if(sp.getBoolean("logged",false)){
            goToMainActivity();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(getString(R.string.bdp_error_password));
                } else {
                    passwordTextInput.setError(null); // Clear the error

                    goToMainActivity();
                    sp.edit().putBoolean("logged",true).apply();
                }
            }
        });// Clear the error once more than 8 characters are typed.

        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isPasswordValid(passwordEditText.getText())) {

                    passwordTextInput.setError(null);  // Clear Error.
                }

                return false;
            }
        });
    }

    private void goToMainActivity() {

        Intent mIntent = new Intent(LoginActivity.this, MainActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        LoginActivity.this.startActivity(mIntent);
    }

    private boolean isPasswordValid(@NonNull Editable text) {

        return text != null && text.length() >= 8;
    }
}

