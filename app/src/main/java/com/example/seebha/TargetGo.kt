package com.example.seebha

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TargetGo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target_go)

        val mainTargetGo = findViewById<TextView>(R.id.mainTargetText)
        val etTarget = findViewById<EditText>(R.id.et_target)
        val mainTargetButton = findViewById<Button>(R.id.plusTargetButton)

        val userTarget : EditText? = etTarget
        var counter = 0

        mainTargetButton.setOnClickListener {
            /*checking if we get a value from user*/
            if(etTarget.text.isEmpty()){
                Toast.makeText(this, "Please enter your target",Toast.LENGTH_SHORT).show()
            }else if (etTarget.text.isNotEmpty()){
                /*star the action and the counter increase, when we retch the target it will reset-
                * again and star from zero*/
                var intUserTarget : Int = userTarget?.text.toString().toInt()
                if (counter <= intUserTarget){
                    mainTargetButton.text = "+"
                    mainTargetGo.text = "$counter/${userTarget?.text}"
                    ++counter
                    var stringCounter :String = (counter-1).toString()
                    if (stringCounter == userTarget?.text.toString()){
                        counter = 0
                        mainTargetButton.text = "RESTART"
                        vibrate(this)
                    }
                }else{
                    mainTargetButton.text = "START"
                    counter = 0
                }
            }
        }
    }

    private fun vibrate(context: Context){
        (context.getSystemService(VIBRATOR_SERVICE) as Vibrator).vibrate(100)
    }
}