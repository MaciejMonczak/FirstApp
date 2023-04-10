package com.monczak.firstapp.aaa

class RorAccount (
    private val minMoneyStatus: Double,
    moneyStatus: Double = 0.0,
    accountNumber: Int
) : Account (moneyStatus = moneyStatus, accountNumber = accountNumber) {
    override fun update() {
        if (moneyStatus < minMoneyStatus) {
            println("The limit has been exceeded")
        }
    }



}