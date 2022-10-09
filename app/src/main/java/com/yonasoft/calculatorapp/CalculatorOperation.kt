package com.yonasoft.calculatorapp
//Possible math operations of the calculator
sealed class CalculatorOperation(val symbol:String){
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("*")
    object Divide: CalculatorOperation("/")
}
