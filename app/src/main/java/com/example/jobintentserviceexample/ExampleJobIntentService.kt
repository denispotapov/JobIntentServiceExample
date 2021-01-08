package com.example.jobintentserviceexample

import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.core.app.JobIntentService
import timber.log.Timber

class ExampleJobIntentService : JobIntentService() {

    fun enqueueWork(context: Context, work: Intent) {
        enqueueWork(context, ExampleJobIntentService::class.java, 123, work)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("onCreate")
    }

    override fun onHandleWork(intent: Intent) {
        Timber.d("onHandleWork")

        val input = intent.getStringExtra("key")

        for (i in 0..10) {
            Timber.d("onHandleIntent: $input - $i")

            if (isStopped) return

            SystemClock.sleep(1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }

    override fun onStopCurrentWork(): Boolean {
        Timber.d("onStopCurrentWork")
        return super.onStopCurrentWork()

    }
}