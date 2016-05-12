package com.main;

import com.main.TestView;
import com.main.TestListView;
import com.main.record.RecordEngine;
import com.main.fatherchild.Base;
import com.main.fatherchild.TestA;
import com.main.fatherchild.TestB;
import com.main.AMSTest;
import com.main.file.MyFile;
import com.main.javabasic.MyArrayList;
import com.main.camera.CameraActivity;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//import android.util.ArrayMap;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.Resources;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import android.os.TransactionTooLargeException;
//import android.hardware.display.DisplayManagerGlobal;
import android.view.Display;
//import android.hardware.display.DisplayManager;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;
//import android.provider.CalendarContract.CalendarMetaData;	
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.DropBoxManager;
import dalvik.system.PathClassLoader;
//import com.google.android.collect.Maps;
import android.os.Parcel;
import java.lang.System;
//import android.os.UserManager;
import android.content.res.Resources;
import android.widget.SeekBar;
import java.lang.StackTraceElement;
import android.graphics.PixelFormat;
import android.content.res.Configuration;
import android.app.ActivityManager;
import java.lang.Integer;
//import android.os.SystemProperties;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
import java.lang.StringBuilder;
import android.content.res.Configuration;
import android.os.IBinder;
import com.main.surface.IrisActivity;
import android.content.ContextWrapper;
import java.lang.reflect.Method;
import dalvik.system.DexClassLoader;

public class KTMain extends Activity {
    
    private Button mANRKeyTimeoutButton;
    private Button mTestButton;
    private Button mStartServiceButton;
    private Button mTestViewButton;
    private Button mTestActivityButton;
    private CheckBox mRecordStart;

    private Window mWindow;
    private View mView;

    private SeekBar stepSeeker;

    private int[] t;

    private RecordEngine mRecord = new RecordEngine();

    //public static final int Smartisanos_Resolver = com.android.internal.R.style.Theme_Smartisanos_Resolver;
    //public static final int Smartisanos_Resolver1 = android.R.Theme_Smartisanos_Resolver;

    public native void testJNI();

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mANRKeyTimeoutButton = (Button) findViewById(R.id.ANRKeyTimeoutButton);
        mTestButton = (Button) findViewById(R.id.TestButton);
        mStartServiceButton = (Button) findViewById(R.id.StartServiceButton);
        mTestViewButton = (Button) findViewById(R.id.TestViewButton);
        mTestActivityButton = (Button) findViewById(R.id.TestActivityButton);
        mRecordStart = (CheckBox) findViewById(R.id.StartRecord);
        
        mWindow = getWindow();
        mView = mWindow.getDecorView();

        mRecord = new RecordEngine();

        mTestButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Log.w("localdebug", "mTestButton pressed\n");
                test();
            }
        });




        mANRKeyTimeoutButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Log.w("localdebug", "mANRKeyTimeoutButton pressed\n");
                test1();
                //showTestListView();
                //while(true){}
                //stopRecord();
            }
        });


        mStartServiceButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                 //Intent intent = new Intent("com.main.TestService");
                 //startService(intent);
            }
        });

        mTestViewButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                 Log.w("localdebug", "TestViewButton pressed\n");
                 //showTestView();
                 //  doMemoryTest();
                 //  runThread();
            }
        });

//        mTestActivityButton.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
                // launchTestActivity();
                // Log.w("localdebug", "TestActivityButton pressed\n");
//            }
//        });

/*
        mView.setOnTouchListener(
        new OnTouchListener()
        {
            public boolean onTouch(View view, MotionEvent event) 
            { 
                Log.w("localdebug", "activity OnTouchListener x " + event.getX() + " y " + event.getY()
                                              + "action" + event.getAction() + "\n");
                return false;
            }
        });
*/
        mRecordStart.setOnCheckedChangeListener(
        new OnCheckedChangeListener() 
        {
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
            {
                if(arg1 == true)
                {
                    startRecord();
                }
                else
                {
                    stopRecord();
                }    
            }
        });

        stepSeeker = (SeekBar) findViewById(R.id.step_seekbar);
        stepSeeker.setProgress(0);
    }
