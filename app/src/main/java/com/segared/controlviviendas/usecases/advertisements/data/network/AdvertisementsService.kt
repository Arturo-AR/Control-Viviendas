package com.segared.controlviviendas.usecases.advertisements.data.network

import com.segared.controlviviendas.usecases.advertisements.data.network.response.AdvertisementsResponse
import com.segared.controlviviendas.usecases.login.data.network.LoginClient
import com.segared.controlviviendas.usecases.login.data.network.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AdvertisementsService @Inject constructor(private val advertisementsClient: AdvertisementsClient) {

    suspend fun getAdvertisements(): AdvertisementsResponse {
        return withContext(Dispatchers.IO) {
            val response = advertisementsClient.getAdvertisements(11)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }
}