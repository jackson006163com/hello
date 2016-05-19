package com.main;

import android.util.Log;

import net.wequick.small.Small;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Required
        Small.preSetUp(this);
    }
}
