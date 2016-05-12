package com.main.fatherchild;

import android.util.Log;

public class TestA extends Base {

    public int mem;
    public void memFunc() {
    }

    public void func() {
        Log.w("locald", "Test A func \n");
    }

    public void funcBase() {
        Log.w("locald", "Test base A func \n");
    }
}
