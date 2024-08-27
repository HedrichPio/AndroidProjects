package com.hedrich.wishlistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    viewModel: WishViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController(),
    modifier: Modifier){

    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route){ HomeView(modifier)}
    }
}