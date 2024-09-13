package com.hedrich.musicappui.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.TextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountDialog(dialogOpen:MutableState<Boolean>){

    if (dialogOpen.value){
        AlertDialog(
            title = { Text(text = "Add Account")},
            text = {
                Column(modifier= Modifier
                    .wrapContentHeight()
                    .padding(top = 16.dp), verticalArrangement = Arrangement.Center) {
                    TextField(value = "", onValueChange = {})
                }
            },
            onDismissRequest = { dialogOpen.value = false },
            confirmButton = { 
                TextButton(onClick = { dialogOpen.value = false }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { dialogOpen.value=false}) {
                    Text(text = "Dismiss")
                }
            })
    }
}
