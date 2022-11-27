package com.segared.controlviviendas.usecases.advertisements.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.MainScaffold
import com.segared.controlviviendas.core.navigation.MainScreens
import com.segared.controlviviendas.usecases.advertisements.data.network.response.AdvertisementsBody

@Composable
fun AdvertisementsScreen(
    navController: NavController,
    viewModel: AdvertisementsViewModel = hiltViewModel()
) {
    val advertisements by viewModel.advertisements.observeAsState()

    MainScaffold(
        titleScreen = "Anuncios",
        onTopBarIconAction = {
            navController.navigate(MainScreens.DashboardScreen.route) {
                popUpTo(MainScreens.DashboardScreen.route)
            }
        },
        content = {
            Column {
                if (!advertisements.isNullOrEmpty()) {
                    LazyColumn {
                        items(advertisements!!) { advertisement ->
                            AdvertisementItem(advertisement)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun AdvertisementItem(
    advertisement: AdvertisementsBody
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = advertisement.advertisementTitle,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = advertisement.advertisementBody)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = advertisement.date,
                textAlign = TextAlign.End
            )
        }
    }
}