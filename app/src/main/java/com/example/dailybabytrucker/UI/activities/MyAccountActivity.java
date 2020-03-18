package com.example.dailybabytrucker.UI.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import android.os.Bundle;

import com.example.dailybabytrucker.R;
import com.example.dailybabytrucker.model.UserSessionManager;

public class MyAccountActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        getSupportFragmentManager();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.my_account, new MyAccountFragment())
                .commit();
    }

    public  static class MyAccountFragment extends PreferenceFragmentCompat {

        UserSessionManager session;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.my_account_preferences, rootKey);

            // Session class instance
            session = new UserSessionManager(this.getContext());

            Preference preference = (Preference) findPreference("key_logOut");
            preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    session.logoutUser();
                    return true;
                }
            });

        }


    }
}
