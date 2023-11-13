package com.varsitycollege.st10276384

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Elements
        var tvEnter= findViewById<TextView>(R.id.tvEnter)
        var etNum1= findViewById<EditText>(R.id.etNum1)
        var etNum2= findViewById<EditText>(R.id.etNum2)
        var btnAdd= findViewById<Button>(R.id.btnAdd)
        var btnSub= findViewById<Button>(R.id.btnSub)
        var btnMult= findViewById<Button>(R.id.btnMult)
        var btnDiv= findViewById<Button>(R.id.btnDiv)
        var btnSquRoot= findViewById<Button>(R.id.btnSquRoot)
        var btnPower= findViewById<Button>(R.id.btnPower)
        var btnStats= findViewById<Button>(R.id.btnStats)
        var tvAnswer= findViewById<TextView>(R.id.tvAnswer)
        var etResult= findViewById<EditText>(R.id.etResult)


        btnStats.setOnClickListener {
            val intent = Intent(this, stats::class.java)
            startActivity(intent)
        }
        // Calculate addition
        btnAdd.setOnClickListener {
            val result = etNum1.text.toString().toInt() + etNum2.text.toString().toInt()
            etResult.setText("${etNum1.text} + ${etNum2.text} = $result")
        }

        // Calculate subtraction
        btnSub.setOnClickListener {
            val result = etNum1.text.toString().toInt() - etNum2.text.toString().toInt()
            etResult.setText("${etNum1.text} - ${etNum2.text} = $result")
        }

        // Calculate multiplication
        btnMult.setOnClickListener {
            val result = etNum1.text.toString().toInt() * etNum2.text.toString().toInt()
            etResult.setText("${etNum1.text} x ${etNum2.text} = $result")
        }

        // Calculate division with error checking
        btnDiv.setOnClickListener {
            val num2 = etNum2.text.toString().toInt()
            val result: String
            if (num2 == 0) {
                val errorText = "Error: Division by 0 is not allowed"
                val builder = SpannableStringBuilder(errorText)
                builder.setSpan(
                    ForegroundColorSpan(Color.RED),
                    0,
                    errorText.length,
                    0
                )
                etResult.text = builder
            } else {
                val resultValue = etNum1.text.toString().toInt() / num2
                result = "${etNum1.text} ÷ ${etNum2.text} = $resultValue"
                etResult.setText(result)
            }
        }

        // Calculate square root
        btnSquRoot.setOnClickListener {
            val num1 = etNum1.text.toString().toInt()
            val result: String = if (num1 < 0) {
                val imaginaryPart = (sqrt(-num1.toDouble())).toInt().toString() + " i"
                "sqrt($num1) = $imaginaryPart"
            } else {
                val realResult = (sqrt(num1.toDouble())).toInt()
                "sqrt($num1) = $realResult"
            }
            etResult.setText(result)
        }


        // Calculate powers using a loop
        btnPower.setOnClickListener {
            val base = etNum1.text.toString().toInt()
            val exponent = etNum2.text.toString().toInt()

            var result = 1

            for (i in 1..exponent) {
                result *= base
            }

            etResult.setText("$base^$exponent = $result")
        }
    }
}
