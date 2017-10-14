package com.meeshoassignment.data.prefs;

import android.content.SharedPreferences;


import com.meeshoassignment.app.AppConstants;

import javax.inject.Inject;

/**
 * Created by root on 9/11/17.
 */

public class PrefsManager implements AppConstants {

    private SharedPreferences sharedPreferences;

    @Inject
    public PrefsManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String getOwnerName() {
        return sharedPreferences.getString(OWNER_NAME, null);
    }

    public void setOwnerName(String ownerName) {
        updateStringSharedPrefs(OWNER_NAME, ownerName);
    }

    public String getRepoName() {
        return sharedPreferences.getString(REPO_NAME, null);
    }

    public void setRepoName(String repoName) {
        updateStringSharedPrefs(REPO_NAME, repoName);
    }

    private void updateStringSharedPrefs(String key, String val) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, val);
        editor.apply(); // commit changes
    }

    private void updateBooelanSharedPrefs(String key, Boolean val) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, val);
        editor.apply();
    }

    private void updateLongSharedPrefs(String key, Long val) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, val);
        editor.apply();
    }
}
