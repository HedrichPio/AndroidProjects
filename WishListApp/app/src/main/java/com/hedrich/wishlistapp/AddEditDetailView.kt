package com.hedrich.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hedrich.wishlistapp.data.Wish
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailView(id:Long,viewModel: WishViewModel,navController: NavController, modifier: Modifier){
    val context = LocalContext.current

    val snackMessage = remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if (id != 0L){
        val wish = viewModel.getWishById(id).collectAsState(initial = Wish(0L,"",""))
        viewModel.wishTitleState = wish.value.title
        viewModel.wishDescriptionState = wish.value.description
    }
    else{
        viewModel.wishTitleState=""
        viewModel.wishDescriptionState=""
    }

    Scaffold(
        modifier = modifier,
        scaffoldState=scaffoldState,
        topBar = {
            AppBarView(
                title = if(id!= 0L) "Update Wish" else "Add Wish",
                onBackNavClicked = {
                    Toast.makeText(context,"Back Clicked", Toast.LENGTH_LONG).show()
                    navController.navigateUp()}
            )
        }
    ){

        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(
                label = "Title",
                value = viewModel.wishTitleState,
                onValueChanged = {viewModel.onWishTitleChanged(it)})

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(
                label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChanged = {viewModel.onWishDescriptionChanged(it)})

            Spacer(modifier = Modifier.height(10.dp))
            
            Button(
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                onClick = {
                    if(viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()){
                        if(id!=0L){
                            viewModel.updateWish( Wish(id=id, title = viewModel.wishTitleState.trim(), description = viewModel.wishDescriptionState.trim()))
                        }else{
                            viewModel.addWish(
                                Wish ( title = viewModel.wishTitleState.trim(), description = viewModel.wishDescriptionState.trim() ))

                            snackMessage.value = "Wish has been created"
                        }

                    }else{
                        snackMessage.value="Enter fields to create a wish"
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                        navController.navigateUp()
                    }
                }){
                Text(
                    text = if (id != 0L) "Update" else "Add",
                    style = TextStyle(fontSize = 18.sp))
            }
        }
    }
}

@Composable
fun WishTextField(label:String, value:String, onValueChanged:(String)->Unit){

    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label, color = Color.Black)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            // example of using own colors
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = Color.Black,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black)
    )


    
}