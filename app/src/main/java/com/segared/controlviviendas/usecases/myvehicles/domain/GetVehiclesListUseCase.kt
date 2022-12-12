package com.segared.controlviviendas.usecases.myvehicles.domain

import com.segared.controlviviendas.usecases.myvehicles.data.MyVehiclesRepository
import com.segared.controlviviendas.usecases.myvehicles.data.network.response.Vehicle
import javax.inject.Inject

class GetVehiclesListUseCase @Inject constructor(private val repository: MyVehiclesRepository) {
    suspend operator fun invoke(user: String): List<Vehicle> {
        return repository.getVehicles(user).responseObject
    }
}