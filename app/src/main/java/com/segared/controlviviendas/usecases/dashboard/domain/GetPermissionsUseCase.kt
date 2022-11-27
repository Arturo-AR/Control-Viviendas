package com.segared.controlviviendas.usecases.dashboard.domain

import com.segared.controlviviendas.usecases.dashboard.data.DashboardRepository
import com.segared.controlviviendas.usecases.dashboard.data.network.response.PermissionsResponse
import javax.inject.Inject

class GetPermissionsUseCase @Inject constructor(private val repository: DashboardRepository) {
    suspend operator fun invoke(idRol:Int): PermissionsResponse {
        return repository.getPermissions(idRol)
    }
}