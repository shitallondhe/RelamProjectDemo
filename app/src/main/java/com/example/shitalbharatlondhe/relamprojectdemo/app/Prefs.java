package com.example.shitalbharatlondhe.relamprojectdemo.app;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static final String PREFS_NAME = "prefs";
    private static final String PRE_LOAD = "preLoad";
    private static Prefs instance;
    private final SharedPreferences sharedPreferences;

    public Prefs(Context context) {
        this.sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
    }

    public static Prefs with(Context context) {
        if (instance == null) {
            instance = new Prefs(context);
        }
        return instance;
    }

    public void setPreLoad(boolean totalTime) {
        this.sharedPreferences.edit().putBoolean(PRE_LOAD, totalTime).apply();
    }

    public boolean getPreLoad() {
        return this.sharedPreferences.getBoolean(PRE_LOAD, false);
    }
}
