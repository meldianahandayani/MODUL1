package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dice1: ImageView
    private lateinit var dice2: ImageView
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice1 = findViewById(R.id.dice1)
        dice2 = findViewById(R.id.dice2)
        resultTextView = findViewById(R.id.resultTextView)
        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice1Value = (1..6).random()
        val dice2Value = (1..6).random()

        val dice1Image = resources.getIdentifier("dice_$dice1Value", "drawable", packageName)
        val dice2Image = resources.getIdentifier("dice_$dice2Value", "drawable", packageName)

        dice1.setImageResource(dice1Image)
        dice2.setImageResource(dice2Image)

        if (dice1Value == dice2Value) {
            resultTextView.text = "Selamat anda dapat dadu double!"
        } else {
            resultTextView.text = "Anda belum beruntung!"
        }
    }
}
