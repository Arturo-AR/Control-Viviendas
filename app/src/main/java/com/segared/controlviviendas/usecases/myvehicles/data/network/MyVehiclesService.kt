package com.segared.controlviviendas.usecases.myvehicles.data.network

import com.segared.controlviviendas.usecases.myvehicles.data.network.response.AddVehiclesResponse
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.DeleteVehicleResponse
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

    suspend fun deleteVehicle(vehicleId: Int): DeleteVehicleResponse {
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