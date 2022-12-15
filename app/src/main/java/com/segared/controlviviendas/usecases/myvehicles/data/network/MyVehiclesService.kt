package com.segared.controlviviendas.usecases.myvehicles.data.network

import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.MyVehiclesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MyVehiclesService @Inject constructor(private val myVehiclesClient: MyVehiclesClient) {

    suspend fun getVehicles(user: String): MyVehiclesResponse {
        return withContext(Dispatchers.IO) {
            val response = myVehiclesClient.getPVehicles(26, user)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }

    suspend fun deleteVehicle(vehicleId: Int): DefaultServerResponse {
        return withContext(Dispatchers.IO) {
            val response =
                myVehiclesClient.deleteVehicle(23, vehicleId)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }

    suspend fun updateVehicles(
        vehicleId: Int,
        vehicleBrand: String,
        vehiclePlate: String,
        vehicleModel: String,
        vehicleColor: String,
        vehicleYear: String
    ): DefaultServerResponse {
        return withContext(Dispatchers.IO) {
            val response =
                myVehiclesClient.updateVehicles(
                    25,
                    vehicleId,
                    vehicleBrand,
                    vehiclePlate,
                    vehicleModel,
                    vehicleColor,
                    vehicleYear
                )
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }

    suspend fun addVehicles(
        vehicleBrand: String,
        vehicleModel: String,
        vehiclePlate: String,
        vehicleColor: String,
        vehicleYear: String,
        userId: Int
    ): DefaultServerResponse {
        return withContext(Dispatchers.IO) {
            val response =
                myVehiclesClient.addVehicle(
                    19,
                    vehicleBrand,
                    vehicleModel,
                    vehiclePlate,
                    vehicleColor,
                    vehicleYear,
                    userId
                )
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }
}