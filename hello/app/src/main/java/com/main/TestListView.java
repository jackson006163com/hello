package com.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.graphics.Canvas;



public class TestListView extends Activity {

    class MyListView extends ListView
    {
        public MyListView(Context context)
        {
            super(context);
        }

        public MyListView(Context context,AttributeSet attrs)
        {
            super(context,attrs);
        }
        
        public MyListView(Context context, AttributeSet attrs, int defStyleAttr)
        {
            super(context,attrs,defStyleAttr);
        }

        public boolean onTouchEvent (MotionEvent event)
        {

RuntimeException exx = new RuntimeException("localdebug call trace");
exx.fillInStackTrace();
Log.i("locald", "call trace", exx);


            //Log.w("localdebug", "test list view onTouchEvent\n");
            Log.d("localdebug","test list view onTouchEvent " + event.getAction()+"x "+event.getX() + "y " + event.getY()+"\n");
            return super.onTouchEvent(event);
        }

        protected void onDraw(Canvas canvas) 
        {
            Log.w("localdebug", "test list view onDraw\n");
            super.onDraw(canvas);
        }
    }

    class EmptyView extends View
    {
        public EmptyView(Context context)
        {
            super(context);
        }

        public EmptyView(Context context,AttributeSet attrs)
        {
            super(context,attrs);
        }
        
        public EmptyView(Context context, AttributeSet attrs, int defStyleAttr)
        {
            super(context,attrs,defStyleAttr);
        }

        public boolean onTouchEvent (MotionEvent event)
        {
            //Log.w("localdebug", "test list view onTouchEvent\n");
Log.d("localdebug","EmptyView onTouchEvent " + event.getAction()+"x "+event.getX() + "y " + event.getY()+"\n");
            return super.onTouchEvent(event);
        }

        protected void onDraw(Canvas canvas) 
        {
            Log.w("localdebug", "EmptyView onDraw\n");
            super.onDraw(canvas);
        }
    }

    private MyListView listView;

    private List<String> getData(){
         
        List<String> data = new ArrayList<String>();
        for(int i = 0; i < 20; i++)
            data.add("测试数据" + i);
         
        return data;
    }


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
         
        listView = new MyListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
        //EmptyView emptyView = new EmptyView(this);
        setContentView(listView);
        //setContentView(emptyView);
    }
     
     


}
