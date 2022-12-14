package com.segared.controlviviendas.usecases.mypets.data

import android.util.Log
import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.usecases.mypets.data.network.MyPetsService
import com.segared.controlviviendas.usecases.mypets.data.network.response.MyPetsResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.PetsTypesResponse
import javax.inject.Inject

class MyPetsRepository @Inject constructor(
    private val api: MyPetsService
) {
    suspend fun getPets(user: String): MyPetsResponse {
        return api.getPets(user)
    }

    suspend fun deletePet(petIt: Int): DefaultServerResponse {
        return api.deletePet(petIt)
    }

    suspend fun updatePet(
        petId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        petTypeId: Int
    ): DefaultServerResponse {
        Log.d("idMascota", petId.toString())
        Log.d("nombre", petName)
        Log.d("raza", petBreed)
        Log.d("color", petColor)
        Log.d("tipoMascota", petTypeId.toString())
        return api.updatePet(petId, petName, petBreed, petColor, petTypeId)
    }

    suspend fun addPet(
        petTypeId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        userId: Int
    ): DefaultServerResponse {
        return api.addPet(petTypeId, petName, petBreed, petColor, userId)
    }

    suspend fun getPetTypes() : PetsTypesResponse {
        return api.getPetTypes()
    }

}