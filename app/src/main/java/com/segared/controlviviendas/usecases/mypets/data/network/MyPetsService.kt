package com.segared.controlviviendas.usecases.mypets.data.network

import com.segared.controlviviendas.usecases.mypets.data.network.response.AddPetsResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.DeletePetResponse
import com.segared.controlviviendas.usecases.mypets.data.network.response.MyPetsResponse
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

    suspend fun addPet(
        petTypeId: Int,
        petName: String,
        petBreed: String,
        petColor: String,
        userId: Int
    ): AddPetsResponse {
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

    suspend fun deletePet(petId: Int): DeletePetResponse {
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