package com.hedrich.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeView(modifier:Modifier){
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppBarView(
                title = "Wishlist",
                { Toast.makeText(context,"Button Clicked", Toast.LENGTH_LONG).show() }) },

        modifier=modifier) { innerPadding->

        LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

        }
    }
}