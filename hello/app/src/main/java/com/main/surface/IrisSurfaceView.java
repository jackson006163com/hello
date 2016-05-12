package com.main.surface;

import com.main.R;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Binder;

public class IrisSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder mHolder;
    private Context mContext;
    private Paint mPaint;
    private Bitmap mBitmap;
    private IBinder mService;

    public IrisSurfaceView(Context context) {
        super(context);
        mContext = context;
        mHolder = getHolder();
        mHolder.addCallback(this);
        //mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.z_1_01);
        mBitmap = BitmapFactory.decodeFile("/sdcard/test1.png");
    }

    public void setService(IBinder binder) {
        mService = binder;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        mHolder = holder;
        //mBitmap = mService.getDisplay();
        new Thread(this).start();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public void run() {
        while(true) {
            synchronized (mHolder) {
                Canvas canvas = null;
	        try {
	            canvas = mHolder.lockCanvas();
                    if(canvas != null) {
                        Log.d("locald","IrisSurfaceView run draw ...");
                        //mPaint.setColor(Color.WHITE);
		        //canvas.drawText("Hello Hello!!!!!!!!", 0, 500, mPaint);
                        if(mBitmap != null) {
                            Log.d("locald","IrisSurfaceView run draw bit map");
                            canvas.drawBitmap(mBitmap, 0, 0, mPaint);
                        }
                    }
	        } catch (Exception e) {
	        } finally {
                    if(canvas != null) {
	                mHolder.unlockCanvasAndPost(canvas);
                    }
	        }
	    }
	    try {
	        Thread.sleep(40);
	    } catch (InterruptedException e) {
                e.printStackTrace();
	    }
        }
    }
}
