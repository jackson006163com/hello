package com.main;
import  android.app.Service;
import android.os.Bundle;
import android.content.res.Resources;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {

    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    public void onCreate() 
    {
        Log.w("localdebug", "TestService onCreate\n");
    }

    public void onStart(Intent intent, int startId) 
    {
        //while(true)
        {
            Log.w("localdebug", "TestService onStart\n");
        }
    }

    public int onStartCommand (Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
        //return START_REDELIVER_INTENT;
    }
}
