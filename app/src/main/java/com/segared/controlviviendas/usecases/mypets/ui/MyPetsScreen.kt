package com.segared.controlviviendas.usecases.mypets.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.DropDownMenu
import com.segared.controlviviendas.core.components.MainMenuList
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.navigation.MainScreens
import com.segared.controlviviendas.core.util.toast

@Composable
fun MyPetsScreen(
    navController: NavController,
    viewModel: MyPetsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val petsList by viewModel.userPetsList.observeAsState(initial = emptyList())
    val petName by viewModel.petName.observeAsState(initial = "")
    val petBreed by viewModel.petBreed.observeAsState(initial = "")
    val petColor by viewModel.petColor.observeAsState(initial = "")
    val petTypeId by viewModel.petTypeId.observeAsState(initial = 1)
    val showAddPet by viewModel.showAddPet.observeAsState(initial = false)

    if (showAddPet) {
        AlertDialog(
            onDismissRequest = {
                viewModel.hideAddPet()
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.addPet {
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
                        viewModel.hideAddPet()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = "Cancelar", color = Color.White)
                }
            },
            title = {
                Text(text = "Agregar Mascota", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            },
            text = {
                Column {
                    DropDownMenu(listOf("Perro", "Gato")){

                        viewModel.onFormChange(
                            petName = petName,
                            petBreed = petBreed,
                            petColor = petColor,
                            petTypeId = it
                        )
                    }
                    TextField(
                        value = petColor,
                        onValueChange = {
                            viewModel.onFormChange(
                                petName = petName,
                                petBreed = petBreed,
                                petColor = it,
                                petTypeId = petTypeId
                            )
                        },
                        placeholder = {
                            Text(text = "Color")
                        }
                    )

                    TextField(
                        value = petName,
                        onValueChange = {
                            viewModel.onFormChange(
                                petName = it,
                                petBreed = petBreed,
                                petColor = petColor,
                                petTypeId = petTypeId
                            )
                        },
                        placeholder = {
                            Text(text = "Nombre")
                        }
                    )

                    TextField(
                        value = petBreed,
                        onValueChange = {
                            viewModel.onFormChange(
                                petName = petName,
                                petBreed = it,
                                petColor = petColor,
                                petTypeId = petTypeId
                            )
                        },
                        placeholder = {
                            Text(text = "Raza")
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
                onClick = { viewModel.showAddPet() },
                backgroundColor = Color.Black
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
            }
        },
        content = {
            MainMenuList(
                navController = navController,
                items = petsList.map { it.petName }
            ) {

            }
        }
    )
}