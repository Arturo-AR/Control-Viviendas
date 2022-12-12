package com.segared.controlviviendas.usecases.dashboard.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.MainLogo
import com.segared.controlviviendas.core.components.MainMenuList
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.components.ShowAlertDialog
import com.segared.controlviviendas.core.navigation.MainScreens
import com.segared.controlviviendas.core.util.toast
import com.segared.controlviviendas.ui.theme.primary_dark
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val permissions by viewModel.permissions.observeAsState(
        initial = emptyList()
    )
    val userName by viewModel.userName.observeAsState(initial = "")
    MainScaffold(
        scaffoldState = scaffoldState,
        titleScreen = "Bienvenido $userName",
        inDashboard = true,
        drawerContent = {
            DrawerView(navController, viewModel)
        },
        onTopBarIconAction = {
            scope.launch {
                scaffoldState.drawerState.open()
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (permissions.isNotEmpty()) {
                    MainMenuList(navController, permissions) {
                        context.toast("PROXIMAMETE")
                    }
                } else {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            color = Color.White,
                            strokeWidth = 4.dp,
                            modifier = Modifier.size(60.dp)
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun DrawerView(
    navController: NavController,
    viewModel: DashboardViewModel
) {
    val openDialog = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primary_dark)
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (openDialog.value) {
            ShowAlertDialog(
                title = "Alerta",
                message = { Text(text = "Desea cerrar sesion ?", color = Color.White) },
                openDialog = openDialog
            ) {
                viewModel.logOut()
                navController.navigate(MainScreens.LoginScreen.route)
            }
        }
        Card(
            modifier = Modifier
                .width(90.dp)
                .height(90.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            MainLogo(modifier = Modifier.fillMaxSize())
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Segared", color = Color.White, style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(36.dp))
        AddDrawerHeader(title = "Cerrar Sesion", icon = Icons.Default.Logout) {
            openDialog.value = true
        }
    }
}

@Composable
fun AddDrawerHeader(
    title: String,
    icon: ImageVector,
    titleColor: Color = Color.White,
    onPress: () -> Unit
) {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { onPress() },
        backgroundColor = primary_dark
    ) {
        Row(modifier = Modifier.padding(vertical = 16.dp)) {
            Icon(imageVector = icon, contentDescription = null, tint = titleColor)
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = titleColor
                )
            )
        }
    }
}