package com.segared.controlviviendas.usecases.mypets.data.network

import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.MyPetsResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.PetsTypesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MyPetsService @Inject constructor(private val myPetsClient: MyPetsClient) {

    suspend fun getPets(user: String): MyPetsResponse {
        return withContext(Dispatchers.IO) {
            val response = myPetsClient.getPets(27, user)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }

    suspend fun updatePet(
        petId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        petTypeId: Int
    ): DefaultServerResponse {
        return withContext(Dispatchers.IO) {
            val response =
                myPetsClient.updatePet(24, petId, petName, petBreed, petColor, petTypeId)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }

    suspend fun getPetTypes() : PetsTypesResponse{
        return withContext(Dispatchers.IO) {
            val response =
                myPetsClient.getPetTypes(21)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }

    suspend fun addPet(
        petTypeId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        userId: Int
    ): DefaultServerResponse {
        return withContext(Dispatchers.IO) {
            val response =
                myPetsClient.addPet(17, petTypeId, petName, petBreed, petColor, userId)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }

    suspend fun deletePet(petId: Int): DefaultServerResponse {
        return withContext(Dispatchers.IO) {
            val response =
                myPetsClient.deletePet(22, petId)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }
}