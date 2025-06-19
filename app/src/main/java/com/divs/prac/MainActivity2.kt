package com.divs.prac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private val item = arrayListOf<String>()
    private val categories = arrayListOf<String>()
    private val quantities = arrayListOf<Int>()
    private val comment = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val itemsInput = findViewById<EditText>(R.id.itemsInput)
        val categoryInput = findViewById<EditText>(R.id.categoryInput)
        val commentsInput = findViewById<EditText>(R.id.commentsInput)
        val inputQuantity = findViewById<EditText>(R.id.Inputquantity)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnAdd.setOnClickListener {
            val items = itemsInput.text.toString()
            val category = categoryInput.text.toString()
            val quantityStr = inputQuantity.text.toString()
            val comments = commentsInput.text.toString()

            if (items.isBlank() || category.isBlank() || quantityStr.isBlank()) {
                Toast.makeText(this, "Please fill all required fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val quantity = quantityStr.toIntOrNull()
            if (quantity == null || quantity <= 0) {
                Toast.makeText(this, "Quantity must be a positive number.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            item.add(items)
            categories.add(category)
            quantities.add(quantity)
            comment.add(comments)

            Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show()

            itemsInput.text.clear()
            categoryInput.text.clear()
            inputQuantity.text.clear()
            commentsInput.text.clear()
        }

        btnView.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putStringArrayListExtra("items", item)
            intent.putStringArrayListExtra("categories", categories)
            intent.putIntegerArrayListExtra("quantities", ArrayList(quantities))
            intent.putStringArrayListExtra("comments", comment)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finishAffinity() // Closes the app completely
        }

        btnClear.setOnClickListener {
            itemsInput.text.clear()
            categoryInput.text.clear()
            inputQuantity.text.clear()
            commentsInput.text.clear()
        }
    }
}