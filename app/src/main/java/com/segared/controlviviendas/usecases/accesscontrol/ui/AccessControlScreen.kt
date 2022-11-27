package com.segared.controlviviendas.usecases.accesscontrol.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AccessControlScreen(
    navController: NavController,
    viewModel: AccessControlViewModel = hiltViewModel()
) {
    Text(text = "Control de acceso")
}