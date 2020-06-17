package com.example.swoosh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class BaseActivity : AppCompatActivity() {                       // This class is used for viewing the logs of the lifecycle of each activity

    val TAG = "Lifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"${javaClass.simpleName} OnCreate")           //Log is used to see the logs in Logcat  Log.d means logs for debug
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG,"${javaClass.simpleName} OnStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG,"${javaClass.simpleName} OnResume")
        super.onResume()
    }

    override fun onRestart() {
        Log.d(TAG,"${javaClass.simpleName} OnRestart")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG,"${javaClass.simpleName} OnPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG,"${javaClass.simpleName} OnStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"${javaClass.simpleName} OnDestroy")
        super.onDestroy()
    }
}
