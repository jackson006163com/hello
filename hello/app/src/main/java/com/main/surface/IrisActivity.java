package com.main.surface;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.graphics.PixelFormat;
import android.view.Window;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.Paint;
import android.content.res.Resources;
import android.content.BroadcastReceiver;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import com.main.camera.IrisService;
import com.main.camera.IrisService.IrisServiceBinder;
import android.content.ComponentName;
import android.os.IBinder;
import com.main.surface.IrisSurfaceView;

public class IrisActivity extends Activity
{
    private ServiceConnection sc;
    private IrisServiceBinder mIrisService;
    private IrisSurfaceView mView;

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        sc = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("locald","IrisActivity onServiceConnected...");
                mIrisService = (IrisServiceBinder) service;
                if(mIrisService == null) {
                    Log.d("locald","mIrisService is null ... ");
                } else {
                    Log.d("locald","IrisActivity call test ...");
                    mIrisService.test();
                }
            }

            public void onServiceDisconnected(ComponentName name) {
                Log.d("locald","IrisActivity onServiceDisconnected...");
                mIrisService = null;
            }
        };
        //Intent intent = new Intent();
        //intent.setAction("com.main.camera.IrisService");
        //bindService(intent, sc, Context.BIND_AUTO_CREATE);
        mView = new IrisSurfaceView(this);
        setContentView(mView);
    }

    protected void onResume() {
        super.onResume();
        Log.d("locald","IrisActivity onResume ");
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }
}
