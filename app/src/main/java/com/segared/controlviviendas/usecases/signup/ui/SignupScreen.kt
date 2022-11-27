package com.segared.controlviviendas.usecases.signup.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.GetImage
import com.segared.controlviviendas.core.components.InputField
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.navigation.MainScreens
import com.segared.controlviviendas.core.util.toast

@Composable
fun SignupScreen(
    navController: NavController,
    viewModel: SignupViewModel = hiltViewModel()
) {

    val name by viewModel.name.observeAsState(initial = "")
    val lastName by viewModel.lastName.observeAsState(initial = "")
    val mothersLastName by viewModel.mothersLastName.observeAsState(initial = "")
    val street by viewModel.street.observeAsState(initial = "")
    val number by viewModel.number.observeAsState(initial = "")
    val phone by viewModel.phone.observeAsState(initial = "")
    val inePhoto by viewModel.inePhoto.observeAsState()
    val user by viewModel.user.observeAsState(initial = "")
    val password by viewModel.password.observeAsState(initial = "")
    val context = LocalContext.current

    MainScaffold(
        titleScreen = "Registrate",
        onTopBarIconAction = {
            navController.navigate(MainScreens.LoginScreen.route) {
                popUpTo(MainScreens.LoginScreen.route)
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    InputField(valueState = name, labelId = "Nombre") {
                        viewModel.onChangeTextFields(
                            it,
                            lastName,
                            mothersLastName,
                            street,
                            number,
                            phone,
                            user,
                            password
                        )
                    }
                    InputField(valueState = lastName, labelId = "Apellido Paterno") {
                        viewModel.onChangeTextFields(
                            name,
                            it,
                            mothersLastName,
                            street,
                            number,
                            phone,
                            user,
                            password
                        )
                    }
                    InputField(valueState = mothersLastName, labelId = "Apellido Materno") {
                        viewModel.onChangeTextFields(
                            name,
                            lastName,
                            it,
                            street,
                            number,
                            phone,
                            user,
                            password
                        )
                    }
                    InputField(valueState = street, labelId = "Calle") {
                        viewModel.onChangeTextFields(
                            name,
                            lastName,
                            mothersLastName,
                            it,
                            number,
                            phone,
                            user,
                            password
                        )
                    }
                    InputField(valueState = number, labelId = "Numero",
                        keyboardType = KeyboardType.Number) {
                        viewModel.onChangeTextFields(
                            name,
                            lastName,
                            mothersLastName,
                            street,
                            it,
                            phone,
                            user,
                            password
                        )
                    }
                    InputField(valueState = phone, labelId = "Telefono") {
                        viewModel.onChangeTextFields(
                            name,
                            lastName,
                            mothersLastName,
                            street,
                            number,
                            it,
                            user,
                            password
                        )
                    }
                    InputField(valueState = user, labelId = "Nombre de Usuario") {
                        viewModel.onChangeTextFields(
                            name,
                            lastName,
                            mothersLastName,
                            street,
                            number,
                            phone,
                            it,
                            password
                        )
                    }
                    InputField(valueState = password, labelId = "Contraseña") {
                        viewModel.onChangeTextFields(
                            name,
                            lastName,
                            mothersLastName,
                            street,
                            number,
                            phone,
                            user,
                            it
                        )
                    }
                    GetImage {
                        viewModel.selectIneImage(it)
                        Log.d("bitMap", it.toString())
                    }
                }
                Button(onClick = {
                    viewModel.signUpNewUser(
                        name,
                        lastName,
                        mothersLastName,
                        street,
                        number,
                        phone,
                        user,
                        password,
                        inePhoto,
                        onError = {
                            context.toast("Algo salio mal")
                        }) {
                        context.toast("Registro correcto!!")
                        navController.navigate(MainScreens.LoginScreen.route) {
                            popUpTo(MainScreens.LoginScreen.route)
                        }
                    }
                }) {
                    Text("Registrar")
                }
            }
        }
    )
}