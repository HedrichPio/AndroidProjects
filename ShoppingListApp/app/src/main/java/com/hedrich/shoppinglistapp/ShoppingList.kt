package com.hedrich.shoppinglistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    val id:Int,
    val name:String,
    var quantity:Int,
    var isEditing:Boolean=false
)

@Composable
fun ShoppingListApp(modifier: Modifier){
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQty by remember { mutableStateOf("") }
    
    Column(modifier = modifier, verticalArrangement = Arrangement.Center){
        Button(onClick = {showDialog=true }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Add Item")
        }
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            items(sItems){}
        }
    }

    if(showDialog){
        AlertDialog(
            onDismissRequest = { showDialog=false },
            confirmButton = {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Cancel")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Add")
                    }
                }
            },
            title = {Text(text = "Add Shopping Item")},
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = {itemName=it},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        label = { Text(text = "Enter Item Name")})
                    OutlinedTextField(
                        value = itemQty,
                        onValueChange = {itemQty=it},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        label = { Text(text = "Enter Quantity")})
                }
            })
    }
}