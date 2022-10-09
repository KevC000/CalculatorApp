package com.yonasoft.calculatorapp

//Possible actions of the calculator buttons.

sealed class CalculatorAction{
    //Numbers or operations will have an argument for the variable number of possible inputs it can be.
    data class Number(val number:Int):CalculatorAction()
    data class Operation(val operation: CalculatorOperation):CalculatorAction()

    object Clear:CalculatorAction()
    object Delete:CalculatorAction()
    object Decimal:CalculatorAction()
    object Calculate: CalculatorAction()

}
