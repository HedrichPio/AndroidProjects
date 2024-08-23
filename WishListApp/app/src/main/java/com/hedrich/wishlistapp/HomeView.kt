package com.hedrich.wishlistapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeView(modifier:Modifier){
    Scaffold(topBar = {AppBarView(title = "Wishlist")}, modifier=modifier) { innerPadding->

        LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

        }
    }
}