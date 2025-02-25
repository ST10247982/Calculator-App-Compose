package com.calculator


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.lifecycle.viewmodel.compose.viewModel
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
                        .fillMaxSize(),

                    ) {

                    Calculator()

                }
            }
        }
    }
}


@Composable
fun CalculateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel,
) {
    ElevatedButton(onClick = { viewModel.calculate() }) {
        Text("Add")
    }
}

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()  // this is with dependancy injection to create a scope, previously we made multiple instances for each composable

) {

    Box(
        modifier.fillMaxSize(),// we have to set this to fill the max size to take up the page
        contentAlignment = Alignment.Center
    ) {     // we use this to shift the box to the center

        Column(
            modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Center
        ) {
            Row(
                modifier.padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically

            ) {
                OutlinedTextField(
                    value = viewModel.inputOne,
                    onValueChange = { viewModel.inputOne = it },
                    label = { Text(stringResource(R.string.input_one)) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),


                    )
                // Spacer(modifier = Modifier.width(16.dp)) // we can use this to add gaps in between
                OutlinedTextField(
                    value = viewModel.inputTwo,
                    onValueChange = { viewModel.inputTwo = it },
                    label = { Text(stringResource(R.string.input_two)) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )
            }

            Text(
                text = viewModel.result,


                )
            CalculateButton(
                onClick = { viewModel.calculate() },
                viewModel = viewModel


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
                .fillMaxSize(),

            ) {

            Calculator(viewModel = CalculatorViewModel())

        }

    }
}