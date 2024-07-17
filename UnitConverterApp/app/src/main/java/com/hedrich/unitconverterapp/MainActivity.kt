package com.hedrich.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hedrich.unitconverterapp.ui.theme.UnitConverterAppTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    UnitConverter(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}


@Composable
fun UnitConverter(modifier: Modifier = Modifier){

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }

    var dropOne by remember { mutableStateOf(false) }
    var dropTwo by remember { mutableStateOf(false) }

    var inMultiplier by remember { mutableStateOf(1.0) }
    var outMultiplier by remember { mutableStateOf(1.0) }

    var inputUnit by remember { mutableStateOf("m") }
    var outputUnit by remember { mutableStateOf("m") }

    var dropOneText by remember {mutableStateOf("Select") }
    var dropTwoText by remember {mutableStateOf("Select") }

    fun convert(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val valueInMetres = (inputValueDouble * inMultiplier * 100.0).roundToInt() / 100.0
        outputValue = (valueInMetres * outMultiplier).toString()
    }

    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue=it
                convert()},
            label = {Text(text = "Enter Value")})

        Spacer(modifier = Modifier.height(16.dp))

        Row {

            Box {
                Button(onClick = { dropOne=true }) {
                    Text(text = dropOneText)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")}

                DropdownMenu(expanded = dropOne, onDismissRequest = { dropOne=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        dropOne=false
                        dropOneText="cm"
                        inputUnit="cm"
                        inMultiplier=0.01
                        convert() })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        dropOne=false
                        dropOneText="m"
                        inputUnit="m"
                        inMultiplier=1.0
                        convert()})
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        dropOne=false
                        dropOneText="ft"
                        inputUnit="ft"
                        inMultiplier=0.3048
                        convert()})
                    DropdownMenuItem(text = { Text(text = "Milimeters") }, onClick = {
                        dropOne=false
                        dropOneText="mm"
                        inputUnit="mm"
                        inMultiplier=0.001
                        convert()})
                }
            }
            Spacer(modifier = Modifier.width(16.dp))

            Box {
                Button(onClick = { dropTwo=true }) {
                    Text(text = dropTwoText)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")}

                DropdownMenu(expanded = dropTwo, onDismissRequest = { dropTwo=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        dropTwo=false
                        dropTwoText="cm"
                        outputUnit="cm"
                        outMultiplier=100.0
                        convert()})
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        dropTwo=false
                        dropTwoText="m"
                        outputUnit="m"
                        outMultiplier=1.0
                        convert()})
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        dropTwo=false
                        dropTwoText="ft"
                        outputUnit="ft"
                        outMultiplier=3.280839895
                        convert()})
                    DropdownMenuItem(text = { Text(text = "Milimeters") }, onClick = {
                        dropTwo=false
                        dropTwoText="mm"
                        outputUnit="mm"
                        outMultiplier=1000.0
                        convert()})
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: $outputValue $outputUnit")
    }
}





@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}