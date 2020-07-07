package com.allykim.tipcalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //all new code should be below override fun

        //change background color
//        window.decorView.setBackgroundColor(Color.RED)

        //text in infotextview will disappear as soon as the app opens up
        infoTextView.visibility = View.INVISIBLE

        //setOnClickListener {} will excute all code inside {} once calculateButton is clicked.
        calculateButton.setOnClickListener {
            //Bill
            // get text property and turn it to string and then turn it into double. val is immutable
            val bill =  billEditText.text.toString().toDouble()
            //Tip Percentage
            val tipPercentage = tipPercentageEditText.text.toString().toDouble() / 100

            //Tip
            val tip = bill * tipPercentage

            //Total
            val total = tip + bill

            //Make the infoText visible
            infoTextView.visibility = View.VISIBLE

            // Set info text
            // if $ is in string then we need to add \ in front of $.
            // "abc ${} def ${}" is also working for the same purpose
            //infoTextView.text = "Tip: \$" + tip + " Total: \$" + total is equal to the below code


            infoTextView.text = "Tip: ${doubleToDollar(tip)} total: ${doubleToDollar(total)}"
        }

    }

    //show number with two decimal points format("%.2f")  number can be other noun
    fun doubleToDollar(numberrr:Double): String {
        return "$" + String.format("%.2f",numberrr)
    }
}
