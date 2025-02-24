class CalculatorViewModel : ViewModel() {
    var input1 by mutableStateOf("")
    var input2 by mutableStateOf("")
    var result by mutableStateOf("")

    fun calculate() {
        val num1 = input1.toDoubleOrNull() ?: 0.0
        val num2 = input2.toDoubleOrNull() ?: 0.0
        result = (num1 + num2).toString()
    }
}