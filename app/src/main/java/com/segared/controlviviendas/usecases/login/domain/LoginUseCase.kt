package com.segared.controlviviendas.usecases.login.domain

import com.segared.controlviviendas.usecases.login.data.LoginRepository
import com.segared.controlviviendas.usecases.login.data.network.response.LoginResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(user: String, password: String): LoginResponse {
        return repository.login(user, password)
    }
}