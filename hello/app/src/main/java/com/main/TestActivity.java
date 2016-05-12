package com.main;

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

public final class TestActivity extends Activity
{
    private TestView mTestView;
    private Window mWindow;
    private View mView;

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        init();
        initRegReceiver();
    }

    private BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                Log.d("locald", " mHomeKeyEventReceiver onReceive ");
                Toast.makeText(getApplicationContext(), "home", 1).show();
            }
        }
    };

    public void initRegReceiver() {
        registerReceiver(mHomeKeyEventReceiver, new IntentFilter(  
                Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
    }

    public void init() {
        //setContentView(R.layout.testview);
        //mTestView = new TestView(this);
        //setContentView(mTestView);
        mWindow = getWindow();
        mView = mWindow.getDecorView();

/*        
        Drawable ddd = mView.getBackground();
        if(ddd instanceof AnimationDrawable) {
            Log.d("locald", " ddd instanceof AnimationDrawable");
        }

        if(ddd instanceof BitmapDrawable) {
            Log.d("locald", " ddd instanceof BitmapDrawable");
        }

        if(ddd instanceof ColorDrawable) {
            Log.d("locald", " ddd instanceof ColorDrawable");
        }

        if(ddd instanceof DrawableContainer) {
            Log.d("locald", " ddd instanceof DrawableContainer");
        }

        if(ddd instanceof GradientDrawable) {
            Log.d("locald", " ddd instanceof GradientDrawable");
        }

        if(ddd instanceof NinePatchDrawable) {
            Log.d("locald", " ddd instanceof NinePatchDrawable");
        }

        if(ddd instanceof PictureDrawable) {
            Log.d("locald", " ddd instanceof PictureDrawable");
        }

        if(ddd instanceof ShapeDrawable) {
            Log.d("locald", " ddd instanceof ShapeDrawable");
        }

        if(ddd instanceof TransitionDrawable) {
            Log.d("locald", " ddd instanceof TransitionDrawable");
        }


        if(ddd.getOpacity() == PixelFormat.OPAQUE)
        {
            Log.d("locald", "mView.getBackground().getOpacity() == PixelFormat.OPAQUE");
        }
        Log.d("locald","getOpacity  " + mView.getBackground().getOpacity());

        Paint mFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Log.d("locald","FillPaint get color  " + mFillPaint.getColor());
        if(((mFillPaint.getColor() >> 24) & 0xff) == 0xff) {
            Log.d("locald","isOpaque is true");
        }
        else {
            Log.d("locald","isOpaque is false ");
        }

        Resources.Theme th = getTheme();
*/
        //String themeName = getResources.getString(th.);
    }

    public TestView getTestView()
    {
        return mTestView;
    }
}
