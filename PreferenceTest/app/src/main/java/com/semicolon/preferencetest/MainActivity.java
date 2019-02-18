package com.semicolon.preferencetest;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //xml을 뷰로 지정
        addPreferencesFromResource(R.xml.preferences);


    /*==============값 변경 감지==============*/
        SharedPreferences prefs;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs
                .registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
                    public void onSharedPreferenceChanged(SharedPreferences sp, String key) {
                        Log.d("tag","클릭된 Preference의 key는 "+key);
                    }
                });
    /*==============값 변경 감지==============*/
    }


    /*==============Preference 클릭 감지==============*/
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        String key = preference.getKey();
        Log.d("tag","클릭된 Preference의 key는 "+key);
        return false;
    }
    /*==============Preference 클릭 감지==============*/
}
