package com.example.seebha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView

class FreeGo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free_go)

        /*set values for texts and buttons */
        val mainText = findViewById<TextView>(R.id.mainText)
        val plusButton = findViewById<Button>(R.id.plusButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        var counter = 0 /*countering Altasbeeh */

        /*the action of plus button*/
        plusButton.setOnClickListener {
            counter+=1
            mainText.text = counter.toString()
            mainText.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40F)
        }

        /*the action of reset button*/
        resetButton.setOnClickListener {
            counter = 0
            mainText.text = "بسم الله من جديد"
        }
    }
}