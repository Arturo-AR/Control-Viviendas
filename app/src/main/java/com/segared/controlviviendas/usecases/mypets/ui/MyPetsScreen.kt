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
import com.segared.controlviviendas.core.components.MainPetsList
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
    val petsTypesList by viewModel.petsTypesList.observeAsState(initial = emptyList())
    var editing by remember {
        mutableStateOf(false)
    }
    if (showAddPet) {
        AlertDialog(
            onDismissRequest = {
                viewModel.hideAddPet()
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (editing) {
                            viewModel.updatePet()
                        } else {
                            viewModel.addPet {
                                context.toast("Error, intentelo mas tarde")
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = if (editing) "Actualizar" else "Agregar", color = Color.White)
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        if (editing) {
                            viewModel.deletePet()
                            viewModel.hideAddPet()
                        } else {
                            viewModel.hideAddPet()
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    )
                ) {
                    Text(text = if (editing) "Eliminar" else "Cancelar", color = Color.White)
                }
            },
            title = {
                Text(
                    text = if (editing) "Actializar Mascota" else "Agregar Mascota",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column {
                    DropDownMenu(petsTypesList) {

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
                onClick = {
                    editing = false
                    viewModel.cleanPet()
                    viewModel.showAddPet()
                },
                backgroundColor = Color.Black
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
            }
        },
        content = {
            MainPetsList(
                items = petsList
            ) { petId, index ->
                editing = true
                viewModel.editPet(petId, index)
                viewModel.showAddPet()
            }
        }
    )
}