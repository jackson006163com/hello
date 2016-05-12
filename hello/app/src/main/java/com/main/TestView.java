package com.main;

import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class TestView extends View 
{
    private Context mContext;
    private TestButton mTestButton;

    public TestView(Context context) {
        super(context);
        mContext = context;
        mTestButton = new TestButton(context);
    }

    public TestView(Context context, AttributeSet attrs) 
    {
        super(context,attrs);
        mContext = context;
    }

    public boolean onTouchEvent (MotionEvent event)
    {
        Log.w("localdebug", "test view onTouchEvent\n");
        return super.onTouchEvent(event);
    }

}
