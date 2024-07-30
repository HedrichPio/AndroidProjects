package com.hedrich.understandingoop

open class Tertiary: Primary() {
    override fun role() {
        println("Caretaker of Family")
    }

    open fun cook(){
        println("Skills in Cooking")
    }
}