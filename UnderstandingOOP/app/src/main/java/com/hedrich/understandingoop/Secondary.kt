package com.hedrich.understandingoop

open class Secondary: Primary() {
    override fun role(){
        println("Protector of Family")
    }

    open fun archery(){
        println("Skills in Archery")
    }
}