package com.segared.controlviviendas.usecases.advertisements.data

import com.segared.controlviviendas.usecases.advertisements.data.network.AdvertisementsService
import com.segared.controlviviendas.usecases.advertisements.data.network.response.AdvertisementsResponse
import javax.inject.Inject

class AdvertisementsRepository  @Inject constructor(private val api: AdvertisementsService) {
    suspend fun getAdvertisements(): AdvertisementsResponse {
        return api.getAdvertisements()
    }

}