package com.hedrich.receipeapp

sealed class Screen(val route:String) {
    object ReceipeScreen:Screen("receipeScreen")
    object DetailScreen:Screen("detailScreen")
}