package com.hedrich.kotlinbasics

fun main(){
    println("Hello World!")
    val name= "Hedrich"
    val myBirthYear : Short = 1999
    var myAge : Byte = 25
    var day = 30

    var pi = 3.142f
    var doublePi = 3.142

    println("Hello $name")



    val age = readln().toInt()

    if(age>=18){
        println("Entrance Allowed!")
    }else{
        println("Entrance Denied!")
    }
}

