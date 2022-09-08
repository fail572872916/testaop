package com.example.testaop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.testaop.aop.annotation.SingleClick
import com.example.testaop.aop.aspect.SingleClickAspect

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_hello_world).setOnClickListener {

            testClick()

        }
    }
    @SingleClick
    fun testClick(){
        Log.d("SingleClickAspect", "testClick")
    }
}