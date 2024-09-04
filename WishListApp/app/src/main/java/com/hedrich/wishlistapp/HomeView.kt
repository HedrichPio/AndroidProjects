package com.hedrich.wishlistapp

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hedrich.wishlistapp.data.DummyWish

@OptIn(ExperimentalMaterialApi::class)
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
                    navController.navigate(Screen.AddScreen.route + "/0L")}) {

                Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        }) { innerPadding->

        val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            
            items(wishList.value, key={wish-> wish.id}){
                wish ->

                    val dismissState = rememberDismissState(
                        confirmStateChange = {
                            if(it == DismissValue.DismissedToEnd || it== DismissValue.DismissedToStart){
                                viewModel.deleteWish(wish)
                            }
                            true
                        }
                    )
                
                    SwipeToDismiss(
                        state = dismissState,
                        background = {
                            val color by animateColorAsState( if (dismissState.dismissDirection == DismissDirection.EndToStart) Color.Red else Color.Transparent, label = "Delete" )

                            val alignment = Alignment.CenterEnd
                            
                            Box(
                                Modifier.fillMaxSize().background(color).padding(horizontal = 20.dp),
                                contentAlignment = alignment){
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = Color.White)
                            }
                        },
                        directions = setOf(DismissDirection.EndToStart),
                        dismissThresholds = {FractionalThreshold(1f)},
                        dismissContent = {
                            WishItem(wish = wish, {
                                val id = wish.id
                                navController.navigate(Screen.AddScreen.route + "/$id")})
                        }
                    )
            }
        }
    }
}