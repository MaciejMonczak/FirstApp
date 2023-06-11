package com.monczak.firstapp.bank

class Bank () {
    val accountsList: MutableList<Account> = mutableListOf()

    fun createAccount(account: Account) {
        accountsList.add(account)
    }

    fun updateAccounts() : Bank {
        val newBank = Bank()
        accountsList.forEach { account: Account ->
            account.update()
            newBank.createAccount(account)
            println("Aktualny status konta o numerze ${account.getNumber()} to: ${account.getCurrentStage()}")
        }

        return newBank
    }


}