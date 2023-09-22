package com.example.rockscissorspaper

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewPlayerChoice = findViewById<TextView>(R.id.textViewPlayerChoice)
        val textViewComputerChoice = findViewById<TextView>(R.id.textViewComputerChoice)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        val bundle: Bundle? = intent.extras

        if (bundle != null) {
            val playerChoice = bundle.getString("playerChoice")
            val computerChoice = bundle.getString("computerChoice")
            val gameResult = bundle.getString("gameResult")

            textViewPlayerChoice.text = "Your Choice: $playerChoice"
            textViewComputerChoice.text = "Computer's Choice: $computerChoice"
            textViewResult.text = "Result: $gameResult"
        }
    }
}
