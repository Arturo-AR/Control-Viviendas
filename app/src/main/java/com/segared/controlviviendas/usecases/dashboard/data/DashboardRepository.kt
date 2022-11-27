package com.segared.controlviviendas.usecases.dashboard.data

import com.segared.controlviviendas.core.data.DatabaseRepository
import com.segared.controlviviendas.usecases.dashboard.data.network.DashboardService
import com.segared.controlviviendas.usecases.dashboard.data.network.response.PermissionsResponse
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val api: DashboardService,
    private val dbRepository: DatabaseRepository
) {

    suspend fun getPermissions(idRol: Int): PermissionsResponse {
        return api.getPermissions(idRol)
    }

    suspend fun logOut() {
        dbRepository.deleteUserData()
    }
}