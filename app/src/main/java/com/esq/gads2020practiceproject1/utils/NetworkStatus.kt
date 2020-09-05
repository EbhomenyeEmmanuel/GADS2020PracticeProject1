package com.esq.gads2020practiceproject1.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleObserver
import com.biodun.networkMonitorManager.NetworkMonitorManager

class NetworkStatus(context: Context) : LifecycleObserver {
    val TAG = this::class.simpleName

    init {
        (context as AppCompatActivity).lifecycle.addObserver(this)
    }

    val networkMonitorManager: NetworkMonitorManager by lazy {
        NetworkMonitorManager.getInstance(context)
    }

 }
