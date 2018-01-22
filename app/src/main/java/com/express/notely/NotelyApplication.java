package com.express.notely;

import android.app.Application;

import com.express.notely.db.AppDataBase;
import com.express.notely.db.DatabaseManager;

/**
 * Created by root on 21/1/18.
 */

public class NotelyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        DatabaseManager.initializeInstance(AppDataBase.getInstance(getApplicationContext()));
        // Log.d("Debug Database Address" ,DebugDB.getAddressLog());

    }


}
