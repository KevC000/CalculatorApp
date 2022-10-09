package com.yonasoft.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yonasoft.calculatorapp.ui.theme.LightGray
import com.yonasoft.calculatorapp.ui.theme.MediumGray

import com.yonasoft.calculatorapp.ui.theme.Orange
//Composable of the entire Calculator including display and buttons
@Composable
fun Calculator(

    state: CalculatorState,
    buttonSpacing: Dp,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier
){
    Box(modifier = modifier){
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            //Display of the inputs such as numbers and operations.
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            //The buttons for the calculator
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(symbol = "AC",
                    color = LightGray,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick ={
                        onAction(CalculatorAction.Clear)
                    }
                )
                CalculatorButton(symbol = "del",
                    color = LightGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Delete)
                    }
                )
                CalculatorButton(symbol = "/",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(symbol = "7 ",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(7))
                    }
                )
                CalculatorButton(symbol = "8",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(8))
                    }
                )
                CalculatorButton(symbol = "9",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(9))
                    }
                )
                CalculatorButton(symbol = "x",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(symbol = "4",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(4))
                    }
                )
                CalculatorButton(symbol = "5",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(5))
                    }
                )
                CalculatorButton(symbol = "6",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(6))
                    }
                )
                CalculatorButton(symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                )
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(symbol = "1",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(1))
                    }
                )
                CalculatorButton(symbol = "2",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(2))
                    }
                )
                CalculatorButton(symbol = "3",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(3))
                    }
                )
                CalculatorButton(symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalculatorButton(symbol = "0",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick ={
                        onAction(CalculatorAction.Number(0))
                    }
                )
                CalculatorButton(symbol = ".",
                    color = Color.DarkGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Decimal)
                    }
                )
                CalculatorButton(symbol = "=",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }
        }
    }
}

