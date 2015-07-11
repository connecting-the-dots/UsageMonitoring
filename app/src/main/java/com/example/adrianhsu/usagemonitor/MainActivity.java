package com.example.adrianhsu.usagemonitor;

import java.util.List;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Context;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    private static final String ACTIVITY_TAG="MainActivity";
    private static final int MAX_RUNNING = 1000;
    private ActivityManager am;
    private ActivityManager.RunningServiceInfo serviceInfo;
    private List<RunningServiceInfo> runningServiceInfoList;
    Context context;

    void createRecorder() {

        Log.v(Context.ACTIVITY_SERVICE, "test");
        am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        serviceInfo = new RunningServiceInfo();
        runningServiceInfoList = am.getRunningServices(MAX_RUNNING);

        Log.v(this.ACTIVITY_TAG, "This is Verbose.");
    }git

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRecorder();
    }

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