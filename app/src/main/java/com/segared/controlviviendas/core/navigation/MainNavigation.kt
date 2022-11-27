package com.segared.controlviviendas.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.segared.controlviviendas.usecases.accesscontrol.ui.AccessControlScreen
import com.segared.controlviviendas.usecases.advertisements.ui.AdvertisementsScreen
import com.segared.controlviviendas.usecases.commonareas.ui.CommonAreasScreen
import com.segared.controlviviendas.usecases.complaints.ui.ComplaintsScreen
import com.segared.controlviviendas.usecases.dashboard.ui.DashboardScreen
import com.segared.controlviviendas.usecases.login.ui.LoginScreen
import com.segared.controlviviendas.usecases.mypets.ui.MyPetsScreen
import com.segared.controlviviendas.usecases.myvehicles.ui.MyVehiclesScreen
import com.segared.controlviviendas.usecases.scanqr.ui.ScanQrScreen
import com.segared.controlviviendas.usecases.signup.ui.SignupScreen
import com.segared.controlviviendas.usecases.splashscreen.ui.SplashScreen

@ExperimentalComposeUiApi
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreens.SplashScreen.route
    ) {
        composable(MainScreens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(MainScreens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(MainScreens.SignupScreen.route) {
            SignupScreen(navController = navController)
        }
        composable(MainScreens.DashboardScreen.route) {
            DashboardScreen(navController = navController)
        }
        composable(MainScreens.MyPetsScreen.route) {
            MyPetsScreen(navController = navController)
        }
        composable(MainScreens.MyVehiclesScreen.route) {
            MyVehiclesScreen(navController = navController)
        }
        composable(MainScreens.AdvertisementsScreen.route) {
            AdvertisementsScreen(navController = navController)
        }
        composable(MainScreens.AccessControlScreen.route) {
            AccessControlScreen(navController = navController)
        }
        composable(MainScreens.ScanQrScreen.route) {
            ScanQrScreen(navController = navController)
        }
        composable(MainScreens.ComplaintsScreen.route) {
            ComplaintsScreen(navController = navController)
        }
        composable(MainScreens.CommonAreasScreen.route) {
            CommonAreasScreen(navController = navController)
        }
    }
}
