package com.example.rockscissorspaper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var playerChoice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRock = findViewById<Button>(R.id.buttonRock)
        buttonRock.setOnClickListener {
            playerChoice = "rock"
            playGame()
        }

        val buttonScissors = findViewById<Button>(R.id.buttonScissors)
        buttonScissors.setOnClickListener {
            playerChoice = "scissors"
            playGame()
        }

        val buttonPaper = findViewById<Button>(R.id.buttonPaper)
        buttonPaper.setOnClickListener {
            playerChoice = "paper"
            playGame()
        }
    }

    private fun playGame() {
        val computerChoice = computerChoice()
        val gameResult = gameResult(playerChoice, computerChoice)

        val intent = Intent(this, SecondActivity::class.java).apply {
            val bundle = Bundle().apply {
                putString("playerChoice", playerChoice)
                putString("computerChoice", computerChoice)
                putString("gameResult", gameResult)
            }
            putExtras(bundle)
        }
        startActivity(intent)
    }

    fun computerChoice(): String {
        val choices = arrayOf("rock", "scissors", "paper")
        val random = Random()
        val index = random.nextInt(choices.size)
        return choices[index]
    }

    fun gameResult(playerChoice: String, computerChoice: String): String {
        if ((playerChoice == "rock" && computerChoice == "paper") ||
            (playerChoice == "scissors" && computerChoice == "rock") ||
            (playerChoice == "paper" && computerChoice == "scissors")
        ) {
            return "Ты проиграл!!"
        } else if ((playerChoice == "paper" && computerChoice == "rock") ||
            (playerChoice == "scissors" && computerChoice == "paper") ||
            (playerChoice == "rock" && computerChoice == "scissors")
        ) {
            return "Ты победил!"
        } else {
            return "Ничья!"
        }
    }
}
