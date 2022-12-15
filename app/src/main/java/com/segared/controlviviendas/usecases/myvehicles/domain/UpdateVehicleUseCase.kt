package com.segared.controlviviendas.usecases.myvehicles.domain

import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.myvehicles.data.MyVehiclesRepository
import javax.inject.Inject

class UpdateVehicleUseCase @Inject constructor(private val repository: MyVehiclesRepository) {
    suspend operator fun invoke(
        vehicleId: Int,
        vehicleBrand: String,
        vehiclePlate: String,
        vehicleModel: String,
        vehicleColor: String,
        vehicleYear: String
    ): Boolean {
        return repository.updateVehicles(
            vehicleId, vehicleBrand, vehiclePlate, vehicleModel, vehicleColor, vehicleYear
        ).responseCode == Constants.SUCCESS_CODE
    }
}