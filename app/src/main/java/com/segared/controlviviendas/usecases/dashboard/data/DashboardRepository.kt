package com.segared.controlviviendas.usecases.dashboard.data

import com.segared.controlviviendas.core.data.repository.DataStoreRepository
import com.segared.controlviviendas.core.util.Constants.USER_ROL_DATA_STORE
import com.segared.controlviviendas.usecases.dashboard.data.network.DashboardService
import com.segared.controlviviendas.usecases.dashboard.data.network.response.PermissionsResponse
import javax.inject.Inject

class DashboardRepository @Inject constructor(
    private val api: DashboardService,
    private val dataStoreRepository: DataStoreRepository
) {

    suspend fun getPermissions(idRol: Int): PermissionsResponse {
        return api.getPermissions(idRol)
    }

    suspend fun logOut() {
        dataStoreRepository.deleteUserIdValue()
    }

    suspend fun getUserRol() : Int {
        return dataStoreRepository.getUserIdValue(USER_ROL_DATA_STORE) ?: 1 //Todo change per 0
    }

}