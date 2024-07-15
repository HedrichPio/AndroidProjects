package com.hedrich.kotlinbasics

fun main(){
//    println("Hello World!")
//    val name= "Hedrich"
//    val myBirthYear : Short = 1999
//    var myAge : Byte = 25
//    var day = 30
//
//    var pi = 3.142f
//    var doublePi = 3.142
//
//    println("Hello $name")
//
//
//
//    val age = readln().toInt()
//
//    if(age>=18){
//        println("Entrance Allowed!")
//    }else{
//        println("Entrance Denied!")
//    }

    var count = 0
    while(count<3){
        println("Count is $count")
        count+=1
    }

    println("Please Enter a number")
    var userInput = readln().toInt()


    println("Starting at level 1")
    while (userInput!=0){
        userInput = readln().toInt()
        println("Continuing to next level")
    }
    println("Reached the end")


}





fun add(num1:Int,num2:Int):Int{
    val result = num1+num2
    return result
}



