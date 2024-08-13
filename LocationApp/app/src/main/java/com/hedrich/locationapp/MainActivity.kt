package com.hedrich.locationapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hedrich.locationapp.ui.theme.LocationAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import android.Manifest
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel:LocationViewModel= viewModel()
            LocationAppTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    MyApp(viewModel)
                }
            }
        }
    }
}


@Composable
fun MyApp(viewModel:LocationViewModel){

    //context of current activity
    val context= LocalContext.current

    val locationUtils = LocationUtils(context)


    
    OnLocationDisplay(locationUtils = locationUtils, viewModel, context = context)
}

@Composable
fun OnLocationDisplay(locationUtils: LocationUtils, viewModel: LocationViewModel, context: Context){

    val location = viewModel.location.value

    // this block of code can be used without any changes in future apps, new permissions can be added as required.
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION]==true
                && permissions[Manifest.permission.ACCESS_FINE_LOCATION]==true ){

                locationUtils.requestLocationUpdates(viewModel=viewModel)
            }else{
                val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                        || ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION)

                if(rationaleRequired){
                    Toast.makeText(context,"Location Permission is required for this feature to work",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Location Permission is required. Enable in Android Settings",Toast.LENGTH_LONG).show()
                }
            }
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        if(location!=null){
            Text("Address:${location.latitude} ${location.longitude}")
        }else{
            Text(text = "Location not available")
        }

        Button(onClick = { if (locationUtils.hasLocationPermission(context)){
            //Permission granted, update the location
            locationUtils.requestLocationUpdates(viewModel)
        }else{
            //Request Permission
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
        }) {
            Text(text = "Get Location")
        }

    }
}