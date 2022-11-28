package com.segared.controlviviendas.usecases.myvehicles.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.MainMenuList
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.navigation.MainScreens
import com.segared.controlviviendas.core.util.toast

@Composable
fun MyVehiclesScreen(
    navController: NavController,
    viewModel: MyVehiclesViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val vehiclesList by viewModel.userVehiclesList.observeAsState(initial = emptyList())
    val vehicleBrand by viewModel.vehicleBrand.observeAsState(initial = "")
    val vehicleModel by viewModel.vehicleModel.observeAsState(initial = "")
    val vehicleYear by viewModel.vehicleYear.observeAsState(initial = "")
    val vehicleColor by viewModel.vehicleColor.observeAsState(initial = "")
    val showAddVehicle by viewModel.showAddVehicle.observeAsState(initial = false)

    if (showAddVehicle) {
        AlertDialog(
            onDismissRequest = {
                viewModel.hideAddVehicle()
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.addVehicle {
                            context.toast("Error, intentelo mas tarde")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = "Agregar", color = Color.White)
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        viewModel.hideAddVehicle()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = "Cancelar", color = Color.White)
                }
            },
            title = {
                Text(text = "Agregar Vehiculo", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            },
            text = {
                Column {
                    TextField(
                        value = vehicleBrand,
                        onValueChange = {
                            viewModel.onFormChange(
                                vehicleBrand = it,
                                vehicleModel = vehicleModel,
                                vehicleYear = vehicleYear,
                                vehicleColor = vehicleColor,
                            )
                        },
                        placeholder = {
                            Text(text = "Marca")
                        }
                    )

                    TextField(
                        value = vehicleModel,
                        onValueChange = {
                            viewModel.onFormChange(
                                vehicleBrand = vehicleBrand,
                                vehicleModel = it,
                                vehicleYear = vehicleYear,
                                vehicleColor = vehicleColor,
                            )
                        },
                        placeholder = {
                            Text(text = "Modelo")
                        }
                    )

                    TextField(
                        value = vehicleYear,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        onValueChange = {
                            viewModel.onFormChange(
                                vehicleBrand = vehicleBrand,
                                vehicleModel = vehicleModel,
                                vehicleYear = it,
                                vehicleColor = vehicleColor,
                            )
                        },

                        placeholder = {
                            Text(text = "Año")
                        }
                    )

                    TextField(
                        value = vehicleColor,
                        onValueChange = {
                            viewModel.onFormChange(
                                vehicleBrand = vehicleBrand,
                                vehicleModel = vehicleModel,
                                vehicleYear = vehicleYear,
                                vehicleColor = it,
                            )
                        },
                        placeholder = {
                            Text(text = "Color")
                        }
                    )
                }
            }
        )
    }


    MainScaffold(
        titleScreen = "Mis Mascotas",
        onTopBarIconAction = {
            navController.navigate(MainScreens.DashboardScreen.route) {
                popUpTo(MainScreens.DashboardScreen.route)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.showAddVehicle() },
                backgroundColor = Color.Black
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
            }
        },
        content = {
            MainMenuList(
                navController = navController,
                items = vehiclesList.map { it.vehicleBrand }
            ) {

            }
        }
    )
}