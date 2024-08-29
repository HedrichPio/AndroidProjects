package com.hedrich.wishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier){

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route){
            HomeView(modifier, navController,viewModel )}

        composable(Screen.AddScreen.route){
            AddEditDetailView(id = 0L, viewModel = viewModel, navController = navController, modifier = modifier )}
    }
}