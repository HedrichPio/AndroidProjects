package com.hedrich.receipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ReceipeApp(navController: NavHostController){

    val receipeViewModel: MainViewModel= viewModel()
    val viewState by receipeViewModel.categoryState
    
    NavHost(navController = navController, startDestination = Screen.ReceipeScreen.route) {
        composable(route = Screen.ReceipeScreen.route){
            ReceipeScreen (
                viewState = viewState ,
                navigateToDetail = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                    navController.navigate(Screen.DetailScreen.route)
            })
        }

        composable(route = Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }
}