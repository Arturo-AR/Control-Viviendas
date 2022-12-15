package com.segared.controlviviendas.usecases.myvehicles.data

import com.segared.controlviviendas.core.models.DefaultServerResponse
import com.segared.controlviviendas.usecases.myvehicles.data.network.MyVehiclesService
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.MyVehiclesResponse
import javax.inject.Inject

class MyVehiclesRepository @Inject constructor(
    private val api: MyVehiclesService
) {
    suspend fun getVehicles(user: String): MyVehiclesResponse {
        return api.getVehicles(user)
    }

    suspend fun updateVehicles(
        vehicleId: Int,
        vehicleBrand: String,
        vehiclePlate: String,
        vehicleModel: String,
        vehicleColor: String,
        vehicleYear: String
    ): DefaultServerResponse {
        return api.updateVehicles(
            vehicleId,
            vehicleBrand,
            vehiclePlate,
            vehicleModel,
            vehicleColor,
            vehicleYear
        )
    }

    suspend fun deleteVehicle(vehicleId: Int): DefaultServerResponse {
        return api.deleteVehicle(vehicleId)
    }

    suspend fun addVehicle(
        vehicleBrand: String,
        vehicleModel: String,
        vehiclePlate: String,
        vehicleColor: String,
        vehicleYear: String,
        userId: Int
    ): DefaultServerResponse {
        return api.addVehicles(
            vehicleBrand,
            vehicleModel,
            vehiclePlate,
            vehicleColor,
            vehicleYear,
            userId
        )
    }

}