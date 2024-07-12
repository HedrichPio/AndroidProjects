package com.hedrich.rockpaperscissor

fun main(){
    println("Initiating Game Rock Paper Scissor...")
    println("Please enter your choice :")

    val playerChoice = readln().toString()

    val randomNumber = (1..3).random()

    var computerChoice = ""

    when(randomNumber){
        1->{computerChoice="rock"}
        2->{computerChoice="paper"}
        3->{computerChoice="scissor"}
    }

    val winner = when{
        playerChoice==computerChoice-> "Tie"
        playerChoice=="Rock" && computerChoice=="Scissor"-> "Player"
        playerChoice=="Paper" && computerChoice=="Rock" -> "Player"
        playerChoice=="Scissor" && computerChoice=="Paper"-> "Player"
        else -> {"Computer"}
    }

    println("$winner Wins !!!")

}