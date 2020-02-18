package com.example.dailybabytrucker.UI.activities;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.example.dailybabytrucker.R;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private static final String FILE_NAME = "file_lang";
    private static final String KEY_LANG = "key_lang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLanguage();
        setContentView(R.layout.settings_activity);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        TextView indicatorText = (TextView) findViewById(R.id.language_indicator);
//
//        if (getLangCode().contentEquals("en")) {
//            indicatorText.setText("English");
//        } else if (getLangCode().contentEquals("mk")) {
//            indicatorText.setText("Macedonian");
//        }
    }


    private void saveLanguage(String lang) {
        // we can use this method to save language
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LANG, lang);
        editor.apply();
        // we have saved
        // recreate activity after saving to load the new language, this is the same
        // as refreshing activity to load new language
        recreate();
    }

    private void loadLanguage() {
        // we can use this method to load language,
        // this method should be called before setContentView() method of the onCreate method
        Locale locale = new Locale(getLangCode());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }


    private String getLangCode() {
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String langCode = preferences.getString(KEY_LANG, "en");

        // save english 'en' as the default language
        return langCode;
    }



    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }


        //
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_english:
//                saveLanguage("en");
//                break;
//            case R.id.action_macedonian:
//                saveLanguage("mk");
//                break;
    }
}