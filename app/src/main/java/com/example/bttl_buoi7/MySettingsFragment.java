package com.example.bttl_buoi7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

public class MySettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences (Bundle savedInstanceState, String rootKey){
        setPreferencesFromResource(R.xml.preferences, rootKey);
        SwitchPreference saved = (SwitchPreference) findPreference("remember_choice");
        saved.setOnPreferenceChangeListener(
                new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                        saved.setChecked((Boolean)newValue);
                        System.out.println("Save choice: "+(Boolean)newValue);
                        return true;
                    }
                }
        );
    }
}
