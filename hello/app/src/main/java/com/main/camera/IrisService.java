package com.main.camera;

import android.app.Service;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.os.IBinder;
import android.os.Binder;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import com.main.R;

public class IrisService extends Service {

    public class IrisServiceBinder extends Binder {
        public void test() {
            Log.w("locald","IrisServiceBinder test   ");
        }
        
        public Bitmap getDisplay() {
            return BitmapFactory.decodeResource(getResources(), R.drawable.z_1_01);
        }
    }

    private final IBinder mBinder = new IrisServiceBinder();

    public IBinder onBind(Intent intent) {
        Log.d("locald","IrisService onBind ..");
        if(mBinder != null) {
            Log.d("locald","IrisService onBind return binder..");
            return mBinder;
        }
        return null;
    }

    public void onCreate() 
    {
        super.onCreate();
        Log.w("localdebug", "IrisService onCreate\n");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.w("localdebug", "IrisService onCreate\n");
    }

    public void onStart(Intent intent, int startId) 
    {
        super.onStart(intent, startId);
        Log.w("localdebug", "IrisService onStart\n");
    }

    public int onStartCommand (Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
        //return START_REDELIVER_INTENT;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
