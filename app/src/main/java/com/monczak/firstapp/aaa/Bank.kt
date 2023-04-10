package com.monczak.firstapp.aaa

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Bank () {
    private val accountsList: MutableList<Account> = mutableListOf()

    fun createAccount(account: Account) {
        accountsList.add(account)
    }

    fun updateAccounts() {
        accountsList.forEach { account: Account ->
            account.update()
            println("Aktualny status konta o numerze ${account.getNumber()} to: ${account.getCurrentStage()}")
        }
    }

    @Composable
    fun PresentAccounts() {
        Column {
            accountsList.forEach {
                Text("Account ${it.getNumber()} status: ${it.getCurrentStage()}")
            }
        }
    }
}