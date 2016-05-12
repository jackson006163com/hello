package com.main;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class TThread extends Thread 
{

    final Handler mHandler;
    static final int MONITOR = 0;

    final class TestHandler extends Handler 
    {
        TestHandler(Looper looper) 
        {
            super(looper);
        }

        public void handleMessage(Message msg)  
        {
            Log.w("localdebug", "TestHandler handleMessage \n");
            while(true){}
        }
    }

    public TThread() {
        super("TThread");
        mHandler = new TestHandler(Looper.getMainLooper());
    }


    public void run() 
    {
        //mHandler.sendEmptyMessage(MONITOR);
        Log.w("locald", "Test my thread , run \n");
        try {
            sleep(30*1000);
        }
        catch(Exception e) {
        }
        Log.w("locald", "Test my thread , after sleep \n");
    }

}
