package me.sjcl.drivecheckin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import me.sjcl.drivecheckin.navigation.DriveCheckinNavHost
import me.sjcl.drivecheckin.ui.theme.DriveCheckinTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DriveCheckinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DriveCheckinNavHost(navHostController = navController)
                }
            }
        }

        val locationProvider = LocationProvider(this)
        if (!locationProvider.hasPermission()) {
            locationProvider.requestPermissionAndGetLocation()
        }
    }
}