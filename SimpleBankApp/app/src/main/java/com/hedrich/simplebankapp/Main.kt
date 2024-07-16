package com.hedrich.simplebankapp

fun main(){
    val hedrichBankAccount = BankAccount("Hedrich Fernando",125000.0)

    hedrichBankAccount.deposit(120000.0)
    hedrichBankAccount.withdraw(20000.0)
    hedrichBankAccount.deposit(10000.0)
    //hedrichBankAccount.displayTransactionHistory()
    hedrichBankAccount.displayBalance()

    val inesBankAccount= BankAccount("Ines Fernando",250000.0)
    inesBankAccount.deposit(10000.0)
    inesBankAccount.withdraw(100.0)
    inesBankAccount.deposit(2500.0)
    inesBankAccount.displayBalance()
}