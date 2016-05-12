package com.main;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.Resources;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.util.Log;
import android.view.View;
import android.view.KeyEvent;
import android.view.Window;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.view.Display;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.DropBoxManager;
import dalvik.system.PathClassLoader;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import android.os.Parcel;
import java.lang.System;
import android.content.res.Resources;
import android.widget.SeekBar;
import java.lang.StackTraceElement;
import android.graphics.PixelFormat;
import android.content.res.Configuration;
import android.app.ActivityManager;
import com.main.javabasic.MyArrayList;

public class ProviderTest {
    static public void setContext(Context m) {
        mContext = m;
    }

    static public void getAllProviders() {
        PackageManager pm = mContext.getPackageManager();
        List<ProviderInfo> providers = null;
        try
        {
            String s = Util.makeBigString();
            providers = pm.queryContentProviders(s, 0, PackageManager.GET_META_DATA);
        }
        catch(RuntimeException e)
        {
            Throwable cause = e.getCause();
            //if(cause instanceof TransactionTooLargeException)
            //{
            //    Log.d("localdebug","providers TransactionTooLargeException");
            //    return;
            //}
            Log.d("localdebug","providers RuntimeException");
            return;
        }

        if(providers == null)
        {
            Log.d("localdebug","providers is null");
            return;
        }

        for (ProviderInfo provider : providers) 
        {
            Log.d("localdebug", "getAllProviders: " + provider.toString());
        }
    }

    static public void testCalender() {
        ContentResolver resolver = mContext.getContentResolver();
        Cursor cursor = null;
        Uri CONTENT_CALENDAR_MATE_DATA =
            Uri.parse("content://" + CalendarContract.AUTHORITY + "/calendar_meta_data");
        String[] PROJECTION = {
//         CalendarMetaData.MIN_INSTANCE,
//         CalendarMetaData.MAX_INSTANCE
        		};
        cursor = resolver.query(CONTENT_CALENDAR_MATE_DATA, PROJECTION, null, null, null);
        if(cursor == null) {
            Log.d("locald", "testCalender cursor is null ");
        }
    }

    static Context mContext;
}
