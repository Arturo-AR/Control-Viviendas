package com.segared.controlviviendas.usecases.myvehicles.data.network

import com.segared.controlviviendas.usecases.myvehicles.data.network.response.AddVehiclesResponse
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.MyVehiclesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MyVehiclesService @Inject constructor(private val myVehiclesClient: MyVehiclesClient) {

    suspend fun getVehicles(userId: Int): MyVehiclesResponse {
        return withContext(Dispatchers.IO) {
            val response = myVehiclesClient.getPVehicles(20, userId)
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
        vehicleColor: String,
        vehicleYear: String,
        userId: Int
    ): AddVehiclesResponse {
        return withContext(Dispatchers.IO) {
            val response =
                myVehiclesClient.addVehicle(19, vehicleBrand, vehicleModel, vehicleColor, vehicleYear, userId)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }
}