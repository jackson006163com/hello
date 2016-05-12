package com.main.record;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.media.MediaRecorder;

public class RecordEngine
{
    private static final String PATH_NAME = "/sdcard/record.3gp";

    private MediaRecorder mRecorder;
    private boolean mIsRecording = false;

    public RecordEngine()
    {
        mRecorder = new MediaRecorder();
    }

    public void start()
    {
        if(mIsRecording == false)
        {
            try
            {
                synchronized(mRecorder)
                {
                    Log.w("localdebug", "record start \n");
                    mRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
                    mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    mRecorder.setOutputFile(PATH_NAME);
                    mRecorder.prepare();
                    mRecorder.start();
                    mIsRecording = true;
                }
            }
            catch( FileNotFoundException e)
            {
                Log.w("localdebug", "testFiles FileNotFoundException : \n"+e.getMessage());
            }
            catch( IOException e)
            {
                Log.w("localdebug", "testFiles IOException : \n"+e.getMessage());
            }
        }
    }

    public void stop()
    {
        if(mIsRecording == true)
        {
            synchronized(mRecorder)
            {
                Log.w("localdebug", "record stop \n");
                mRecorder.stop();
                mRecorder.reset();
                //mRecorder.release();
                mIsRecording = false;
            }
        }
    }

    public void release()
    {
        mRecorder.release();
    }

}
