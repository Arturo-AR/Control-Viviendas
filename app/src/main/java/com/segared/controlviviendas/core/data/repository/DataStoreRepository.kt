package com.segared.controlviviendas.core.data.repository

interface DataStoreRepository {
    suspend fun putUserIdValue(key:String, value: Int)
    suspend fun getUserIdValue(key:String): Int?
    suspend fun putUserRolValue(key:String, value: Int)
    suspend fun getUserRolValue(key:String): Int?
    suspend fun putUserNameValue(key:String, value: String)
    suspend fun getUserNameValue(key:String): String?
    suspend fun putUserValue(key:String, value: String)
    suspend fun getUserValue(key:String): String?
    suspend fun deleteData()
}