/*
    public boolean onTouchEvent(MotionEvent event) {
        boolean r = super.onTouchEvent(event);
        return r;
    }
*/
    public void launchTestActivity()
    {
         Intent i = new Intent(this, TestActivity.class);
         startActivity(i);
    }

    public void showTestView()
    {
        TestView view = (TestView)findViewById(R.id.TestViewButton);
        view.setVisibility(View.VISIBLE);
    }

    public void showTestListView()
    {
         Intent i = new Intent(this, TestListView.class);
         startActivity(i);
    }

    public void doOutOfMemoryError()
    {
        throw new OutOfMemoryError();
    }

    public void doMemoryTest()
    {
        int j = 0;
        while(true)
        {
            j++;
            Log.w("localdebug","the j number is "+j);
            int[] i = new int[10000];
        }
    }

    public boolean onKeyDown (int keyCode, KeyEvent event)
    {
        super.onKeyDown(keyCode,event);
        Log.w("localdebug", "activity onKeyDown\n");
        return true;
    }

    public void runThread()
    {
        Thread thr = new Thread()
        {
            public void run() 
            {
                int j = 0;
                while(true)
                {
                    j++;
                    Log.w("localdebug","the j number is "+j);
                    int[] i = new int[100000000];
                }
            }
        };
        thr.start();
    }

    public void DrawView()
    {
        View v = getWindow().getDecorView();
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(),    
               Bitmap.Config.ARGB_8888);   
        Canvas canvas = new Canvas(bitmap);
        File f = new File("/sdcard/view");        
        v.draw(canvas);
        try
        {   
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();         
        }
        catch (FileNotFoundException e) 
        {
            Log.w("localdebug", "DrawView FileNotFoundException : \n"+e.getMessage());
        }
        catch (IOException e)
        {
            Log.w("localdebug", "DrawView IOException : \n"+e.getMessage());
        }
    }

    public void startRecord()
    {
        mRecord.start();
    }

    public void stopRecord()
    {
        mRecord.stop();
    }

    protected void finalize() throws Throwable
    {
        mRecord.release();
        super.finalize();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("locald"," main  onDestroy   ");
    }
    public void broadcastIntent()
    {
        Intent i = new Intent("abcd");
        sendBroadcast(i);
    }

    public String makaBigString()
    {
        String s = new String();
        for(int i = 0; i < 3000; i++)
        {
            s = s + "HelloHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH";
        }
        Log.d("localdebug","KT  makaBigString  done");
        return s;
    }

    public void testDisplayManagerGlobal()
    {
        //DisplayManagerGlobal displayManager = DisplayManagerGlobal.getInstance();
       // DisplayManager dm = (DisplayManager) getSystemService(DISPLAY_SERVICE);
       // Display ds = dm.getDisplay(0);
    }

    public void test_JNI()
    {
        Log.d("localdebug", "begin test_JNI");
        testJNI();
        Log.d("localdebug", "end test_JNI");
    }

    //static
    //{
    //    System.loadLibrary("kt_lib");
    //}

    public void testDropBox()
    {
        //DropBoxManager dbox = (DropBoxManager)getSystemService(Context.DROPBOX_SERVICE);
        //dbox.addText("abc","locald this is a test dropbox");
    }

    public void testLoadClass()
    {
        Class<?> cl;
        try
        {
            Log.d("localdebug", "testLoadClass finding TestActivity");
            cl = Class.forName(".TestActivity");
        }
        catch(ClassNotFoundException e)
        {
            Log.d("localdebug", "testLoadClass ClassNotFoundException TestActivity");
        }

        Class<?> cl1;
        try
        {
            Log.d("localdebug", "testLoadClass finding Monkey");
            cl1 = Class.forName("com.android.commands.monkey.Monkey");
        }
        catch(ClassNotFoundException e)
        {
            Log.d("localdebug", "testLoadClass ClassNotFoundException com.android.commands.monkey.Monkey");
        }

        PathClassLoader monkeyClassLoader = new PathClassLoader("/system/framework/monkey.jar",
            ClassLoader.getSystemClassLoader());
        /*
        try
        {
            Log.d("localdebug", "testLoadClass loader finding Monkey");
            cl1 = monkeyClassLoader.loadClass("com.android.commands.monkey.Monkey");
        }
        catch(ClassNotFoundException e)
        {
            Log.d("localdebug", "testLoadClass ClassNotFoundException loader com.android.commands.monkey.Monkey");
        }
        */

        Class<?> cl2;
        try
        {
            Log.d("localdebug", "testLoadClass finding com.android.server.power.ShutdownOem");
            cl2 = Class.forName("com.android.server.power.ShutdownOem");
        }
        catch(ClassNotFoundException e)
        {
            Log.d("localdebug", "testLoadClass ClassNotFoundException com.android.server.power.ShutdownOem");
        }

        Class<?> cl3;
        try
        {
            Log.d("localdebug", "testLoadClass finding ShutdownThread");
            cl3 = Class.forName("com.android.server.power.ShutdownThread");
        }
        catch(ClassNotFoundException e)
        {
            Log.d("localdebug", "testLoadClass ClassNotFoundException ShutdownThread");
        }
    }

    public void testArrayMap()
    {
        //ArrayMap<String, String> map = new ArrayMap<String, String>();
        //if(map.isEmpty() == true)
        //    Log.d("localdebug", "testArrayMap map is empty");
        //if(map.remove("abc") == null)
        //    Log.d("localdebug", "testArrayMap map remove return null");	
        //if(map.removeAt(10) == null)
        //    Log.d("localdebug", "testArrayMap map removeAt return null");	
    }

    public void testArray()
    {
        int[] array;
    }

    public void putLargeIntent()
    {
        Intent i = new Intent(this, TestListView.class);
        String s = makaBigString();
        String name = new String("com.main.test");
        i.putExtra(name, s);
        startActivity(i);
    }

    public void testHashMap()
    {
    	/*
        final Map<Integer, Boolean> map = Maps.newHashMap();
        map.put(1,true);
        map.put(2,false);
        map.put(3,true);
        Boolean b1 = map.get(1);
        if(b1 == true)
            Log.d("locald", "map 1 is true");
        Boolean b2 = map.get(2);
        if(b2 == false)
            Log.d("locald", "map 2 is false");
        Boolean b3 = map.get(3);
        if(b3 == true)
            Log.d("locald", "map 3 is true");
        Boolean b4 = map.get(4);
        if(b4 == null)
            Log.d("locald", "map 4 is null");
            */
    }

    public void testParcel()
    {
        Parcel p = Parcel.obtain();
        Log.d("locald", "the init position is " + p.dataPosition());
        p.writeInt(1);
        Log.d("locald", "the after 1, position is " + p.dataPosition());
        p.writeInt(2);
        Log.d("locald", "the after 2, position is " + p.dataPosition());
        int pos = p.dataPosition();
        Log.d("locald", "the pos is " + pos);
        p.writeInt(3);
        p.writeInt(4);
        p.setDataPosition(0);
        Log.d("locald", "all data " + p.readInt() + p.readInt() + p.readInt() + p.readInt());
        p.setDataPosition(pos);
        p.writeInt(5);
        p.setDataPosition(0);
        Log.d("locald", "at end, all data " + p.readInt() + p.readInt() + p.readInt() + p.readInt());
    }

    public void testSystemProp()
    {
        String p = System.getProperty("java.class.path");
        Log.d("locald", "java.class.path " + p);
    }

    public void testUsers()
    {
    	/*
        UserManager m = (UserManager) getSystemService(USER_SERVICE);
        String s = m.getUserName();
        Log.d("locald", "testUsers getUserName " + s);
        */
    }

    public void testAnim()
    {
        Intent intent = null;
        intent = new Intent(this, Xml4AnimActivity.class);
        startActivity(intent);
    }

    public void testResources()
    {
    	/*
        Resources resources = getResources();
        String resourceEntryName = resources.getResourceEntryName(R.animator.scalex);
        String resourceName = resources.getResourceName(R.animator.scalex);
        String resourcePackageName = resources.getResourcePackageName(R.animator.scalex);
        String resourceString = resources.getString(R.animator.scalex);
        Log.d("locald", "testResources " + "resourceEntryName " + resourceEntryName
                                         + " resourceName " + resourceName
                                         + " resourcePackageName " + resourcePackageName
                                         + " resourceString " + resourceString);
                                         */
    }

    public void testMyThread()
    {
        Thread thr = new TThread();
        //thr.setName("android.server.ServerThread");
        thr.start();
    }

