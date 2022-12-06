package com.segared.controlviviendas.core.data.preferences

interface Preferences {
    suspend fun putUserId(key:String, value: Int)
    suspend fun getUserId(key:String): Int?
    suspend fun deleteUserId()
}