package com.main;

import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.view.accessibility.AccessibilityNodeInfo;
import android.graphics.Rect;

public class TestButton extends Button 
{
    private Context mContext;

    public TestButton(Context context) {
        super(context);
        mContext = context;
    }

    public TestButton(Context context, AttributeSet attrs) 
    {
        super(context,attrs);
        mContext = context;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) 
    {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setParent(((TestActivity)mContext).getTestView());
        info.setEnabled(true);
        info.setBoundsInParent(new Rect(0,0,100,100));
    }

    public boolean onTouchEvent (MotionEvent event)
    {
        Log.w("localdebug", "TestButton onTouchEvent\n");
        return super.onTouchEvent(event);
    }

}
