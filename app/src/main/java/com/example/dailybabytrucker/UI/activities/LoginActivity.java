package com.example.dailybabytrucker.UI.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.helpers.InputValidation;
import com.example.dailybabytrucker.sql.DatabaseHelper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;
    SharedPreferences sp;
    MaterialButton loginButton;
    TextView tv_signUp;
    EditText email_edit_text;
    EditText password_edit_text;
    TextInputLayout passwordTextInput;
    TextInputEditText passwordEditText;
    InputValidation inputValidation;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);

        passwordTextInput = findViewById(R.id.password_text_input);
        passwordEditText = findViewById(R.id.password_edit_text);
        email_edit_text = findViewById(R.id.email_edit_text);
        password_edit_text = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
        tv_signUp = findViewById(R.id.tv_signUp);

        sp = getSharedPreferences("login", MODE_PRIVATE);
        if (sp.getBoolean("logged", false)) {
            goToMainActivity();
        }

        initListeners();

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

    private void initListeners() {
        loginButton.setOnClickListener(this);
        tv_signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                verifyFromSQLite();
                break;

            case R.id.tv_signUp:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;

        }
    }

    private boolean isPasswordValid(@NonNull Editable text) {

        return text != null && text.length() >= 8;
    }

    private void verifyFromSQLite() {

        if (!inputValidation.isEditTextFilled(email_edit_text, getString(R.string.error_message_email))) {
            return;
        }

        if (!inputValidation.isEditTextFilled(password_edit_text, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isEditTextEmail(email_edit_text, getString(R.string.error_message_email))) {
            return;
        }

        if (!isPasswordValid(passwordEditText.getText())) {
            passwordTextInput.setError(getString(R.string.bdp_error_password));
        } else {
            passwordTextInput.setError(null); // Clear the error
            goToMainActivity();
            sp.edit().putBoolean("logged", true).apply();


            if (databaseHelper.checkUser(email_edit_text.getText().toString().trim()
                    , password_edit_text.getText().toString().trim())) {


            } else {
                //  Toast.makeText(getApplicationContext(), "Wrong Email or Password ",Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void goToMainActivity() {
        Intent mIntent = new Intent(LoginActivity.this, MainActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        emptyInputEditText();
        LoginActivity.this.startActivity(mIntent);
    }

    // empty the editText fields after clicking on register or login button ..
    private void emptyInputEditText() {
        email_edit_text.setText(null);
        password_edit_text.setText(null);
    }
}
