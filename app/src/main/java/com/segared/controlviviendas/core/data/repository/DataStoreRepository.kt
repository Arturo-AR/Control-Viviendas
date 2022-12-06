package com.segared.controlviviendas.core.data.repository

interface DataStoreRepository {
    suspend fun putUserIdValue(key:String, value: Int)
    suspend fun getUserIdValue(key:String): Int?
    suspend fun deleteUserIdValue()
}