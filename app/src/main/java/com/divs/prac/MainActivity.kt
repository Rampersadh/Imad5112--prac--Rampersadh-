package com.divs.prac

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // "Get started" button by ites ID from XML layout
        val button = findViewById<Button>(R.id.button)
        val exitbtn = findViewById<Button>(R.id.exitbtn)

        // Set a click listener on the button to respond to user interaction
        button.setOnClickListener {
            // Create an Intent to navigate to MainActivity2 when the button is clicked
            startActivity(Intent(this, MainActivity2::class.java))
        }


        exitbtn.setOnClickListener {
            finishAffinity()
        }
    }
}