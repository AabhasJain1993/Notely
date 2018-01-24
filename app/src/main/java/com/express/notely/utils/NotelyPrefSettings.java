package com.express.notely.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;

/**
 * Created by root on 23/1/18.
 */

public class NotelyPrefSettings {
    private static final String NOTELY_PREF = "notelypref";
    private static NotelyPrefSettings ourInstance = new NotelyPrefSettings();
    private final Object object = new Object();
    private SharedPreferences sharedPreferences;

    private NotelyPrefSettings(){
    }

    public static void init(Context context){
        ourInstance.sharedPreferences = context.getSharedPreferences(NOTELY_PREF, context.MODE_PRIVATE);
    }

    public static NotelyPrefSettings getInstance(){
        return ourInstance;
    }

    public void setFilterMode() {
        synchronized (object){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("filtermode", true);
            editor.apply();
        }
    }

    public boolean getFilterMode(){
        synchronized (object){
            return sharedPreferences.getBoolean("filtermode", false);
        }
    }

}
