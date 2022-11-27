package com.segared.controlviviendas.usecases.dashboard.data.network

import com.segared.controlviviendas.usecases.dashboard.data.network.response.PermissionsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DashboardService @Inject constructor(private val dashboardClient: DashboardClient) {
    suspend fun getPermissions(idRol:Int): PermissionsResponse {
        return withContext(Dispatchers.IO) {
            val response = dashboardClient.getPermissionsList(10,idRol)
            if (response.body() == null) {
                throw Exception("Error")
            } else {
                response.body()!!
            }
        }
    }
}