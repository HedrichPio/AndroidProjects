package com.hedrich.simplebankapp

class BankAccount(
    val accountHolder:String,
    var balance:Double) {

    private var transactionHistory = mutableListOf<String>()

    fun deposit(amount:Double){
        balance+=amount
        transactionHistory.add("$accountHolder Deposited $$amount")

    }

    fun withdraw(amount:Double){
        if (amount<=balance) {
            balance -= amount
            transactionHistory.add("$accountHolder withdrew $$amount")
        }
        else {
            println("Insufficient funds")
        }
    }

    fun getTransactionHistory():List<String>{
        return transactionHistory
    }

    fun accBalance():Double{
        return balance
    }

    fun displayBalance(){
        println("$accountHolder's balance is $balance")
    }

    fun displayTransactionHistory(){
        println("Transaction History...")
        for(transaction in transactionHistory) {
            println(transaction)
        }
    }
}