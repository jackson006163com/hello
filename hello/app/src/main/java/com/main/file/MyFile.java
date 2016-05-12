package com.main.file;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
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
import android.app.ActivityManager;
import com.main.javabasic.MyArrayList;
import java.lang.Integer;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MyFile {

    public static void test() {
        Log.w("locald", "MyFile test \n");
 
    }

    public static void fillFile(byte[] buf) {
        File saveFile =  new File("/sdcard/file_test.txt");
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

    public static void testFiles() {
        File saveFile =  new File("/sdcard/file_test.txt");
        FileInputStream instream;
        String str = null;
        try
        {
            saveFile.createNewFile();
            instream =  new FileInputStream(saveFile);
            byte[] buf = new byte[instream.available()];
            instream.read(buf);
            instream.close();
            str = new String(buf);
            Log.w("localdebug", "str is " + str);
        }
        catch(FileNotFoundException e)
        {
            Log.w("localdebug", "testFiles FileNotFoundException  \n");
        }
        catch(IOException e)
        {
            Log.w("localdebug", "testFiles IOException : \n"+e.getMessage());
        }
        Log.w("localdebug", "str is is " + str);
       
        //Toast.makeText(this, str, 1).show();

        String str2 = new String("abc");

        if(str.equals("abc") == true)
        {
            Log.w("localdebug", "str.equals abc == true");
        }
        else
        {
            Log.w("localdebug", "str.equals abc != true");
        }

        if(str.charAt(0) == 'b')
        {
            Log.w("localdebug", "str.equals a == true");
        }
    }

    public void readwriteBitmapFile() {
        File saveFile =  new File("/sdcard/test.png");
        FileInputStream instream;
        byte[] buf = null;
        try
        {
            saveFile.createNewFile();
            instream =  new FileInputStream(saveFile);
            buf = new byte[instream.available()];
            instream.read(buf);
            instream.close();
        }
        catch(FileNotFoundException e)
        {
            Log.w("localdebug", "readwriteBitmapFile FileNotFoundException  \n");
        }
        catch(IOException e)
        {
            Log.w("localdebug", "readwriteBitmapFile IOException : \n"+e.getMessage());
        }

        File saveBitmapFile =  new File("/sdcard/test1.png");
        OutputStream out = null;
        try {
            saveBitmapFile.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(saveBitmapFile));
            out.write(buf, 0, buf.length);
            out.flush();
            out.close();
        }
        catch(FileNotFoundException e) {
            Log.w("localdebug", "readwriteBitmapFile FileNotFoundException  \n");
        }
        catch(IOException e) {
            Log.w("localdebug", "readwriteBitmapFile IOException : \n"+e.getMessage());
        }
    }
}
