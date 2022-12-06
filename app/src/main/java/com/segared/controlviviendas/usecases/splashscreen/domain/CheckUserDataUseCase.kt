package com.segared.controlviviendas.usecases.splashscreen.domain

import com.segared.controlviviendas.usecases.splashscreen.data.SplashRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CheckUserDataUseCase @Inject constructor(private val repository: SplashRepository) {
    suspend operator fun invoke(key:String): Boolean {
        //false login
        //true dashboard
        val user = repository.getUser(key)
        return user != null
    }
}