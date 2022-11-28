package com.segared.controlviviendas.usecases.myvehicles.domain

import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.myvehicles.data.MyVehiclesRepository
import javax.inject.Inject

class AddVehicleUseCase @Inject constructor(private val repository: MyVehiclesRepository) {
    suspend operator fun invoke(
        vehicleBrand: String,
        vehicleModel: String,
        vehicleColor: String,
        vehicleYear: String,
        userId: Int
    ): Boolean {

        return repository.addVehicle(
            vehicleBrand, vehicleModel, vehicleColor, vehicleYear, userId
        ).responseCode == Constants.SUCCESS_CODE
    }
}