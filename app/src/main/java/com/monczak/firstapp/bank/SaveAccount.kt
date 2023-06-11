package com.monczak.firstapp.bank

class SaveAccount (
    private val interest: Double,
    moneyStatus: Double = 0.0,
    accountNumber: Int
) : Account (moneyStatus = moneyStatus, accountNumber = accountNumber) {
    override fun update() {
        moneyStatus += (moneyStatus * interest)
    }



}