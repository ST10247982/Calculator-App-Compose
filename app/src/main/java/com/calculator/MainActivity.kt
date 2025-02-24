package com.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxSize()
                ) {
                    Column {
                        InputOne()
                    }
                }
            }
        }
    }
}

@Composable
fun InputOne() {
    var text = remember { mutableStateOf("|") }
    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text("|") },

    )
    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text("Input Two") }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Surface(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
        ) {
            Column {
                InputOne()
            }
        }

    }
}