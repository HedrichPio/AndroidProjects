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

//    var count = 0
//    while(count<3){
//        println("Count is $count")
//        count+=1
//    }
//
//    println("Please Enter a number")
//    var userInput = readln().toInt()
//
//
//    println("Starting at level 1")
//    while (userInput!=0){
//        userInput = readln().toInt()
//        println("Continuing to next level")
//    }
//    println("Reached the end")

    //--------------------------------------------------
    makeCoffee("Ines",1U)
    makeCoffee("Hedrich",2U)
    makeCoffee("Pio",0U)

    //--------------------------------------------------
    println("Whose coffee is this?")
    val name= readln().toString()

    println("How many sugar cubes")
    val sugarCubes= readln().toUInt()

    makeCoffee(name,sugarCubes)

//--------------------------------------------------

    val result = add(5,10)
    println(result)

//--------------------------------------------------
    println("Enter number 1:")
    val num1 = readln().toInt()
    println("Enter number 2:")
    val num2 = readln().toInt()

    println("The result of $num1 + $num2 is ${add(num1,num2)}")

//---------------------------------------------------
    val smilie = Dog("Smilie","Mix")
    println("${smilie.name} is a ${smilie.breed}")



}

fun makeCoffee(name:String, sugarCount: UInt){
    println("Making $name's Coffee")
    if(sugarCount==1U){
        println("Added $sugarCount sugar cube")
    }else if (sugarCount==0U){
        println("Added no sugar cubes")
    }
    else{
        println("Added $sugarCount sugar cubes")
    }
}



fun add(num1:Int,num2:Int):Int{
    val result = num1+num2
    return result
}



