package com.segared.controlviviendas.usecases.login.data.network

import com.segared.controlviviendas.usecases.login.data.network.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {

    suspend fun login(user: String, password: String): LoginResponse {
        return withContext(Dispatchers.IO) {
            val response = loginClient.login(2,user, password)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }
}