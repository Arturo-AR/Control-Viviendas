package com.segared.controlviviendas.usecases.login.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.segared.controlviviendas.R
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.*
import com.segared.controlviviendas.core.navigation.MainScreens
import com.segared.controlviviendas.core.util.toast
import com.segared.controlviviendas.ui.theme.primary

@ExperimentalComposeUiApi
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val user by viewModel.user.observeAsState(initial = "")
    val password by viewModel.password.observeAsState(initial = "")
    val isLoginEnable by viewModel.isLoginEnable.observeAsState(initial = false)
    val context = LocalContext.current

    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(user, password) {
        user.trim().isNotEmpty() && password.trim().isNotEmpty()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 40.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            MainLogo(
                modifier = Modifier
                    .height(200.dp)
                    .clip(shape = CircleShape)
            )
        }

        InputField(
            labelId = stringResource(id = R.string.user),
            valueState = user,
            onAction = KeyboardActions.Default
        ) {
            viewModel.onLoginChange(it, password)
        }
        PasswordInput(
            modifier = Modifier,
            passwordState = password,
            label = stringResource(id = R.string.password),
            onAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                keyboardController?.hide()
            }) {
            viewModel.onLoginChange(user, it)
        }
        MainButton(
            modifier = Modifier.padding(horizontal = 32.dp),
            loginEnable = isLoginEnable,
        ) {
            //navController.navigate(MainScreens.DashboardScreen.route)
            viewModel.login(
                user = user.trim(),
                password = password.trim(),
                onError = {
                    context.toast("Credenciales no válidas")
                },
                onSuccess = {
                    navController.navigate(MainScreens.DashboardScreen.route)
                },
                unValidate = {
                    Toast.makeText(
                        context, "Usuario aun no validado", Toast.LENGTH_LONG
                    ).show()
                })
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.clickable {
                navController.navigate(MainScreens.SignupScreen.route)
            },
            text = stringResource(id = R.string.signUp),
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            fontSize = 18.sp,
            color = Color.White
        )

    }
}