package com.segared.controlviviendas.usecases.mypets.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.navigation.MainScreens

@Composable
fun MyPetsScreen(
    navController: NavController
) {
    MainScaffold(
        titleScreen = "Mis Mascotas",
        onTopBarIconAction = {
            navController.navigate(MainScreens.DashboardScreen.route) {
                popUpTo(MainScreens.DashboardScreen.route)
            }
        },
        content = {
            Text(text = "Mis mascotas")
        }
    )
}