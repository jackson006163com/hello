package com.main.javabasic;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyArrayList extends ArrayList {

    public static void test() {
        Log.w("locald", "MyArrayList test \n");
        List myList = new CopyOnWriteArrayList();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
/*
        for (String value : myList) {
           // Log.w( "List Value:" + value);
            if (value.equals("3")) {
                myList.remove(value);  // error
                }
           }
*/
        for (Iterator it = myList.iterator(); it.hasNext();) {
                String value = (String)it.next();
                Log.w("locald", "MyArrayList test " + value);
                 if (value.equals( "3")) {
                     myList.remove(value);  // error
                }
           }   
    }
}
