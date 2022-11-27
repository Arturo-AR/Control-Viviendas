package com.segared.controlviviendas.usecases.advertisements.domain

import com.segared.controlviviendas.usecases.advertisements.data.AdvertisementsRepository
import com.segared.controlviviendas.usecases.advertisements.data.network.response.AdvertisementsResponse
import javax.inject.Inject

class GetAdvertisementsUseCase @Inject constructor(private val repository: AdvertisementsRepository) {
    suspend operator fun invoke(): AdvertisementsResponse {
        return repository.getAdvertisements()
    }

}