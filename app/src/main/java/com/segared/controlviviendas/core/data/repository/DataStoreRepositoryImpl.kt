package com.segared.controlviviendas.core.data.repository

import com.segared.controlviviendas.core.data.preferences.Preferences
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val preferences: Preferences
): DataStoreRepository {
    override suspend fun putUserIdValue(key: String, value: Int) {
        preferences.putUserId(key, value)
    }

    override suspend fun getUserIdValue(key: String): Int? {
        return preferences.getUserId(key)
    }

    override suspend fun putUserRolValue(key: String, value: Int) {
        preferences.putUserRol(key, value)
    }

    override suspend fun getUserRolValue(key: String): Int? {
        return preferences.getUserRol(key)
    }

    override suspend fun putUserNameValue(key: String, value: String) {
        preferences.putUserName(key, value)
    }

    override suspend fun getUserNameValue(key: String): String? {
        return preferences.getUserName(key)
    }

    override suspend fun deleteData() {
        preferences.deleteData()
    }
}