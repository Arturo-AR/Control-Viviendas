package com.segared.controlviviendas.usecases.dashboard.data

import com.segared.controlviviendas.usecases.dashboard.data.network.DashboardService
import com.segared.controlviviendas.usecases.dashboard.data.network.response.PermissionsResponse
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val api: DashboardService,
) {

    suspend fun getPermissions(idRol: Int): PermissionsResponse {
        return api.getPermissions(idRol)
    }

}