package com.monczak.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.monczak.firstapp.aaa.Bank
import com.monczak.firstapp.aaa.RorAccount
import com.monczak.firstapp.aaa.SaveAccount
import com.monczak.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAppTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val bank = Bank()
        bank.createAccount(SaveAccount(1.0, 10.0, 1))
        bank.createAccount(SaveAccount(0.1, 40.0, 2))
        bank.createAccount(SaveAccount(0.5, 50.0, 3))
        bank.createAccount(RorAccount(10.0, 50.0, 4))
        bank.createAccount(RorAccount(10.0, 10.0, 5))
        bank.createAccount(RorAccount(9.0, 3.0, 6))

        Column {
            AccountList(bank = bank)
            bank.updateAccounts()
            Text(text = "Accounts after update")
            AccountList(bank = bank)
            UpdateButton(bank = bank)
        }
    }
}

@Composable
fun AccountList(bank: Bank) {
    bank.PresentAccounts()
}

@Composable
fun UpdateButton(bank: Bank) {
    Button(onClick = {
        bank.updateAccounts()
    }) {
        Text(text = "Update")
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.DarkGray) {
        Text(text = "Hello $name!", modifier = Modifier.padding(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstAppTheme {
        Screen()
    }
}