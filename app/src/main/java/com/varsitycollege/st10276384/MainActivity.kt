package com.varsitycollege.st10276384

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //elements
        var tvEnter= findViewById<TextView>(R.id.tvEnter)
        var etNum1= findViewById<EditText>(R.id.etNum1)
        var etNum2= findViewById<EditText>(R.id.etNum2)
        var btnAdd= findViewById<Button>(R.id.btnAdd)
        var btnSub= findViewById<Button>(R.id.btnSub)
        var btnMult= findViewById<Button>(R.id.btnMult)
        var btnDiv= findViewById<Button>(R.id.btnDiv)
        var btnSquRoot= findViewById<Button>(R.id.btnSquRoot)
        var btnStats= findViewById<Button>(R.id.btnStats)
        var tvAnswer= findViewById<TextView>(R.id.tvAnswer)
        var etResult= findViewById<EditText>(R.id.etResult)

        //calculate addition
        btnAdd.setOnClickListener {
        var Result= etNum1.text.toString().toInt() + etNum2.text.toString().toInt()
            var output =  "${etNum1.text.toString()}+${etNum2.text.toString()}=$Result"
            etResult.setText(output.toString())
        }

        btnSub.setOnClickListener {
            var Result= etNum1.text.toString().toInt() - etNum2.text.toString().toInt()
            var output =  "${etNum1.text.toString()}-${etNum2.text.toString()}=$Result"
            etResult.setText(output.toString())
        }

        btnMult.setOnClickListener {
            var Result= etNum1.text.toString().toInt() * etNum2.text.toString().toInt()
            var output =  "${etNum1.text.toString()}x${etNum2.text.toString()}=$Result"
            etResult.setText(output.toString())
        }

        btnDiv.setOnClickListener {
            var Result= etNum1.text.toString().toInt() / etNum2.text.toString().toInt()
            var output =  "${etNum1.text.toString()}÷${etNum2.text.toString()}=$Result"
            etResult.setText(output.toString())
        }
    }
}