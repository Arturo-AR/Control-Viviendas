package com.segared.controlviviendas.usecases.mypets.data

import com.segared.controlviviendas.usecases.mypets.data.network.MyPetsService
import com.segared.controlviviendas.usecases.mypets.data.network.response.AddPetsResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.MyPetsResponse
import javax.inject.Inject

class MyPetsRepository @Inject constructor(
    private val api: MyPetsService
) {
    suspend fun getPets(userId: Int): MyPetsResponse {
        return api.getPets(userId)
    }

    suspend fun addPet(
        petTypeId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        userId: Int
    ): AddPetsResponse {
        return api.addPet(petTypeId, petName, petBreed, petColor, userId)
    }

}