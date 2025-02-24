package com.calculator


import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

                    }
                }
            }
        }
    }
}
@Composable
fun AddButton(onClick: () -> Unit, modifier: Modifier = Modifier,viewModel: CalculatorViewModel = CalculatorViewModel()) {
    ElevatedButton(onClick = {viewModel.calculate()}) {
        Text("Add")
    }
}

@Composable
fun Calculator(
    viewModel: CalculatorViewModel = CalculatorViewModel(),
    modifier: Modifier = Modifier
) {

    Box {
        Row(
            Modifier
                .align(Alignment.Center)
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                value = viewModel.inputOne,
                onValueChange = { viewModel.inputOne = it },
                label = { Text(stringResource(R.string.input_one)) },
                modifier = Modifier.weight(1f)

            )
            Spacer(modifier = Modifier.width(16.dp)) // we can use this to add gaps in between
            OutlinedTextField(
                value = viewModel.inputTwo,
                onValueChange = { viewModel.inputTwo = it },
                label = { Text(stringResource(R.string.input_two)) },
                modifier = Modifier.weight(1f)
            )
        }

    }
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

            Calculator()

        }

    }
}