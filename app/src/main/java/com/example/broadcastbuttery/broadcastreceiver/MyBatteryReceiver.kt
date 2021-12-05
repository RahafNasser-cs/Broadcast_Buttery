package com.example.broadcastbuttery.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.TextView

class MyBatteryReceiver(val textview: TextView) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val batteryLevel = intent?.getIntExtra("level", 0)
        textview.text = if (intent.getIntExtra(
                BatteryManager.EXTRA_STATUS,
                -1
            ) == BatteryManager.BATTERY_STATUS_CHARGING
        )
            "Charging"
        else if (batteryLevel <= 20) "Low" else if (batteryLevel > 20 && batteryLevel <= 80) "Normal" else "Full"
    }
}
