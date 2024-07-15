package com.hedrich.simplebankapp

fun main(){
    val hedrichBankAccount = BankAccount("Hedrich Fernando",125000.0)

    hedrichBankAccount.deposit(120000.0)
    hedrichBankAccount.withdraw(20000.0)
    hedrichBankAccount.deposit(10000.0)
    hedrichBankAccount.displayTransactionHistory()
}