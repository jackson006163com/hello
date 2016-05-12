package com.main.remoteservice;

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
import android.hardware.Camera;


public class IrisRemoteService extends Service implements Camera.PreviewCallback {
/*
    public class IrisRemoteServiceBinder extends IIrisRemoteService.Stub {
        public void test() {
            Log.w("locald","IrisRemoteServiceBinder test   ");
        }
        
        public Bitmap getDisplay() {
            return BitmapFactory.decodeResource(getResources(), R.drawable.z_1_01);
        }
    }*/

    private final IBinder mBinder = null;//new IrisRemoteServiceBinder();
    private Camera mCamera;

    public IBinder onBind(Intent intent) {
        Log.d("locald","IrisRemoteService onBind ..");
        if(mBinder != null) {
            Log.d("locald","IrisRemoteService onBind return binder..");
            return mBinder;
        }
        return null;
    }

    public void onCreate() 
    {
        super.onCreate();
        openCamera();
        Log.w("localdebug", "IrisRemoteService onCreate\n");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.w("localdebug", "IrisRemoteService onCreate\n");
    }

    public void onStart(Intent intent, int startId) 
    {
        super.onStart(intent, startId);
        Log.w("localdebug", "IrisRemoteService onStart\n");
    }

    public int onStartCommand (Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
        //return START_REDELIVER_INTENT;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    private void openCamera() {
        try{
	    mCamera = Camera.open(1);
	} catch(RuntimeException e) {
            Log.d("locald", "locald" + e);
	}
	
	if(mCamera != null) {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);
            parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);
	    parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_AUTO);
            parameters.setExposureCompensation(0);
            parameters.setPictureSize(800, 600);
	    parameters.setJpegQuality(100);
            parameters.setPreviewSize(1280, 720);
            mCamera.setDisplayOrientation(180);
            //mCamera.setParameters(parameters);
        }
    }

    public void onPreviewFrame(byte[] yuvData, Camera camera) {
        Log.d("locald"," remote service onPreviewFrame .. ");
    }
}
