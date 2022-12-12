package com.segared.controlviviendas.usecases.myvehicles.domain

import com.segared.controlviviendas.core.util.Constants
import com.segared.controlviviendas.usecases.myvehicles.data.MyVehiclesRepository
import javax.inject.Inject

class DeleteVehicleUseCase @Inject constructor(private val repository: MyVehiclesRepository) {
    suspend operator fun invoke(vehicleId: Int): Boolean {
        return repository.deleteVehicle(vehicleId).responseCode == Constants.SUCCESS_CODE
    }
}