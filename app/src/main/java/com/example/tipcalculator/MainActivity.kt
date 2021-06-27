package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var initialCost = 0.00
    var percentTip: String = ""
    var totalCost: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val costOfMeal: EditText = findViewById(R.id.mealCost)
        val percentSelected: Spinner = findViewById(R.id.percentTipSpinner)
        val tipAmount: Button = findViewById(R.id.calculateButton)
        val result: TextView = findViewById(R.id.totalAmountOwed)

        tipAmount.setOnClickListener {
            val currency = DecimalFormat("$###,###.00")
            initialCost = costOfMeal.text.toString().toDouble()
            percentTip = percentSelected.selectedItem.toString()
            percentTip = percentTip.substring(0,percentTip.length-1)
            totalCost = initialCost + initialCost*(percentTip.toDouble()/100)
            var formattedTotalCost = currency.format(totalCost)

            result.text = "Meal Cost: $initialCost \n " +
                          "$percentTip% Tip Amount: ${(percentTip.toDouble()/100)*initialCost} \n " +
                          "Total Cost: $formattedTotalCost"
        }
    }
}