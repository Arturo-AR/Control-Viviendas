package com.segared.controlviviendas.core.data.preferences

interface Preferences {
    suspend fun putUserId(key:String, value: Int)
    suspend fun getUserId(key:String): Int?
    suspend fun deleteData()

    suspend fun putUserRol(key:String, value: Int)
    suspend fun getUserRol(key:String): Int?

    suspend fun putUserName(key:String, value: String)
    suspend fun getUserName(key:String): String?
}