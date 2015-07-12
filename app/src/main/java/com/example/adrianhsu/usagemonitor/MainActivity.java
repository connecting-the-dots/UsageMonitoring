package com.example.adrianhsu.usagemonitor;

import java.util.List;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import android.widget.Toast;
import android.os.Debug.MemoryInfo;
import android.util.Log;

public class MainActivity extends ActionBarActivity {


    ActivityManager activityManager;
    ActivityManager.MemoryInfo memoryInfo;
    ActivityManager.RunningServiceInfo runningServiceInfo;
    final String TAG = "MemInfo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        memoryInfo = new ActivityManager.MemoryInfo();
        runningServiceInfo = new ActivityManager.RunningServiceInfo();

//        Log.i(TAG, " memoryInfo.availMem " + memoryInfo.availMem);
//        Log.i(TAG, " memoryInfo.lowMemory " + memoryInfo.lowMemory);
//        Log.i(TAG, " memoryInfo.threshold " + memoryInfo.threshold);

        activityManager.getMemoryInfo(memoryInfo);
        Log.i(TAG, "runningServiceInfo.activeSince " + runningServiceInfo.activeSince);
        Log.i(TAG, "runningServiceInfo.clientCount " + runningServiceInfo.clientCount);
        Log.i(TAG, "runningServiceInfo.crashCount " + runningServiceInfo.crashCount);
        Log.i(TAG, "runningServiceInfo.foreground " + runningServiceInfo.foreground);


        Toast.makeText(getApplicationContext(),  String.valueOf( runningServiceInfo.activeSince ), Toast.LENGTH_LONG)
                .show();

    } // end onCreate
//    private  String getSystemAvaialbeMemorySize(){
//        //獲得MemoryInfo對象
//        MemoryInfo memoryInfo =  new  MemoryInfo() ;
//        //獲得系統可用內存，保存在MemoryInfo對像上
//        mActivityManager.getMemoryInfo(memoryInfo) ;
//        long  memSize = memoryInfo.availMem ;
//
//        //字符類型轉換
//        String availMemStr = formateFileSize(memSize);
//
//        return  availMemStr ;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}