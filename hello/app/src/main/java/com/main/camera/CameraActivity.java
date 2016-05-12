package com.main.camera;

import com.main.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class CameraActivity extends Activity {
	private CameraView mCameraView = null;
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.camera_main);
    	mCameraView = new CameraView(this, savedInstanceState);
    	((ViewGroup) findViewById(R.id.preview)).addView(mCameraView);
    	
    	getWindow().addFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    
    protected void onResume() {
        super.onResume();

	    WindowManager.LayoutParams layout = getWindow().getAttributes();
		//layout.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_FULL;
		layout.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
	    getWindow().setAttributes(layout); 

        mCameraView.onResume();
    }
    
    protected void onPause() {
    	super.onPause();
    	mCameraView.onPause();
    }
}