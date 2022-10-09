package com.yonasoft.calculatorapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//View model to handle data and actions
class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    //Perform calculator operation based on input
    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    //Operation such as *,/,+,-
    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    //Calculate based on current number1 number2 and operation inputs
    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        //Calculate based on operation
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }
            //Updates current input to number 1
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    //Delete last input
    private fun performDeletion() {
        when {
            //Last input in number2
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            //Last input is an operation
            state.operation != null -> state.copy(operation = null)
            //Last input is number1
            state.number1.isNotBlank() -> state.copy(number1 = state.number1.dropLast(1))

        }
    }

    //Inputs decimal
    private fun enterDecimal() {
        //Inputs decimal for number 1 if:
        //1. There is no operation input
        //2. There isn't a decimal already in number1
        //3. Number 1 is not blank
        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        //Inputs decimal for number 2 if:
        //1. There isn't a decimal already in number 2
        //2. Number 1 is not blank
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
            return
        }
    }

    //Inputs number to calculator
    private fun enterNumber(number: Int) {
        //Append number to number 1 if there is no operator already
        //Append number to number 2 if there is an operator already
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        //Max length allows of number for the input
        private const val MAX_NUM_LENGTH = 8
    }
}