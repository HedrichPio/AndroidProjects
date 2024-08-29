package com.hedrich.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hedrich.wishlistapp.data.DummyWish

@Composable
fun HomeView(modifier:Modifier,navController: NavController,viewModel: WishViewModel){
    val context = LocalContext.current
    Scaffold(
        modifier=modifier,

        topBar = {
            AppBarView(
                title = "Wishlist"
            )
         },

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                backgroundColor = Color.Black,
                onClick = {
                    Toast.makeText(context,"Plus Button Clicked", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.AddScreen.route)}) {

                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        }) { innerPadding->

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            
            items(DummyWish.wishList){
                wish -> WishItem(wish = wish, { })
            }
            
        }
    }
}