package com.segared.controlviviendas.usecases.login.data

import com.segared.controlviviendas.usecases.login.data.network.LoginService
import com.segared.controlviviendas.usecases.login.data.network.response.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService,
) {
    suspend fun login(user: String, password: String): LoginResponse {
        return api.login(user, password)
    }

}