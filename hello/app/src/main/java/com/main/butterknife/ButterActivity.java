package com.main.butterknife;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;

import com.main.broadcastreceiver.MyReceiver;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class ButterActivity extends Activity
{

    private BroadcastReceiver bc = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {

        }
    };

    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        registerReceiver(bc, new IntentFilter(
                Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
    }

    protected void onDestroy() {
        super.onDestroy();
        //ButterKnife.unbind(this);
    }
}