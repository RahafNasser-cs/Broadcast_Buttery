package com.example.broadcastbuttery.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView

class MyBatteryReceiver(val textview: TextView) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val batteryLevel = intent?.getIntExtra("level", 0)
        textview.text =
            if (batteryLevel <= 20) "Low" else if (batteryLevel > 20 && batteryLevel <= 80) "Full" else "Normal"
    }
}
