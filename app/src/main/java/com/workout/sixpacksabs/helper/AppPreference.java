package com.workout.sixpacksabs.helper;

import android.content.Context;
import android.content.SharedPreferences;

import static com.workout.sixpacksabs.helper.AppConstant.UNKNOWN_TYPE;


public class AppPreference {

    private static final String PREF_NAME = "com.six.pack.PREF_NAME";

    private static AppPreference sInstance;
    private final SharedPreferences mPref;

    private AppPreference(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }


    public static synchronized AppPreference getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppPreference(context);
        }
        return sInstance;
    }


    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .apply();
    }

    public void setString(String key, String value) {
        mPref.edit()
                .putString(key, value)
                .apply();
    }

    public String getString(String key) {
        return mPref.getString(key, UNKNOWN_TYPE);
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }

    public void setBoolean(String key, boolean value) {
        mPref.edit()
                .putBoolean(key, value)
                .apply();
    }

    public boolean getBoolean(String key) {
        return mPref.getBoolean(key, false);
    }

}
