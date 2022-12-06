package com.segared.controlviviendas.usecases.splashscreen.domain

import com.segared.controlviviendas.usecases.splashscreen.data.SplashRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CheckUserDataUseCase @Inject constructor(private val repository: SplashRepository) {
    suspend operator fun invoke(): Boolean {
        return false
    }
}