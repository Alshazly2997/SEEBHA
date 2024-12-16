package com.example.seebha

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.widget.Button
import android.widget.TextView
import android.os.Vibrator
import android.widget.Toast
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import java.util.Timer
import kotlin.concurrent.timerTask
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

class MorningAzkerActivity : AppCompatActivity() {

    private var zeekrText : TextView? = null
    private var mainAzkarButton : Button? = null
    private var nextAzkarButton : Button? = null
    private var previousAzkarButton : Button? = null

    private var mAzkarList : ArrayList<Zeekr>? = null
    private var azkarName : String = "azkarName"
    private var mCurrentPosition : Int = 1
    private var counter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning_azker)

        zeekrText = findViewById(R.id.morningAzkaText)
        mainAzkarButton = findViewById(R.id.plusAzkarButton)
        nextAzkarButton = findViewById(R.id.nextAzkarButton)
        previousAzkarButton = findViewById(R.id.previousAzkarButton)

        azkarName = intent.getStringExtra("azkarName").toString()
        when(azkarName){
            "morningAzkar" -> {
                mAzkarList = Azkars.getMorningAzkars()
            }

            "nightAzkar" -> {
                mAzkarList = Azkars.getNightAzkars()
            }

            "wakeupAzkar" -> {
                mAzkarList = Azkars.getWakeUpAzkars()
            }
            "sleepAzkar" -> {
                mAzkarList = Azkars.getSleepAzkars()
            }
            "afterSalaAzkar" -> {
                mAzkarList = Azkars.getAfterSalaAzkars()
            }
            "mousqueAzkar" ->{
                mAzkarList = Azkars.getMousqueAzkars()
            }
        }
        setZeekr()

        mainAzkarButton?.setOnClickListener {
            counter++
            setZeekr()
            if (mainAzkarButton?.text == "DONE"){
                longVibrate(this)
                startActivity(Intent(this, Azkar::class.java))
                finish()
            }
        }

        nextAzkarButton?.setOnClickListener {
            when (mCurrentPosition) {
                mAzkarList!!.size -> {
                    startActivity(Intent(this, Azkar::class.java))
                    finish()
                }
                else -> {
                    mCurrentPosition++
                    counter = 0
                    setZeekr()
                }
            }
        }

        previousAzkarButton?.setOnClickListener {
            if (mCurrentPosition == 1){
                startActivity(Intent(this, Azkar::class.java))
                finish()
            }else{
                mCurrentPosition--
                counter = 0
                setZeekr()
            }
        }
    }

    private fun setZeekr(){
        val zeekr : Zeekr = mAzkarList!![mCurrentPosition - 1]

        zeekrText?.text = zeekr.zekr

        if (mCurrentPosition == mAzkarList!!.size && counter == zeekr.count){
            mainAzkarButton?.text = "DONE"
        }else{
            mainAzkarButton?.text = "$counter/${zeekr.count}"
            if (counter == zeekr.count){
                vibrate(this)
                mCurrentPosition++
                counter = 0
                setZeekr()
            }
        }
    }

    private fun vibrate(context: Context){
            (context.getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(100)
    }

    private fun longVibrate(context: Context){
        (context.getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(500)
    }

}