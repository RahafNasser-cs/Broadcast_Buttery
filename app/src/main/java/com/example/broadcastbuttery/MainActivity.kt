package com.example.broadcastbuttery

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcastbuttery.broadcastreceiver.MyBatteryReceiver

class MainActivity : AppCompatActivity() {
    lateinit var myBatteryReceiver: MyBatteryReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textview)
        myBatteryReceiver = MyBatteryReceiver(textView)
        registerReceiver(myBatteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBatteryReceiver)
    }
}
