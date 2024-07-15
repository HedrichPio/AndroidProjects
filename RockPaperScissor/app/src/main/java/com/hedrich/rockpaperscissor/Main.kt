package com.hedrich.rockpaperscissor

fun main() {

    println("Initiating Game Rock Paper Scissor...")
    println("Please enter your choice :")

    val playerChoice = readln().toString()
    var computerChoice = ""

    val randomNumber = (1..3).random()

    when (randomNumber) {
        1 -> {
            computerChoice = "Rock"
        }

        2 -> {
            computerChoice = "Paper"
        }

        3 -> {
            computerChoice = "Scissor"
        }
    }

    val winner = when {
        playerChoice == computerChoice -> "Tie"
        playerChoice == "Rock" && computerChoice == "Scissor" -> "Player"
        playerChoice == "Paper" && computerChoice == "Rock" -> "Player"
        playerChoice == "Scissor" && computerChoice == "Paper" -> "Player"
        else -> {
            "Computer"
        }
    }

    if (winner == "Tie") {
        println("Game Tied")
    } else {
        println("$winner Wins !!!")
    }

}