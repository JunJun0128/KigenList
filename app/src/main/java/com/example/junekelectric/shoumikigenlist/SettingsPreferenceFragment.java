package com.example.junekelectric.shoumikigenlist;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by junekelectric on 2017/06/09.
 */

public class SettingsPreferenceFragment extends PreferenceFragment {
    //設定画面を表示するクラス
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_settings);
    }
}
