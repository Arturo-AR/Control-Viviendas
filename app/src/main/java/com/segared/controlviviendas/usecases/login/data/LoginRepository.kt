package com.segared.controlviviendas.usecases.login.data

import com.segared.controlviviendas.core.data.repository.DataStoreRepository
import com.segared.controlviviendas.usecases.login.data.network.LoginService
import com.segared.controlviviendas.usecases.login.data.network.response.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService,
    private val dataStoreRepository: DataStoreRepository
) {
    suspend fun login(user: String, password: String): LoginResponse {
        return api.login(user, password)
    }

    suspend fun saveUser(key:String, value:Int) {
        dataStoreRepository.putUserIdValue(key, value)
    }
}