//SeekBar
    public void testSeeker()
    {
    	/*
        stepSeeker.setProgressDrawable(getResources().getDrawable(R.drawable.unmute_timer_track));
        stepSeeker.setThumb(getResources().getDrawable(R.drawable.countdown_thumb));
        Log.d("locald","getThumbOffset  " + stepSeeker.getThumbOffset());
        stepSeeker.setThumbOffset(0);
        //stepSeeker.setProgress(13);
         * 
         */
    }

    public void testException()
    {
        Log.d("locald", "testException enter");
        try {
            String s = null;
            Log.d("local", s);
        }
        catch(NullPointerException e) {
            String ex = new String();
            //ex = ex + e;
            //Log.d("locald", "testException " + ex);
            StackTraceElement[] stack = e.getStackTrace();
            if(ex != null && stack != null) {
            int len = stack.length;
            if(len > 5) {
                len = 5;
            }
            for(int i = 0; i < len; i++) {
                ex = ex + stack[i].getClassName()
                        + " " + stack[i].getFileName() 
                        + " " + stack[i].getLineNumber()
                        + " " + stack[i].getMethodName();
                ex = ex + "\n";
            }
            Log.d("locald", "testException  " + ex);
            }
        }
    }

    public void checkView()
    {

        if(mView.getBackground().getOpacity() == PixelFormat.OPAQUE)
        {
            Log.d("locald", "mView.getBackground().getOpacity() == PixelFormat.OPAQUE");
        }
        Log.d("locald","getOpacity  " + mView.getBackground().getOpacity());
    }

    public void launchMoreActivities() {
         Intent i = new Intent(this, TestActivity.class);
         startActivity(i);
         //Intent i1 = new Intent(this, TestActivity1.class);
         //startActivity(i1);
         //Intent i2 = new Intent(this, TestActivity2.class);
         //startActivity(i2);
         //Intent i3 = new Intent(this, TestActivity3.class);
         //startActivity(i3);
    }

