package com.varsitycollege.st10276384

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.*

class stats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        var tvHeading = findViewById<TextView>(R.id.tvHeading)
        var tvEnterNumber = findViewById<TextView>(R.id.tvEnterNumber)
        var etStatsNum = findViewById<EditText>(R.id.etStatsNum)
        var btnStatsAdd = findViewById<Button>(R.id.btnStatsAdd)
        var etMemory = findViewById<EditText>(R.id.etMemory)
        var btnClear = findViewById<Button>(R.id.btnClear)
        var btnAvg = findViewById<Button>(R.id.btnAvg)
        var btnMinMax = findViewById<Button>(R.id.btnMinMax)
        var tvStatsAns = findViewById<TextView>(R.id.tvStatsAns)
        var etStatsResult = findViewById<EditText>(R.id.etStatsResult)
        var tvStatsTextMemory= findViewById<TextView>(R.id.tvStatsTextMemory)
        var btnBack= findViewById<Button>(R.id.btnBack)

        // Initialize your data structures and variables here
        val numbers = IntArray(10) { 0 }
        var count = 0

        // Implement button click handlers
        btnStatsAdd.setOnClickListener {
            if (count < numbers.size) {
                val numberInput = etStatsNum.text.toString().toIntOrNull()
                if (numberInput != null) {
                    numbers[count] = numberInput
                    etMemory.append("$numberInput, ")
                    count++
                    etStatsNum.text.clear()
                }
            }
        }

        btnAvg.setOnClickListener {
            val sum = numbers.take(count).sum()
            val average = if (count > 0) sum.toDouble() / count else 0.0
            etStatsResult.setText("Average: $average")
        }

        btnMinMax.setOnClickListener {
            val enteredNumbers = numbers.take(count)
            if (enteredNumbers.isNotEmpty()) {
                val min = enteredNumbers.minOrNull()
                val max = enteredNumbers.maxOrNull()
                etStatsResult.setText("Minimum: $min, Maximum: $max")
            }
        }

        btnClear.setOnClickListener {
            for (i in 0 until numbers.size) {
                numbers[i] = 0
            }
            count = 0
            etMemory.text.clear()
            etStatsResult.text.clear()
            etStatsNum.text.clear()
        }
        btnBack.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}