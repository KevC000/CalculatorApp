package com.yonasoft.calculatorapp

//State of the number input and operations
data class CalculatorState(
    //First numerical input
    val number1: String = "",
    //Second numerical input
    val number2: String = "",
    //Operation to be performed
    val operation:CalculatorOperation?= null
)