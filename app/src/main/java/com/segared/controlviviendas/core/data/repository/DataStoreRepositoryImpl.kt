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

    override suspend fun deleteUserIdValue() {
        preferences.deleteUserId()
    }
}