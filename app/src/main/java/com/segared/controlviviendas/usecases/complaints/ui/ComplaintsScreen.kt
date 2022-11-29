package com.segared.controlviviendas.usecases.complaints.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.navigation.MainScreens

@Composable
fun ComplaintsScreen(
    navController: NavController,
    viewModel: ComplaintsViewModel = hiltViewModel()
) {
    val complaint by viewModel.complaint.observeAsState(initial = "")
    val uploaded by viewModel.uploaded.observeAsState(initial = false)
    val anonymous by viewModel.anonymous.observeAsState(initial = false)

    if (uploaded){
        viewModel.cleanComplaint()
        viewModel.resetUploaded()
    }

    MainScaffold(
        titleScreen = "Quejas/Sugerencias",
        onTopBarIconAction = {
            navController.navigate(MainScreens.DashboardScreen.route) {
                popUpTo(MainScreens.DashboardScreen.route)
            }
        },
        content = {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = complaint,
                    onValueChange = { viewModel.onChangeComplaint(it) },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent

                    )
                )
                LabelledCheckbox(
                    checked = anonymous,
                    onCheckedChange = {viewModel.changeAnonymous(it)},
                    label = "Enviar Anonimo"
                )
                Button(onClick = { viewModel.uploadComplaint() }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                )) {
                    Text(text = "Subir queja")
                }
            }
        }
    )
}

@Composable
fun LabelledCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CheckboxColors = CheckboxDefaults.colors(
        checkedColor = Color.Black,
        checkmarkColor = Color.White
    )
) {
    Row(
        modifier = modifier.height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = colors
        )
        Text(label)
    }
}