package com.segared.controlviviendas.usecases.splashscreen.data

import com.segared.controlviviendas.core.data.repository.DataStoreRepository
import javax.inject.Inject

class SplashRepository @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend fun getUser(key:String) = dataStoreRepository.getUserIdValue(key)
}