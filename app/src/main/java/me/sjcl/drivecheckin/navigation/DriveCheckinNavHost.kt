package me.sjcl.drivecheckin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.sjcl.drivecheckin.ui.home.HomeScreen

@Composable
fun DriveCheckinNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "screen1"
    ) {
        composable("screen1") {
            HomeScreen()
        }
    }

}