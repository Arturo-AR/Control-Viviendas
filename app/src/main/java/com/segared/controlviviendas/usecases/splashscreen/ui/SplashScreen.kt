package com.segared.controlviviendas.usecases.splashscreen.ui

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.segared.controlviviendas.core.components.MainLogo
import com.segared.controlviviendas.core.navigation.MainScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val logged by viewModel.logged.observeAsState(initial = false)
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                })
        )
        delay(1500L)

        if (logged) {
            navController.navigate(MainScreens.DashboardScreen.route)
        } else {
            navController.navigate(MainScreens.LoginScreen.route)
        }
    }
    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(270.dp)
            .scale(scale.value)
    ) {
        val modifier = Modifier.padding(bottom = 35.dp, top = 10.dp)
        MainLogo(modifier)
    }
}