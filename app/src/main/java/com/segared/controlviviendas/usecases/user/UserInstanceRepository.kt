package com.segared.controlviviendas.usecases.user

import com.segared.controlviviendas.core.data.repository.DataStoreRepository
import com.segared.controlviviendas.core.models.Session
import com.segared.controlviviendas.core.util.Constants.USER_DATA_STORE
import com.segared.controlviviendas.core.util.Constants.USER_ID_DATA_STORE
import com.segared.controlviviendas.core.util.Constants.USER_NAME_DATA_STORE
import com.segared.controlviviendas.core.util.Constants.USER_ROL_DATA_STORE
import javax.inject.Inject

class UserInstanceRepository @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend fun logOut() {
        dataStoreRepository.deleteData()
    }

    suspend fun getSession(): Session {
        return Session(
            userId = dataStoreRepository.getUserIdValue(USER_ID_DATA_STORE) ?: 0,
            userRol = dataStoreRepository.getUserRolValue(USER_ROL_DATA_STORE) ?: 0,
            userName = dataStoreRepository.getUserNameValue(USER_NAME_DATA_STORE) ?: "",
            user = dataStoreRepository.getUserValue(USER_DATA_STORE) ?: ""
        )
    }

    suspend fun setSession(userId: Int, userRol: Int, userName: String, user: String) {
        dataStoreRepository.putUserIdValue(USER_ID_DATA_STORE, userId)
        dataStoreRepository.putUserRolValue(USER_ROL_DATA_STORE, userRol)
        dataStoreRepository.putUserNameValue(USER_NAME_DATA_STORE, userName)
        dataStoreRepository.putUserValue(USER_DATA_STORE, user)
    }
}