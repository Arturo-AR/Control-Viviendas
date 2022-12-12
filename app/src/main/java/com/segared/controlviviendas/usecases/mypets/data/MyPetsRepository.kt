package com.segared.controlviviendas.usecases.mypets.data

import com.segared.controlviviendas.usecases.mypets.data.network.MyPetsService
import com.segared.controlviviendas.usecases.mypets.data.network.response.AddPetsResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.DeletePetResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.MyPetsResponse
import javax.inject.Inject

class MyPetsRepository @Inject constructor(
    private val api: MyPetsService
) {
    suspend fun getPets(user: String): MyPetsResponse {
        return api.getPets(user)
    }

    suspend fun deletePet(petIt:Int): DeletePetResponse {
        return api.deletePet(petIt)
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