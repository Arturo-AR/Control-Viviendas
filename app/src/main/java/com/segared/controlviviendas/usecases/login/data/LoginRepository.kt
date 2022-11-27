package com.segared.controlviviendas.usecases.login.data

import com.segared.controlviviendas.core.data.DatabaseRepository
import com.segared.controlviviendas.core.data.entities.UserData
import com.segared.controlviviendas.usecases.login.data.network.LoginService
import com.segared.controlviviendas.usecases.login.data.network.response.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService,
    private val dbRepository: DatabaseRepository
) {
    suspend fun login(user: String, password: String): LoginResponse {
        return api.login(user, password)
    }

    suspend fun saveUserData(userData: UserData) {
        dbRepository.insertUserData(userData)
    }

}