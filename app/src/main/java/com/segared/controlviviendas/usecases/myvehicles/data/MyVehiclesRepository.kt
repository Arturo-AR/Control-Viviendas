package com.segared.controlviviendas.usecases.myvehicles.data

import com.segared.controlviviendas.usecases.myvehicles.data.network.MyVehiclesService
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.AddVehiclesResponse
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.DeleteVehicleResponse
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.MyVehiclesResponse
import javax.inject.Inject

class MyVehiclesRepository @Inject constructor(
    private val api: MyVehiclesService
) {
    suspend fun getVehicles(user: String): MyVehiclesResponse {
        return api.getVehicles(user)
    }

    suspend fun deleteVehicle(vehicleId:Int): DeleteVehicleResponse {
        return api.deleteVehicle(vehicleId)
    }

    suspend fun addVehicle(
        vehicleBrand: String,
        vehicleModel: String,
        vehicleColor: String,
        vehicleYear: String,
        userId: Int
    ): AddVehiclesResponse {
        return api.addVehicles(vehicleBrand, vehicleModel, vehicleColor, vehicleYear, userId)
    }

}