package com.monczak.firstapp.Bank

abstract class Account(
    protected var moneyStatus: Double = 0.0,
    private var accountNumber: Int
) {

    fun putToAccount(amount: Double) {
        if (amount > 0) {
            moneyStatus += amount
        } else {
            println("Nie mozna wplacic takiej kwoty!")
        }
    }

    fun getMeMoney(amount: Double) {
        if (amount > 0) {
            moneyStatus -= amount // stan może być ujemny!
        } else {
            println("Nie mozna wyplacic takiej kwoty!")
        }
    }

    fun getCurrentStage(): Double = moneyStatus

    fun getNumber(): Int = accountNumber

    abstract fun update()

}