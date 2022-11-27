package com.segared.controlviviendas.usecases.splashscreen.data

import com.segared.controlviviendas.core.data.DatabaseRepository
import com.segared.controlviviendas.core.data.entities.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SplashRepository @Inject constructor(private val databaseRepository: DatabaseRepository) {

    fun getUserData(): Flow<UserData> = databaseRepository.getUserData()

}