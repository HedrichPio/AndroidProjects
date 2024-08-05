package com.hedrich.receipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ReceipeScreen(modifier: Modifier=Modifier){

    val receipeViewModel:MainViewModel  = viewModel()
    val viewState by receipeViewModel.categoryState

    Box(modifier = Modifier.fillMaxSize()) {
        when{
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error!=null ->{
                Text("ERROR OCCURRED")
            }else->{

            }
        }
    }

}