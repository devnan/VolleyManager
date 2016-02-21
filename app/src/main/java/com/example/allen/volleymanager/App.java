package com.example.allen.volleymanager;

import android.app.Application;
import android.content.Context;

/**
 * Created by Allen Lin on 2016/02/17.
 */
public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }

}

