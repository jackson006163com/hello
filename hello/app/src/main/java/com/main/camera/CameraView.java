package com.main.camera;

import java.io.IOException;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.util.Log;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
	private Camera mCamera = null;
	private SurfaceHolder mHolder = null;
	private SurfaceTexture mst;
	
	CameraView(Context context) {
		this(context, null);
	}

	CameraView(Context context, Bundle savedInstanceState) {
		super(context);
		mHolder = getHolder();
		mHolder.addCallback(this);
		//mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS); 
		mst=new SurfaceTexture(0);
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		openCamera();
		//setWillNotDraw(false);
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		
	}
	
	public void onResume() {
		openCamera();
	}
	
	public void onPause() {
		closeCamera();
	}
	
	public void onDraw(Canvas canvas) {
	    super.onDraw(canvas);	
	}
	
	private void openCamera() {
	    try{
		    mCamera = Camera.open(1);
	    }
		catch(RuntimeException e) {
			Log.d("locald", "locald" + e);
		}
	    
		try {
			if(mHolder != null) {
			    mCamera.setPreviewDisplay(mHolder);
				//mCamera.setPreviewTexture(mst);
			}
			else {
				Log.d("locald","mHolder is null");
			}
		}
		catch(IOException e) {
			Log.d("locald", "locald" + e);
		}
		initCamera();
		CameraDumper.dump(mCamera.getParameters());
		mCamera.startPreview();
	}
	
	private void closeCamera() {
		mCamera.stopPreview();
		mCamera.release();
	}
	
	private void initCamera() {
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
}