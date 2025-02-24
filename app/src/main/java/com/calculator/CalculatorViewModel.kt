package com.calculator


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel() {   // we will pass this view model into the app to make a calculator
    var inputOne by  mutableStateOf("")    // making this a mutable state
    var inputTwo by mutableStateOf("")
    var result by mutableStateOf("")

    fun calculate(){       // this will fetch the numbers and add them together
        val num1 = inputOne.toDoubleOrNull()?:0.0
        val num2 = inputTwo.toDoubleOrNull()?:0.0
        result = (num1+num2).toString()

    }

}