package com.example.seebha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val freeGoButton : Button = findViewById(R.id.freeGoButton)
        val targetGoButton : Button = findViewById(R.id.targetGoButton)
        val azkarButton : Button = findViewById(R.id.azkarButton)
        val thirdButton : Button = findViewById(R.id.thirdButton)

        freeGoButton.setOnClickListener {

            startActivity(Intent(this, FreeGo::class.java))
        }

        targetGoButton.setOnClickListener {
            startActivity(Intent(this, TargetGo::class.java))
        }

        azkarButton.setOnClickListener {
            startActivity(Intent(this, Azkar::class.java))
        }

        thirdButton.setOnClickListener {
            Toast.makeText(this, "Will come soon!", Toast.LENGTH_SHORT).show()
        }

    }
}