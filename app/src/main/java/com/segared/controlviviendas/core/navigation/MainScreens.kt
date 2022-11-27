package com.segared.controlviviendas.core.navigation

sealed class MainScreens(
    val route: String
) {
    object SplashScreen:MainScreens(
        route = "splashScreen"
    )
    object LoginScreen:MainScreens(
        route = "loginScreen"
    )
    object DashboardScreen:MainScreens(
        route = "dashboardScreen"
    )
    object SignupScreen:MainScreens(
        route = "signupScreen"
    )
    object MyPetsScreen:MainScreens(
        route = "myPetsScreen"
    )
    object MyVehiclesScreen:MainScreens(
        route = "myVehiclesScreen"
    )
    object AdvertisementsScreen:MainScreens(
        route = "advertisementsScreen"
    )
    object AccessControlScreen: MainScreens(
        route = "accessControlScreen"
    )
    object ScanQrScreen: MainScreens(
        route = "scanQrScreen"
    )
    object ComplaintsScreen: MainScreens(
        route = "complaintsScreen"
    )
    object CommonAreasScreen: MainScreens(
        route = "commonAreasScreen"
    )
}