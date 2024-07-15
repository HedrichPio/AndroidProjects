package com.hedrich.kotlinbasics

data class CoffeeDetails(
    val name: String,
    val sugarCount: UInt,
    val size:String,
    val creamAmount:UShort)

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
//-----------------------------------------------
//    val age = readln().toInt()
//
//    if(age>=18){
//        println("Entrance Allowed!")
//    }else{
//        println("Entrance Denied!")
//    }
//-----------------------------------------------
//    var count = 0
//    while(count<3){
//        println("Count is $count")
//        count+=1
//    }
//-----------------------------------------------
//    println("Please Enter a number")
//    var userInput = readln().toInt()
//
//    println("Starting at level 1")
//    while (userInput!=0){
//        userInput = readln().toInt()
//        println("Continuing to next level")
//    }
//    println("Reached the end")

//--------------------------------------------------

//    makeCoffee("Ines",1U)
//    makeCoffee("Hedrich",2U)
//    makeCoffee("Pio",0U)

//--------------------------------------------------
//    println("Whose coffee is this?")
//    val name= readln().toString()
//
//    println("How many sugar cubes")
//    val sugarCubes= readln().toUInt()
//
//    makeCoffee(name,sugarCubes)

//--------------------------------------------------

//    val result = add(5,10)
//    println(result)

//--------------------------------------------------
//    println("Enter number 1:")
//    val num1 = readln().toInt()
//    println("Enter number 2:")
//    val num2 = readln().toInt()
//
//    println("The result of $num1 + $num2 is ${add(num1,num2)}")

//---------------------------------------------------
//    val smilie = Dog("Smilie","Mix")
//    println("${smilie.name} is a ${smilie.breed}")
//
//    val myBook = Book()
//    println("The Book ${myBook.title} was written by ${myBook.author} in ${myBook.yearPublished}")
//
//    val customBook = Book("Harry Potter","J.K.Rowling",1999U)
//    println("The Book ${customBook.title} was written by ${customBook.author} in ${customBook.yearPublished}")

//    val coffeeForHedrich = CoffeeDetails("Hedrich",2U,"M",2U)
//    makeCoffeeWithObj(coffeeForHedrich)

    // immutable list
    val shoppingList = listOf("Processor","RAM")

    // mutable list
    val shoppingListM = mutableListOf<String>("Hard Disk","Graphics Card RTX 3060","RAM")

    // add items
    shoppingListM.add("Cooling System")
    shoppingListM.remove("Graphics Card RTX 3060")
    shoppingListM.add("Graphics Card RTX 4090")

    shoppingListM.set(1,"Water Cooling")


    println(shoppingListM)

    for(item in shoppingListM){
        println(item)
    }

//    for (i in 0 until shoppingListM.size ){
//        println(shoppingListM[i])
//    }
//
//    for (i in 0..9){
//
//    }
}

fun makeCoffeeWithObj(coffee:CoffeeDetails){
    println("Making ${coffee.name}'s Coffee")
    if(coffee.sugarCount==1U){
        println("Added ${coffee.sugarCount} sugar cube")
    }else if (coffee.sugarCount==0U){
        println("Added no sugar cubes")
    }
    else{
        println("Added ${coffee.sugarCount} sugar cubes")
    }
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



