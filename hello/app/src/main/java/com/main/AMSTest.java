package com.main;

import com.main.TestView;
import com.main.TestListView;
import com.main.record.RecordEngine;
import com.main.fatherchild.Base;
import com.main.fatherchild.TestA;
import com.main.fatherchild.TestB;
import com.main.AMSTest;
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
//import smartisanos.api.SmartisanApi;
import android.app.ActivityManager;
import com.main.javabasic.MyArrayList;

public class AMSTest {
    public void setContext(Context m) {
        mContext = m;
    }
    static public void getRecentTasks(Context m) {
/*
        final ActivityManager am = (ActivityManager) m.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RecentTaskInfo> recentTasks =
                    am.getRecentTasks(-1,
                            ActivityManager.RECENT_WITH_EXCLUDED |
                            ActivityManager.RECENT_IGNORE_UNAVAILABLE |
                            ActivityManager.RECENT_INCLUDE_PROFILES);
*/
    }

    Context mContext;
}
