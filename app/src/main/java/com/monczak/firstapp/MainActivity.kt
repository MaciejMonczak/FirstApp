package com.monczak.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.monczak.firstapp.bank.Bank
import com.monczak.firstapp.bank.SaveAccount
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
        val tempBank = Bank()
        tempBank.createAccount(SaveAccount(1.0, 10.0, 1))
        tempBank.createAccount(SaveAccount(0.1, 40.0, 2))
        tempBank.createAccount(SaveAccount(0.5, 50.0, 3))

        val bank = remember { mutableStateOf(tempBank) }
//        bank.value.createAccount(SaveAccount(1.0, 10.0, 1))
//        bank.value.createAccount(SaveAccount(0.1, 40.0, 2))
//        bank.value.createAccount(SaveAccount(0.5, 50.0, 3))
//        bank.value.createAccount(RorAccount(10.0, 50.0, 4))
//        bank.value.createAccount(RorAccount(10.0, 10.0, 5))
//        bank.value.createAccount(RorAccount(9.0, 3.0, 6))



        Column {
            AccountList(bank = bank)
            UpdateButton(bank = bank)
        }

    }
}

@Composable
fun AccountList(bank: MutableState<Bank>) {
    LazyColumn {
        bank.value.accountsList.forEach {
        item {
            Text("Account ${it.getNumber()} status: ${it.getCurrentStage()}")
        }
        }
    }
}


@Composable
fun UpdateButton(bank: MutableState<Bank>) {
    Button(onClick = {
        bank.value = bank.value.updateAccounts()
        //createAccount(SaveAccount(1.0, 10.0, 1))

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