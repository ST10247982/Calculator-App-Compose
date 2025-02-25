package com.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.calculator.ui.theme.CalculatorTheme

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {

            }
        }
    }
}

@Composable
fun LoginText(welcomeMessage: String, modifier: Modifier = Modifier) {
    Text(
        text = welcomeMessage ,
        modifier = modifier
    )
}
@Composable
fun RegisterInput(,modifier: Modifier = Modifier){
    Column {
        OutlinedTextField(

        )    // this will be the email
        OutlinedTextField()    // passWord    password
        OutlinedTextField()    // this will be the dateOfBirth
        OutlinedTextField()    //confirmPassword
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    CalculatorTheme {
        Greeting2("Android")
    }
}