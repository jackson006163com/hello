package com.main.camera;

import android.hardware.Camera.Parameters;
import android.hardware.Camera;
import android.util.Log;
import java.lang.StringBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class CameraDumper {
    public static void dump(Camera.Parameters p) {
	    Log.d("locald","CameraDumper dump ....");
	    if(p == null) {
	    	Log.d("locald","CameraDumper Parameters is null");
	    	return;
	    }
	    StringBuilder sb = new StringBuilder();
	    sb.append("Main KT" + "\n");
	    sb.append("getAntibanding: " + p.getAntibanding() + "\n");
	    sb.append("getAutoExposureLock: " + p.getAutoExposureLock() + "\n");
	    sb.append("getAutoWhiteBalanceLock: " + p.getAutoWhiteBalanceLock() + "\n");
	    sb.append("getColorEffect: " + p.getColorEffect() + "\n");
	    sb.append("getExposureCompensation: " + p.getExposureCompensation() + "\n");
	    sb.append("getExposureCompensationStep: " + p.getExposureCompensationStep() + "\n");
	    sb.append("getFlashMode: " + p.getFlashMode() + "\n");
	    sb.append("getFocalLength: " + p.getFocalLength() + "\n");
/*
	    sb.append("getFocusAreas:" + "\n");
	    List<Camera.Area> areas = p.getFocusAreas();
	    if(areas != null) {
	        for(int index = 0; index < areas.size(); index++) {
	    	    sb.append(areas.get(index).weight + " " + areas.get(index).rect.left
	    			+ " " + areas.get(index).rect.top
	    			+ " " + areas.get(index).rect.right
	    			+ " " + areas.get(index).rect.bottom
	    			+ "\n");
	        }
	    }
*/
	    //getFocusDistances(float[] output)
	    sb.append("getFocusDistances:" + "\n");
	    float[] focusDistances = new float[3];
	    p.getFocusDistances(focusDistances);
	    sb.append(focusDistances[0] + " " + focusDistances[1] + " " + focusDistances[2] + "\n");
	    
	    sb.append("getFocusMode: " + p.getFocusMode() + "\n");
	    sb.append("getHorizontalViewAngle: " + p.getHorizontalViewAngle() + "\n");
	    sb.append("getJpegQuality: " + p.getJpegQuality() + "\n");
	    sb.append("getJpegThumbnailQuality: " + p.getJpegThumbnailQuality() + "\n");

	    Camera.Size jpegThumbnailSize = p.getJpegThumbnailSize();
	    sb.append("getJpegThumbnailSize: " + jpegThumbnailSize.width + " " + jpegThumbnailSize.height + "\n");
	    
	    sb.append("getMaxExposureCompensation: " + p.getMaxExposureCompensation() + "\n");
	    sb.append("getMaxNumDetectedFaces: " + p.getMaxNumDetectedFaces() + "\n");
	    sb.append("getMaxNumFocusAreas: " + p.getMaxNumFocusAreas() + "\n");
	    sb.append("getMaxNumMeteringAreas: " + p.getMaxNumMeteringAreas() + "\n");
	    sb.append("getMaxZoom: " + p.getMaxZoom() + "\n");
/*
	    sb.append("getMeteringAreas:" + "\n");
	    List<Camera.Area> meteringAreas = p.getMeteringAreas();
	    if(meteringAreas != null) {
	        for(int index = 0; index < meteringAreas.size(); index++) {
	    	    sb.append(meteringAreas.get(index).weight + " " + meteringAreas.get(index).rect.left
	    			+ " " + meteringAreas.get(index).rect.top
	    			+ " " + meteringAreas.get(index).rect.right
	    			+ " " + meteringAreas.get(index).rect.bottom
	    			+ "\n");
	        }
	    }
*/
	    sb.append("getMinExposureCompensation: " + p.getMinExposureCompensation() + "\n");
	    sb.append("getPictureFormat: " + p.getPictureFormat() + "\n");
	    Camera.Size pictureSize = p.getPictureSize();
	    sb.append("getPictureSize: " + pictureSize.width + " " + pictureSize.height + "\n");

	    Camera.Size preferredPreviewSizeForVideo = p.getPreferredPreviewSizeForVideo();
	    sb.append("getPreferredPreviewSizeForVideo: " + preferredPreviewSizeForVideo.width + " " + preferredPreviewSizeForVideo.height + "\n");
	    
	    sb.append("getPreviewFormat: " + p.getPreviewFormat() + "\n");
	    sb.append("getPreviewFpsRange:" + "\n");
	    int[] r = new int[2];
	    p.getPreviewFpsRange(r);
	    sb.append(r[0] + " " + r[1] + "\n");
	    
	    sb.append("getPreviewFrameRate: " + p.getPreviewFrameRate() + "\n");
	    
	    Camera.Size previewSize = p.getPreviewSize();
	    sb.append("getPreviewSize: " + previewSize.width + " " + previewSize.height + "\n");
	    
	    sb.append("getSceneMode: " + p.getSceneMode() + "\n");
    	sb.append("getSupportedAntibanding:" + "\n");
	    List<String> supportedAntibanding = p.getSupportedAntibanding();
	    if(supportedAntibanding != null) {
	        for(int index = 0; index < supportedAntibanding.size(); index++) {
	    	    sb.append(supportedAntibanding.get(index));
	    	    sb.append("\n");
	        }
	    }
    	sb.append("getSupportedColorEffects:" + "\n");
	    List<String> supportedColorEffects = p.getSupportedColorEffects();
	    if(supportedColorEffects != null) {
	        for(int index = 0; index < supportedColorEffects.size(); index++) {
	    	    sb.append(supportedColorEffects.get(index));
	    	    sb.append("\n");
	        }
	    }
	    //getSupportedFlashModes()
	    //getSupportedFocusModes()
	    //getSupportedJpegThumbnailSizes()
	    //getSupportedPictureFormats()
	    //getSupportedPictureSizes()
	    //getSupportedPreviewFormats()
	    //getSupportedPreviewFpsRange()
	    //getSupportedPreviewFrameRates()
    	sb.append("getSupportedPreviewSizes:" + "\n");
	    List<Camera.Size> sizes = p.getSupportedPreviewSizes();
	    if(sizes != null) {
	        for(int index = 0; index < sizes.size(); index++) {
	    	    sb.append(sizes.get(index).width);
	    	    sb.append(" ");
	    	    sb.append(sizes.get(index).height);
	    	    sb.append("\n");
	        }
	    }
	    //getSupportedSceneModes()
	    //getSupportedVideoSizes()
	    //getSupportedWhiteBalance()
	    sb.append("getVerticalViewAngle: " + p.getVerticalViewAngle() + "\n");
	    sb.append("getVideoStabilization: " + p.getVideoStabilization() + "\n");
	    sb.append("getWhiteBalance: " + p.getWhiteBalance() + "\n");
	    sb.append("getZoom: " + p.getZoom() + "\n");
	    
	    sb.append("getZoomRatios:" + "\n");
	    List<Integer> zoomRatios = p.getZoomRatios();
	    if(zoomRatios != null) {
	        for(int index = 0; index < zoomRatios.size(); index++) {
	    	    sb.append(zoomRatios.get(index));
	    	    sb.append("\n");
	        }
	    }
	    
	    sb.append("isAutoExposureLockSupported: " + p.isAutoExposureLockSupported() + "\n");
	    sb.append("isAutoWhiteBalanceLockSupported: " + p.isAutoWhiteBalanceLockSupported() + "\n");
	    sb.append("isSmoothZoomSupported: " + p.isSmoothZoomSupported() + "\n");
	    sb.append("isVideoSnapshotSupported: " + p.isVideoSnapshotSupported() + "\n");
	    sb.append("isVideoStabilizationSupported: " + p.isVideoStabilizationSupported() + "\n");
	    sb.append("isZoomSupported: " + p.isZoomSupported() + "\n");

	    String s = sb.toString();
	    
	    byte[] buf = s.getBytes();
        File saveFile =  new File("/sdcard/file_test_main.txt");
        OutputStream out = null;
        try {
            saveFile.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(buf, 0, buf.length);
            out.flush();
            out.close();
        }
        catch(FileNotFoundException e) {
            Log.w("localdebug", "testFiles FileNotFoundException  \n");
        }
        catch(IOException e) {
            Log.w("localdebug", "testFiles IOException : \n"+e.getMessage());
        }
	}
}