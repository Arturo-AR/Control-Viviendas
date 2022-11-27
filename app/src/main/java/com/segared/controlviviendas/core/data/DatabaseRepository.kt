package com.segared.controlviviendas.core.data

import com.segared.controlviviendas.core.data.entities.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val segaredDatabaseDao: SegaredDatabaseDao) {
    suspend fun insertUserData(userData: UserData) = segaredDatabaseDao.insertUserData(userData)
    suspend fun deleteUserData() = segaredDatabaseDao.deleteUserData()
    fun getUserData(): Flow<UserData> {
        return segaredDatabaseDao.getUserData().flowOn(Dispatchers.IO).conflate()
    }
}