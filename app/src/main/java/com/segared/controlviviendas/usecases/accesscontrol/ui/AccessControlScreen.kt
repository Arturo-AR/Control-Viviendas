package com.segared.controlviviendas.usecases.accesscontrol.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.navigation.MainScreens

@Composable
fun AccessControlScreen(
    navController: NavController,
    viewModel: AccessControlViewModel = hiltViewModel()
) {
    MainScaffold(
        titleScreen = "Control de Accesos",
        onTopBarIconAction = {
            navController.navigate(MainScreens.DashboardScreen.route) {
                popUpTo(MainScreens.DashboardScreen.route)
            }
        },
        content = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Control de acceso", fontSize = 30.sp, color = Color.White)
            }
        }
    )
}