package com.main.fatherchild;

import android.util.Log;

public abstract class Base {

    public abstract void func();

    public void funcBase() {
        Log.w("locald", "Test base func \n");
    }
}