/*
    public void testSmartisanApi() {
        Log.d("locald","testSmartisanApi ");
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        Configuration config = SmartisanApi.getInstance().getConfiguration(am);
        if(config == null) {
            Log.d("locald","testSmartisanApi  fail  ");
        }
        else {
            Log.d("locald","testSmartisanApi  good ");
        }
    }
*/

    public void testFatherChild(Base b) {
        b.func();
        b.funcBase();
    }

    public void testFatherChild(TestA a) {
        a.func();
        a.funcBase();
    }

    public void launchTestActivity1()
    {
         Intent i = new Intent(this, TestActivity1.class);
         startActivity(i);
    }

    public void testService() {
        Intent intent = new Intent();
        intent.setAction("com.main.TestService");
        intent.setPackage("com.main");
        startService(intent);
    }

    public void stopService() {
        Log.d("locald","stopService ");
        Intent intent = new Intent();
        intent.setAction("com.main.TestService");
        intent.setPackage("com.main");
        stopService(intent);
        Log.d("locald","stopService end ");
    }
    public void test1() {
        stopService();
    }

    public void testThreadRun() {
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    Log.d("locald","testThreadRun  ");
                }
            }
        }).start();

    }

    public void parseInt(String string) {
        if (string == null) {
            Log.d("locald","parseInt 1 : " + string);
        }
        int length = string.length(), i = 0;
        if (length == 0) {
            Log.d("locald","parseInt 2 : " + string);
        }
        boolean negative = string.charAt(i) == '-';
        if (negative && ++i == length) {
            Log.d("locald","parseInt 3 ");
        }
    }

    public void testLog() {
        final StringBuilder sb = new StringBuilder(1024);
        InputStreamReader input = null;
        sb.append("\n");
        try {
            java.lang.Process logcat = new ProcessBuilder("/system/bin/logcat",
               "-v", "time", "-b", "events", "-b", "system", "-b", "main", "-t", String.valueOf(1000)).redirectErrorStream(true).start();
            Log.d("locald"," testLog 1");
            try { logcat.getOutputStream().close(); } catch (IOException e) {}
            try { logcat.getErrorStream().close(); } catch (IOException e) {}
            input = new InputStreamReader(logcat.getInputStream());
            Log.d("locald"," testLog 2");
            int num;
            char[] buf = new char[81920000];
            while ((num = input.read(buf)) > 0) sb.append(buf, 0, num);
            Log.d("locald"," testLog 3 " + num);
            String s = new String(buf);
            Log.d("locald"," testLog 4 " + s);
            byte[] b = s.getBytes();
            MyFile.fillFile(b);
        } catch (IOException e) {
            Log.e("locald", "Error running logcat", e);
        } finally {
            if (input != null) try { input.close(); } catch (IOException e) {}
        }
    }

    public void testANR() {
        while(true) {
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("locald","  onConfigurationChanged  ");
    }

    public void launchCamera() {
        Intent i = new Intent(this, CameraActivity.class);
        startActivity(i);
    }

    public void testIris() {
        //IrisManager iris = new IrisManager(this);
        //IIrisService irisBinder = IIrisService.Stub.asInterface(ServiceManager.getService("iris"));
        //IrisManager iris = new IrisManager(this, irisBinder);
        Log.e("locald"," after get Iris Manager");
        //Bitmap b = iris.getDisplay();
        //if(b != null) {
        //    Log.d("locald","ok to get bitmap .. ");
        //}
       // iris.preEnroll();
        Log.e("locald","kt preEnroll done");

        //Intent i = new Intent(this, com.main.surface.IrisActivity.class);
        //startActivity(i);
    }

    public void testDexClassLoader() {
        Object r = new Object();
        try {
            Log.w("locald", " testDexClassLoader ");
            DexClassLoader classLoader = new DexClassLoader("/system/framework/test.jar", new ContextWrapper(this).getCacheDir().getAbsolutePath(), null, ClassLoader.getSystemClassLoader());

            Class jarTest = classLoader.loadClass("abc.abc");
            Method jarTestGo = jarTest.getDeclaredMethod("print");
            jarTestGo.invoke(r);
            //Class jarTest = classLoader.loadClass("com.irisking.IrisAlgo.Enroll");
            //Method saveMonoBMPImage = jarTest.getDeclaredMethod("saveMonoBMPImage");
            //saveMonoBMPImage.invoke(r, "/sdcard/abc", null, 0, 0, null);
            Log.w("locald", " saveMonoBMPImage done  dex ... ");
        } catch (java.lang.ClassNotFoundException e) {
            Log.w("locald", " saveMonoBMPImage done  dex ... " + e);
        } catch (java.lang.NoSuchMethodException e) {
            Log.w("locald", " saveMonoBMPImage done  dex ... " + e);
        } catch (java.lang.IllegalAccessException e) {
            Log.w("locald", " saveMonoBMPImage done  dex ... " + e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            Log.w("locald", " saveMonoBMPImage done  dex ... " + e);
        }
    }

    public void test()
    {
        MyFile f = new MyFile();
        f.readwriteBitmapFile();
        Intent i = new Intent(this, com.main.surface.IrisActivity.class);
        startActivity(i);
    	//testIris();
        //testANR();
        //Intent intent = new Intent("MyReceiver123");
        //sendBroadcast(intent);
        //Log.wtf("locald"," locald wtf   ");
        //testLog();
        //testThreadRun();
        //AMSTest.getRecentTasks(this);
        //launchTestActivity1();
        //MyArrayList.test();
        //testSmartisanApi();
        //testException();
        //launchMoreActivities();
        //TestA a = new TestA();
        //int ii = a.mem;
        //a.memFunc();
        //TestB b = new TestB();
        //testFatherChild(a);
        //testFatherChild(b);
        //showTestListView();
        //checkView();
        //testSeeker();
        //testMyThread();
        //testResources();
        //testUsers();
        //test_JNI();
        //putLargeIntent();
        //Log.wtf("locald", " ===test()");
        //testLoadClass();
        //ProviderTest.setContext(this);
        //ProviderTest.testCalender();
        //char[] data = new char[1];
        //data[0] = '0';
        //String s = String.copyValueOf(data);
        //s = "";
        //s = null;
        //parseInt(s);
        //Log.d("locald","parseInt  " + s);
        //Integer.parseInt(s);
        //String sys = SystemProperties.get("persist.sys.power.trace");
        //Log.d("locald","parseInt  sys " + sys);
        //Intent intent = new Intent();
        //intent.setAction("android.intent.action.DebugServer");
        //sendBroadcast(intent);
    }
}



