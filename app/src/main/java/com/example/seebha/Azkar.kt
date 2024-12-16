package com.example.seebha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Azkar : AppCompatActivity() {

    private var mAzkarList : ArrayList<Zeekr> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_azkar)

        val morningAzkarButton : Button = findViewById(R.id.morningAzkarButton)
        val nightAzkarButton : Button = findViewById(R.id.nightAzkarButton)
        val wakeupAzkerButton : Button = findViewById(R.id.wakeupAzkarButton)
        val sleepAzkerButton : Button = findViewById(R.id.sleepAzkarButton)
        val afterSalaButton : Button = findViewById(R.id.AfterSalaButton)
        val mousqeAzkar : Button = findViewById(R.id.mosqueAzkar)


        morningAzkarButton.setOnClickListener {
            val intent = Intent(this, MorningAzkerActivity::class.java)
            intent.putExtra("azkarName","morningAzkar")
            startActivity(intent)
            finish()
        }

        nightAzkarButton.setOnClickListener {
            val intent = Intent(this, MorningAzkerActivity::class.java)
            intent.putExtra("azkarName","nightAzkar")
            startActivity(intent)
            finish()
        }

        wakeupAzkerButton.setOnClickListener {
            val intent = Intent(this, MorningAzkerActivity::class.java)
            intent.putExtra("azkarName","wakeupAzkar")
            startActivity(intent)
            finish()
        }

        sleepAzkerButton.setOnClickListener {
            val intent = Intent(this, MorningAzkerActivity::class.java)
            intent.putExtra("azkarName","sleepAzkar")
            startActivity(intent)
            finish()
        }

        afterSalaButton.setOnClickListener {
            val intent = Intent(this, MorningAzkerActivity::class.java)
            intent.putExtra("azkarName","afterSalaAzkar")
            startActivity(intent)
            finish()
        }

        mousqeAzkar.setOnClickListener {
            val intent = Intent(this, MorningAzkerActivity::class.java)
            intent.putExtra("azkarName", "mousqueAzkar")
            startActivity(intent)
            finish()
        }
    }
}