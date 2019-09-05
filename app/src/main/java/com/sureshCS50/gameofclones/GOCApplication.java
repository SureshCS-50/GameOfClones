package com.sureshCS50.gameofclones;

import android.app.Application;

import com.sureshCS50.gameofclones.data.db.GOCDatabase;

public class GOCApplication extends Application {

    private static GOCDatabase mGOCDatabase;

    private static final String TAG = "GOCApplication";

    public static GOCDatabase getDatabase() {
        return mGOCDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mGOCDatabase = GOCDatabase.getInstance(this);
//        loadDataFromAssets();
    }

}
