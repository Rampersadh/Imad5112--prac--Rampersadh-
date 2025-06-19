package com.divs.prac

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var allitemsText: TextView
    private lateinit var filteritemsText: TextView
    private lateinit var backbtn: Button
    private lateinit var showAllbtn: Button
    private lateinit var showFilterbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        allitemsText = findViewById(R.id.allitemsText)
        filteritemsText = findViewById(R.id.filteritemsText)
        backbtn = findViewById(R.id.backbtn)
        showAllbtn = findViewById(R.id.showAllbtn)
        showFilterbtn = findViewById(R.id.showFilterbtn)

        val items = intent.getStringArrayListExtra("items") ?: arrayListOf()
        val categories = intent.getStringArrayListExtra("categories") ?: arrayListOf()
        val quantities = intent.getIntegerArrayListExtra("quantities") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        showAllbtn.setOnClickListener {
            val list = items.indices.joinToString("\n") {
                "${items[it]} (${categories[it]}) - Rating ${quantities[it]}, Comment: ${comments[it]}"
            }
            allitemsText.text = list.ifBlank { "No Songs added." }
        }

        showFilterbtn.setOnClickListener {
            val filtered = items.indices
                .filter { quantities[it] >= 2 }
                .joinToString("\n") {
                    "${items[it]} (Rating: ${quantities[it]})"
                }
            filteritemsText.text = filtered.ifBlank { "No items with Songs Add to Rating List ." }
        }

        backbtn.setOnClickListener {
            finish()
        }
    }
}