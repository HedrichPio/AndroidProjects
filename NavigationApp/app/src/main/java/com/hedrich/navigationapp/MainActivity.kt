package com.hedrich.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hedrich.navigationapp.ui.theme.NavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {

                    MyApp()

                }
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen"){
            FirstScreen ( {name,age -> navController.navigate("secondScreen/$name$age")} )
        }
        composable("secondScreen/{name}{age}"){
            val name = it.arguments?.getString("name")?: "no name"
            val age = it.arguments?.getString("age")?:"0"
            SecondScreen( name,age, {navController.navigate("firstScreen")} )
        }
    }
}



@Composable
fun FirstScreen(navigateToSecondScreen:(name:String, age:String)->Unit){

    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Welcome", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = { name.value=it } )
        OutlinedTextField(value = age.value, onValueChange = { age.value=it } )
        Button(onClick = { navigateToSecondScreen(name.value, age.value) }) {
            Text(text = "Go to Second Screen")
        }
    }
}

@Composable
fun SecondScreen(name:String, age:String, navigateToFirstScreen:()->Unit){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Hi $name you have navigated to the Second Screen", fontSize = 24.sp)
        Text(text = "Entered Age : $age", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navigateToFirstScreen() }) {
            Text(text = "Go to First Screen")
        }
    }
}